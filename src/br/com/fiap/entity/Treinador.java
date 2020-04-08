package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_TREINADOR")
@SequenceGenerator(name = "treinador", sequenceName = "SQ_TB_TREINADOR", allocationSize = 1)
public class Treinador {
	
	@Id
	@Column(name = "CD_TREINADOR")
	@GeneratedValue(generator = "treinador", strategy = GenerationType.SEQUENCE)
	private int codigo; 
	
	@Column(name = "NM_TREINADOR", nullable = false)
	private String nome;
	
	@Column(name = "VL_XP")
	private int xp;
	
	public Treinador(String nome, int xp) {
		super();
		this.nome = nome;
		this.xp = xp;
	}

	
	public Treinador() {
		super();
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
	
	
	
	
}
