package br.com.fiap.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.PokemonDAO;
import br.com.fiap.dao.impl.PokemonDAOImpl;
import br.com.fiap.entity.Pokemon;
import br.com.fiap.entity.Tipos;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class viewPokemon2 {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		PokemonDAO dao = new PokemonDAOImpl(em);
		
		List<Tipos> tipos = new ArrayList<Tipos>();
		tipos.add(Tipos.NORMAL);
		tipos.add(Tipos.INSETO);
		tipos.add(Tipos.LUTADOR);
		
		List<Pokemon> lista = dao.listar("h"); 
		
		
//		List <Pokemon> lista = dao.listar(Tipos.NORMAL, Tipos.INSETO);
		
		lista.forEach(p -> System.out.println(p.getRaca() + " " + p.getTipo()));
	
		
	}
}
