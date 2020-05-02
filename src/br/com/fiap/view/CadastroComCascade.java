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
import br.com.fiap.exceptions.ResourceNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroComCascade {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance(); 
		EntityManager em = fabrica.createEntityManager();
		
		TreinadorDAO treinadorDao = new TreinadorDAOImpl(em);
		
		PokemonDAO pokeDao = new PokemonDAOImpl(em);
		
		
		try {
			Treinador t = treinadorDao.pesquisar(3);
			Pokemon p1 = new Pokemon("Hitmonlee", 32, Tipos.LUTADOR, Calendar.getInstance());
			Pokemon p2 = new Pokemon("Kabutops", 29, Tipos.PEDRA, Calendar.getInstance());
			Pokemon p3 = new Pokemon("Hypno", 38, Tipos.PSIQUÍCO, Calendar.getInstance());
//			
			
			List<Pokemon> lista = new ArrayList<Pokemon>();
			lista.add(p1);
			lista.add(p2);
			lista.add(p3);
			for (Pokemon p : lista) {			
				p.setTreinador(t);
				pokeDao.cadastrar(p);
				pokeDao.commit();
			}
			
//			treinadorDao.cadastrar(t);
			
		} catch (ResourceNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		em.close();
		fabrica.close();

	}

}
