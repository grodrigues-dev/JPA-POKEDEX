package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Ginasio;
import br.com.fiap.entity.Pokemon;

public interface GinasioDAO extends GenericDAO<Ginasio, Integer> {
	
	public List<Pokemon> listaPokemons(int cod);

}
