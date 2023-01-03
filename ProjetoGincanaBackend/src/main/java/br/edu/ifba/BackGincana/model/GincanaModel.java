package br.edu.ifba.BackGincana.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity /*   Esse Anotation indica que essa classe representa uma entidade, ou seja, uma tabela do banco de dados   */
@Table(name = "tb_gincana") /*   Configuração do nome da tabela !!! Deve ser Igual ao Banco de Dados !!!   */
public class GincanaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Gincana", nullable = false)
	private Integer id_Gincana;

	@Column(name = "nome_Gincana", length = 45, nullable = false)
	private String nome_Gincana;

	@Column(name = "descricao_Gincana", length = 200, nullable = false)
	private String descricao_Gincana;

	@Column(name = "data_inicio_Gincana", nullable = false)
	private Date data_inicio_Gincana;

	@Column(name = "data_fim_Gincana", nullable = false)
	private Date data_fim_Gincana;

	@ManyToOne
	@JoinColumn(name = "id_Status")
	private StatusModel status;

	@OneToMany(mappedBy = "gincana", cascade = CascadeType.ALL)
	private Set<GaleriaModel> galerias = new HashSet<GaleriaModel>();

	@OneToMany(mappedBy = "gincana")
	private Set<UsuarioModel> usuarios = new HashSet<UsuarioModel>();

	@OneToMany(mappedBy = "gincana")
	private Set<EventoModel> eventos = new HashSet<EventoModel>();

	public GincanaModel() {
		super();
	}

	public GincanaModel(Integer id_Gincana, String nome_Gincana, String descricao_Gincana, Date data_inicio_Gincana,
			Date data_fim_Gincana, StatusModel status) {
		super();
		this.id_Gincana = id_Gincana;
		this.nome_Gincana = nome_Gincana;
		this.descricao_Gincana = descricao_Gincana;
		this.data_inicio_Gincana = data_inicio_Gincana;
		this.data_fim_Gincana = data_fim_Gincana;
		this.status = status;
		
	}

	public Integer getId_Gincana() {
		return id_Gincana;
	}

	public void setId_Gincana(Integer id_Gincana) {
		this.id_Gincana = id_Gincana;
	}

	public String getNome_Gincana() {
		return nome_Gincana;
	}

	public void setNome_Gincana(String nome_Gincana) {
		this.nome_Gincana = nome_Gincana;
	}

	public String getDescricao_Gincana() {
		return descricao_Gincana;
	}

	public void setDescricao_Gincana(String descricao_Gincana) {
		this.descricao_Gincana = descricao_Gincana;
	}

	public Date getData_inicio_Gincana() {
		return data_inicio_Gincana;
	}

	public void setData_inicio_Gincana(Date data_inicio_Gincana) {
		this.data_inicio_Gincana = data_inicio_Gincana;
	}

	public Date getData_fim_Gincana() {
		return data_fim_Gincana;
	}

	public void setData_fim_Gincana(Date data_fim_Gincana) {
		this.data_fim_Gincana = data_fim_Gincana;
	}

	public StatusModel getStatus() {
		return status;
	}

	public void setStatus(StatusModel status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GincanaModel [id_Gincana=" + id_Gincana + ", nome_Gincana=" + nome_Gincana + ", descricao_Gincana="
				+ descricao_Gincana + ", data_inicio_Gincana=" + data_inicio_Gincana + ", data_fim_Gincana="
				+ data_fim_Gincana + ", status=" + status + ", galerias=" + galerias + "]";
	}

}
