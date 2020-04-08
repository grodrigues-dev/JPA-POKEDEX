package br.com.fiap.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
	//cria a fabrica
	private static EntityManagerFactory fabrica;
	
	//contratutor privado
	private EntityManagerFactorySingleton() {}
	
	//cria e retorna a unica instancia
	public static EntityManagerFactory getInstance() {
		 if (fabrica == null) fabrica = Persistence.createEntityManagerFactory("oracle");
		return fabrica;
	}
}
