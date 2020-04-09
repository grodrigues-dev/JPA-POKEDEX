
package br.com.fiap.dao;

import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.ResourceNotFoundException;

public interface GenericDAO<T, K> {
	void cadastrar(T entidade);
	void atualizar(T entidade);
	T pesquisar(K id) throws ResourceNotFoundException;
	
	void deletar (K id) throws ResourceNotFoundException;
	
	void commit() throws CommitException;
}
