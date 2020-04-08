package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_CIDADE")
@SequenceGenerator(name = "cidade", sequenceName = "SQ_TB_CIDADE", allocationSize = 1)
public class Cidade {
	
	@Id
	@GeneratedValue(generator = "cidade", strategy = GenerationType.SEQUENCE)
	@Column(name = "CD_CIDADE")
	private int codigo;
	
	@Column(name = "NM_CIDADE", nullable = false)
	private String nome; 
	
	@Column(name = "DS_LOCALIZACAO", nullable = false)
	private String localizacao;	
	
	public Cidade(String nome, String localizacao) {
		super();
		this.nome = nome;
		this.localizacao = localizacao;
	}
	
	public Cidade() {
		super();
	}

	public int getCoidgo() {
		
		return codigo;
	}
	public void setCoidgo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	} 
	
}
