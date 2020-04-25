package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_GINASIO")
@SequenceGenerator(name = "gin", sequenceName = "SQ_TB_GINASIO" , allocationSize = 1)
public class Ginasio {
	
	@Id
	@Column(name = "CD_GINASIO")
	@GeneratedValue(generator = "gin", strategy = GenerationType.SEQUENCE)
	private int codigo; 
	
	@Column(name = "NM_GINASIO", nullable = false)
	private String nome; 
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CD_CIDADE", unique= true)
	private Cidade cidade;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CD_TREINADOR", unique = true)
	private Treinador lider;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "TB_BATALHAS", 
			joinColumns = @JoinColumn(name= "CD_GINASIO"), 
			inverseJoinColumns = @JoinColumn(name="CD_TREINADOR"))
	private List<Treinador> desafiantes;
	
	
	public List<Treinador> getDesafiantes() {
		return desafiantes;
	}

	public void setDesafiantes(List<Treinador> desafiantes) {
		this.desafiantes = desafiantes;
	}

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
