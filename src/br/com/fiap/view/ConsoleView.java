package br.com.fiap.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.PokemonDAOImpl;
import br.com.fiap.dao.impl.TreinadorDAOImpl;
import br.com.fiap.entity.Pokemon;
import br.com.fiap.entity.Tipos;
import br.com.fiap.entity.Treinador;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.ResourceNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;



public class ConsoleView {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance(); 
		EntityManager em = fabrica.createEntityManager();
		
		PokemonDAOImpl pokeDao = new PokemonDAOImpl(em);
		
		TreinadorDAOImpl treinadorDao = new TreinadorDAOImpl(em);
		
		try {
			Treinador ash = treinadorDao.pesquisar(1);
			Pokemon charizard = new Pokemon("Gloom", 25, Tipos.GRAMA, Calendar.getInstance(), ash);
			pokeDao.cadastrar(charizard);
		} catch (ResourceNotFoundException e) {			
			e.printStackTrace();
		}
		
		
		//Treinador ash = new Treinador("ash", 12527);
		
		try {
			pokeDao.commit();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
