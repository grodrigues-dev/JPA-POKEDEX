package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.GinasioDAO;
import br.com.fiap.dao.impl.GinasioDAOImpl;
import br.com.fiap.entity.Pokemon;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class viewGinasio {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		GinasioDAO dao = new GinasioDAOImpl(em);
				
		List<Pokemon> lista = dao.listaPokemons(3) ;
		
		lista.forEach(p -> System.out.println(p.getRaca()));
		
		em.close();
		fabrica.close();
	}
}
