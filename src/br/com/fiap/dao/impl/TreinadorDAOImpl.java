package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TreinadorDAO;
import br.com.fiap.entity.Treinador;

public class TreinadorDAOImpl extends GenericDAOImpl<Treinador, Integer> implements TreinadorDAO {

	public TreinadorDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Treinador> lista(int xp) {
		return em.createNamedQuery("Treinador.xp", Treinador.class)
				.setParameter("xp", xp)
				.getResultList();
	}
	
	
	

}
