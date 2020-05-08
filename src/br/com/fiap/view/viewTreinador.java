package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.TreinadorDAO;
import br.com.fiap.dao.impl.TreinadorDAOImpl;
import br.com.fiap.entity.Treinador;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class viewTreinador {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		TreinadorDAO dao = new TreinadorDAOImpl(em);
		
		List<Treinador> lista = dao.lista(500);
		
		
		lista.forEach(t -> System.out.println(t.getNome() + " " + t.getXp()));
	}

}
