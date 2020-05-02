package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.TreinadorDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.TreinadorDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Ginasio;
import br.com.fiap.entity.Treinador;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.ResourceNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CascadeGinasio {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance(); 
		EntityManager em = fabrica.createEntityManager();
		
		TreinadorDAO dao = new TreinadorDAOImpl(em);
		CidadeDAO Cdao = new CidadeDAOImpl(em);

		Treinador t = new Treinador("Thingol", 3600);
		
		try {
			Cidade c = Cdao.pesquisar(1);
			Ginasio gim = new Ginasio("Passo do Sírion", c, t);
			t.setGinasio(gim);
			dao.cadastrar(t);
			dao.commit();
			
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		em.close();
		fabrica.close();
		
		
		
		
	}

}
