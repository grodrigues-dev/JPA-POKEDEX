package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;


import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.ResourceNotFoundException;

public abstract class GenericDAOImpl <T, K>implements GenericDAO<T, K> {

	protected EntityManager em;

	protected Class<T> classe;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		this.classe = (Class<T>) ((ParameterizedType) getClass()
														.getGenericSuperclass())
														.getActualTypeArguments()[0];
	}

	@Override
	public void cadastrar(T entidade) {
		em.persist(entidade);
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	@Override
	public T pesquisar(K codigo) throws ResourceNotFoundException {
		return em.find(classe, codigo);
	}

	@Override
	public void deletar(K codigo) throws ResourceNotFoundException {
		T objeto = pesquisar(codigo);
		if (objeto == null) {
			throw new ResourceNotFoundException();
		}
		em.remove(objeto);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

	

}
