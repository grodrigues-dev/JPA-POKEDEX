package br.com.fiap.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.PokemonDAO;
import br.com.fiap.dao.impl.PokemonDAOImpl;
import br.com.fiap.entity.Pokemon;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class viewPokemon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		PokemonDAO dao = new PokemonDAOImpl(em);
		
		Calendar d1 = Calendar.getInstance();
		
		Calendar d2 = new GregorianCalendar(2020,3,24,13,24,56);
		System.out.println(d1 + "\n" + d2.getTime());
		
		List<Pokemon> lista = dao.getPokemonByDate(d2, d1);
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		
		lista.forEach(p -> System.out.println(p.getRaca() + " " +
				sdf.format(p.getCaptura().getTime())));
		
		em.close();
		fabrica.close();
	}

}
