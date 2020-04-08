package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PokemonDAO;
import br.com.fiap.entity.Pokemon;

public class PokemonDAOImpl extends GenericDAOImpl<Pokemon, Integer> implements PokemonDAO {

	public PokemonDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	

}
