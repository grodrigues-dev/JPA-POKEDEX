package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Treinador;

public interface TreinadorDAO extends GenericDAO <Treinador, Integer> {

public List<Treinador> lista(int xp);
}

