package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.GinasioDAOImpl;
import br.com.fiap.dao.impl.TreinadorDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Ginasio;
import br.com.fiap.entity.Treinador;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.ResourceNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroCidadeGinasio {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance(); 
		EntityManager em = fabrica.createEntityManager();
		
		Cidade city = new Cidade("Lavender", "Route 33");
		
		TreinadorDAOImpl tDao = new TreinadorDAOImpl(em); 
		GinasioDAOImpl gDao = new GinasioDAOImpl(em); 
		
		try {
			Treinador lider = tDao.pesquisar(1);
			Ginasio gin = new Ginasio("Torre da Luta", city, lider);	
			gDao.cadastrar(gin);
			gDao.commit();
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		} catch (CommitException e) {
			e.printStackTrace();
		}

	}

}
