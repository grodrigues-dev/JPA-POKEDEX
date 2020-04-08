package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.entity.Cidade;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.ResourceNotFoundException;

public class CidadeDAOImpl extends GenericDAOImpl<Cidade, Integer> implements CidadeDAO {

	public CidadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}


}
