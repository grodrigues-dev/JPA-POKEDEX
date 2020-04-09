package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "TB_POKEMON")
@SequenceGenerator(name = "poke", sequenceName = "SQ_TB_POKEMON", allocationSize = 1)
public class Pokemon {
	
	@Id
	@GeneratedValue(generator = "poke", strategy = GenerationType.SEQUENCE)
	@Column(name = "CD_POKEMON")
	private int codigo; 
	
	@Column(name = "DS_RACA", nullable = false)
	private String raca; 
	
	@Column(name="VL_NIVEL", nullable = false) 
	private int nivel; 
	
	@Column(name = "DS_TIPO", nullable = false)
	@Enumerated(EnumType.STRING)
	private Tipos tipo;
	
	@Column(name = "DT_CAPTURA", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar captura; 
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CD_TREINADOR")
	private Treinador treinador;
	
	public Pokemon(String raca, int nivel, Tipos tipo, Calendar captura, Treinador treinador) {
		super();
		this.raca = raca;
		this.nivel = nivel;
		this.tipo = tipo;
		this.captura = captura;
		this.treinador = treinador;
	}


	public Pokemon() {
	}
	

	
	public Tipos getTipo() {
		return tipo;
	}

	public void setTipo(Tipos tipo) {
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Treinador getTreinador() {
		return treinador;
	}

	public void setTreinador(Treinador treinador) {
		this.treinador = treinador;
	} 
	
	
	
}
