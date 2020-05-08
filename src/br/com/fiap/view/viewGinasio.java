package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.GinasioDAO;
import br.com.fiap.dao.impl.GinasioDAOImpl;
import br.com.fiap.entity.Ginasio;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class viewGinasio {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		GinasioDAO dao = new GinasioDAOImpl(em);
				
//		List<Pokemon> lista = dao.listaPokemons(1) ;
		
		List<Ginasio> lista = dao.lista();
		
		lista.forEach(g-> System.out.println(g.getNome() + " " + g.getLider().getNome()));
//		
//		System.out.println("Quantidade de pokemons em caverna do dragão " + dao.contar(3));
//		System.out.println("A soma total do nivel dos pokemons é " + dao.dificuldade(3));
//		
		
		
//		lista.forEach(p -> System.out.println(p.getRaca()));
		
		em.close();
		fabrica.close();
	}
}
