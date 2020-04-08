package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GinasioDAO;
import br.com.fiap.entity.Ginasio;

public class GinasioDAOImpl extends GenericDAOImpl<Ginasio, Integer> implements GinasioDAO{

	public GinasioDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
