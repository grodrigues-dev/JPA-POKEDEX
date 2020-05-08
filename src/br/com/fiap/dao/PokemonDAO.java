package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pokemon;
import br.com.fiap.entity.Tipos;

public interface PokemonDAO extends GenericDAO<Pokemon, Integer>{
	
	public List<Pokemon> listar();
	
	public List<Pokemon> listar(String nome);
	
	public List<Pokemon> listar(String nome, int max, int min);
	
	public List<Pokemon> listar(List<Tipos> tipos);
	
	public List<Pokemon> listar(Tipos t1 , Tipos t2);
	
	
	public List<Pokemon> getPokemonTreinador (int codTreinador); 
	
	public List<Pokemon> getPokemonByDate(Calendar d1, Calendar d2);
}
