package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ENTERPRISE_TB_TREINADOR")
@SequenceGenerator(name = "trein", sequenceName = "SQ_ENTERPRISE_TB_TREINADOR", allocationSize = 1)
public class Treinador {
	
	@Id
	@Column(name = "CD_TREINADOR")
	@GeneratedValue(generator = "trein", strategy = GenerationType.SEQUENCE)
	private int codigo; 
	
	@Column(name = "NM_TREINADOR", nullable = false)
	private String nome;
	
	@Column(name = "VL_XP")
	private int xp;
	
	@OneToMany(mappedBy = "treinador", cascade = CascadeType.PERSIST)
	private List<Pokemon> pokemons = new ArrayList<Pokemon>();
	
	@OneToOne(mappedBy = "lider", cascade = CascadeType.PERSIST)
	private Ginasio ginasio;
	
	@ManyToMany(mappedBy = "desafiantes", cascade = CascadeType.PERSIST)
	private List<Ginasio> desafios; 


	public Treinador(String nome, int xp) {
		super();
		this.nome = nome;
		this.xp = xp;
	}

	public Treinador() {
		super();
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}
	
	
	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}
	
	public void addPokemon(Pokemon pokemon) {
		pokemon.setTreinador(this); 
		this.pokemons.add(pokemon);
	}
		
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getXp() {
		return xp;
	}


	public void setXp(int xp) {
		this.xp = xp;
	}
	
	public Ginasio getGinasio() {
		return ginasio;
	}


	public void setGinasio(Ginasio ginasio) {
		this.ginasio = ginasio;
	}


	public List<Ginasio> getDesafios() {
		return desafios;
	}


	public void setDesafios(List<Ginasio> desafios) {
		this.desafios = desafios;
	}
	
}
