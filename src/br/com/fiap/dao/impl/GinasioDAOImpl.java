package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.GinasioDAO;
import br.com.fiap.entity.Ginasio;
import br.com.fiap.entity.Pokemon;

public class GinasioDAOImpl extends GenericDAOImpl<Ginasio, Integer> implements GinasioDAO{

	public GinasioDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pokemon> listaPokemons(int cod) {
		TypedQuery<Pokemon> query = em.createQuery(
				"from Pokemon p where p.treinador.ginasio.codigo = :cod ", Pokemon.class);
		query.setParameter("cod", cod);
		return query.getResultList();
	}

	@Override
	public long contar(int cod) {
		return em.createQuery(
				"select count(p) from Pokemon p where p.treinador.ginasio.codigo = :cod ",
				Long.class)
				.setParameter("cod", cod)
				.getSingleResult();
				
	}

	@Override
	public long dificuldade(int cod) {
		return em.createQuery("select sum(p.nivel) from Pokemon p where p.treinador.ginasio.codigo = :cod", 
				Long.class)
				.setParameter("cod", cod)
				.getSingleResult();
	}

	@Override
	public List<Ginasio> lista() {
		// TODO Auto-generated method stub
		return em.createNativeQuery(
				"SELECT * FROM ENTERPRISE_TB_GINASIO", 
				Ginasio.class)
					.getResultList();
				
	}

}
