package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.PokemonDAO;
import br.com.fiap.dao.TreinadorDAO;
import br.com.fiap.dao.impl.PokemonDAOImpl;
import br.com.fiap.dao.impl.TreinadorDAOImpl;
import br.com.fiap.entity.Pokemon;
import br.com.fiap.entity.Tipos;
import br.com.fiap.entity.Treinador;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroComCascade {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance(); 
		EntityManager em = fabrica.createEntityManager();
		
		TreinadorDAO treinadorDao = new TreinadorDAOImpl(em);
		
		PokemonDAO pokeDao = new PokemonDAOImpl(em);
		
		Treinador t = new Treinador("Capeta", 100);
		
		Pokemon p1 = new Pokemon("Jinx", 25, Tipos.NORMAL, Calendar.getInstance());
		Pokemon p2 = new Pokemon("Heracross", 12, Tipos.INSETO, Calendar.getInstance());
		Pokemon p3 = new Pokemon("Squirtle", 10, Tipos.ÁGUA, Calendar.getInstance());
		
		List<Pokemon> lista = new ArrayList<Pokemon>();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		
		for (Pokemon p : lista) t.addPokemon(p);
		
		treinadorDao.cadastrar(t);
		
		
		try {
			treinadorDao.commit();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		em.close();
		fabrica.close();

	}

}
