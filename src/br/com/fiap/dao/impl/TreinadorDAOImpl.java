package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TreinadorDAO;
import br.com.fiap.entity.Treinador;

public abstract class TreinadorDAOImpl extends GenericDAOImpl<Treinador, Integer> implements TreinadorDAO {

	public TreinadorDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}


}
