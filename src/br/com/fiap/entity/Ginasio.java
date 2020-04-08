package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_GINASIO")
@SequenceGenerator(name = "gin", sequenceName = "SQ_TB_GINASIO" , allocationSize = 1)
public class Ginasio {
	
	@Id
	@Column(name = "CD_GINASIO")
	private int codigo; 
	
	@Column(name = "NM_GINASIO", nullable = false)
	private String nome; 
	
	@OneToOne
	@JoinColumn(name = "CD_CIDADE")
	private Cidade cidade;
	
	@OneToOne
	@JoinColumn(name = "CD_TREINADOR")
	private Treinador lider;
	
	
	public Ginasio(String nome, Cidade cidade, Treinador lider) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.lider = lider;
	}
	
	public Ginasio() {
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
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Treinador getLider() {
		return lider;
	}
	public void setLider(Treinador lider) {
		this.lider = lider;
	} 
	
	
}
