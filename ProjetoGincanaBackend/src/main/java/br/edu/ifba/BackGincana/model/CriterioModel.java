package br.edu.ifba.BackGincana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*   @Entity --> Esse Anotation indica que essa classe representa uma entidade, ou seja, uma tabela do banco de daos   
 *   @Table -->   Configuração do nome da tabela !!! Deve ser Igual ao Banco de Dados !!! 
 *   @Id --> classifica o atributo abaixo como o identidicador da tabela
 *   @GeneratedValue --> Gera ids sequênciais automaticamente ao inserirmos algo nessa tabela do banco
 *   @Column --> Configuração de tupla (linha) da tabela
 * */




@Entity 
@Table(name = "tb_criterio")
public class CriterioModel {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id_Criterio", nullable = false) 
	private Integer id_Criterio;

	@Column(name = "nome_Criterio", length = 30, nullable = false)
	private String nome_Criterio;

	@Column(name = "pontuacao_min_Criterio", nullable = false)
	private int pontuacao_min_Criterio;

	@Column(name = "pontuacao_max_Criterio", nullable = false)
	private int pontuacao_max_Criterio;

	@ManyToOne 
	@JoinColumn(name = "id_Evento", nullable = false)
	private EventoModel evento;

	public CriterioModel() {
		super();
	}

	public CriterioModel(Integer id_Criterio, String nome_Criterio, int pontuacao_min_Criterio,
			int pontuacao_max_Criterio, EventoModel evento) {
		super();
		this.id_Criterio = id_Criterio;
		this.nome_Criterio = nome_Criterio;
		this.pontuacao_min_Criterio = pontuacao_min_Criterio;
		this.pontuacao_max_Criterio = pontuacao_max_Criterio;
		this.evento = evento;
	}

	public Integer getId_Criterio() {
		return id_Criterio;
	}

	public void setId_Criterio(Integer id_Criterio) {
		this.id_Criterio = id_Criterio;
	}

	public String getNome_Criterio() {
		return nome_Criterio;
	}

	public void setNome_Criterio(String nome_Criterio) {
		this.nome_Criterio = nome_Criterio;
	}

	public int getPontuacao_min_Criterio() {
		return pontuacao_min_Criterio;
	}

	public void setPontuacao_min_Criterio(int pontuacao_min_Criterio) {
		this.pontuacao_min_Criterio = pontuacao_min_Criterio;
	}

	public int getPontuacao_max_Criterio() {
		return pontuacao_max_Criterio;
	}

	public void setPontuacao_max_Criterio(int pontuacao_max_Criterio) {
		this.pontuacao_max_Criterio = pontuacao_max_Criterio;
	}

	public EventoModel getEvento() {
		return evento;
	}

	public void setEvento(EventoModel evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "CriterioModel [id_criterio=" + id_Criterio + ", nome_Criterio=" + nome_Criterio
				+ ", pontuacao_min_Criterio=" + pontuacao_min_Criterio + ", pontuacao_max_Criterio="
				+ pontuacao_max_Criterio + ", evento=" + evento + "]";
	}

}
