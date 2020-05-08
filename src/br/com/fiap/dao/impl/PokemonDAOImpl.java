package br.com.fiap.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PokemonDAO;
import br.com.fiap.entity.Pokemon;
import br.com.fiap.entity.Tipos;

public class PokemonDAOImpl extends GenericDAOImpl<Pokemon, Integer> implements PokemonDAO {

	public PokemonDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pokemon> listar() {
		Query query = em.createQuery("from " + classe.getName(), classe);
		return query.getResultList();
	}

	@Override
	public List<Pokemon> listar(String nome) {
		TypedQuery<Pokemon> query = em.createQuery(
				"from Pokemon p where upper(p.raca) like upper(:nome) order by p.raca", Pokemon.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}

	@Override
	public List<Pokemon> getPokemonTreinador(int codTreinador) {
		TypedQuery<Pokemon> query = em.createQuery("from Pokemon p where p.treinador.codigo = :cod", Pokemon.class);
		query.setParameter("cod", codTreinador);
		return query.getResultList();
	}

	@Override
	public List<Pokemon> getPokemonByDate(Calendar d1, Calendar d2) {
		TypedQuery<Pokemon> query = em.createQuery("from Pokemon p where p.captura between :d1 and :d2", Pokemon.class);
		query.setParameter("d1", d1).setParameter("d2", d2);
		return query.getResultList();
	}

//	@Override
//	public List<Pokemon> listar(List<Tipos> tipos) {
//		List<Pokemon> lista = new ArrayList<Pokemon>();
//		for (Tipos t : tipos) {
//			TypedQuery<Pokemon> query = em.createQuery(
//					"from Pokemon p where p.tipo = :tipo", Pokemon.class);
//			query.setParameter("tipo", t);
//			lista.addAll(query.getResultList());
//		}
//		return lista;
//	}
//	
	
	public List <Pokemon> listar(List<Tipos> tipos){
		return em.createQuery("from Pokemon p where p.tipo in :ptipos", Pokemon.class)
				.setParameter("ptipos", tipos)
				.getResultList();
	}
 	

	public List<Pokemon> listar(Tipos t1, Tipos t2) {
		TypedQuery<Pokemon> query = em.createQuery("from Pokemon p where p.tipo in (:t1, :t2)", Pokemon.class);
		query.setParameter("t1", t1 );		
		query.setParameter("t2", t2 );
		return query.getResultList();
	}

	@Override
	public List<Pokemon> listar(String nome, int max, int min) {
		// TODO Auto-generated method stub
		return null;
	}

}
