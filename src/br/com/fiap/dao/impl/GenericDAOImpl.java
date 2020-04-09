package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.ResourceNotFoundException;

public abstract class GenericDAOImpl <T, K>implements GenericDAO<T, K> {

	private EntityManager entityManager;

	private Class<T> classe;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.classe = (Class<T>) ((ParameterizedType) getClass()
														.getGenericSuperclass())
														.getActualTypeArguments()[0];
	}

	@Override
	public void cadastrar(T entidade) {
		entityManager.persist(entidade);
	}

	@Override
	public void atualizar(T entidade) {
		entityManager.merge(entidade);
	}

	@Override
	public T pesquisar(K codigo) throws ResourceNotFoundException {
		return entityManager.find(classe, codigo);
	}

	@Override
	public void deletar(K codigo) throws ResourceNotFoundException {
		T objeto = pesquisar(codigo);
		if (objeto == null) {
			throw new ResourceNotFoundException();
		}
		entityManager.remove(objeto);
	}

	@Override
	public void commit() throws CommitException {
		try {
			entityManager.getTransaction().begin();
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new CommitException();
		}
	}

	

}
