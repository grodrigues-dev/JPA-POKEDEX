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



public class CadastroPokemonTreinador {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance(); 
		EntityManager em = fabrica.createEntityManager();
		
		PokemonDAOImpl pokeDao = new PokemonDAOImpl(em);
		
		TreinadorDAOImpl treinadorDao = new TreinadorDAOImpl(em);
		
		Treinador treinador = new Treinador("Blaine", 12527);
		
		Pokemon charizard = new Pokemon("Magma", 33, Tipos.FOGO, Calendar.getInstance(), treinador);
		pokeDao.cadastrar(charizard);
		
		try {
			pokeDao.commit(); 
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
