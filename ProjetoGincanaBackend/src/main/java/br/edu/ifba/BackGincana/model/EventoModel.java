package br.edu.ifba.BackGincana.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "tb_evento") /*   Configuração do nome da tabela !!! Deve ser Igual ao Banco de Dados !!!   */
public class EventoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Evento")
	private Integer id_Evento;

	@Column(name = "nome_Evento", length = 30, nullable = false)
	private String nome_Evento;

	@Column(name = "descricao_Evento", length = 200, nullable = false)
	private String descricao_Evento;

	@Column(name = "tipo_Evento", length = 15, nullable = false)
	private String tipo_Evento;

	@Column(name = "data_Evento", nullable = false)
	private Date data_Evento;

	@Column(name = "horario_Evento", length = 5, nullable = false)
	private String horario_Evento;

	@Column(name = "local_Evento", length = 20, nullable = false)
	private String local_Evento;

	@ManyToOne
	@JoinColumn(name = "id_gincana", nullable = false)
	private GincanaModel gincana;

	@ManyToOne
	@JoinColumn(name = "id_status", nullable = false)
	private StatusModel status;

	@OneToMany(mappedBy = "evento")
	private Set<CriterioModel> criterios = new HashSet<CriterioModel>();

	public EventoModel() {
		super();
	}

	public EventoModel(Integer id_Evento, String nome_Evento, String descricao_Evento, String tipo_Evento,
			Date data_Evento, String horario_Evento, String local_Evento, GincanaModel gincana, StatusModel status) {
		super();
		this.id_Evento = id_Evento;
		this.nome_Evento = nome_Evento;
		this.descricao_Evento = descricao_Evento;
		this.tipo_Evento = tipo_Evento;
		this.data_Evento = data_Evento;
		this.horario_Evento = horario_Evento;
		this.local_Evento = local_Evento;
		this.gincana = gincana;
		this.status = status;
		
	}

	public Integer getId_Evento() {
		return id_Evento;
	}

	public void setId_Evento(Integer id_Evento) {
		this.id_Evento = id_Evento;
	}

	public String getNome_Evento() {
		return nome_Evento;
	}

	public void setNome_Evento(String nome_Evento) {
		this.nome_Evento = nome_Evento;
	}

	public String getDescricao_Evento() {
		return descricao_Evento;
	}

	public void setDescricao_Evento(String descricao_Evento) {
		this.descricao_Evento = descricao_Evento;
	}

	public String getTipo_Evento() {
		return tipo_Evento;
	}

	public void setTipo_Evento(String tipo_Evento) {
		this.tipo_Evento = tipo_Evento;
	}

	public Date getData_Evento() {
		return data_Evento;
	}

	public void setData_Evento(Date data_Evento) {
		this.data_Evento = data_Evento;
	}

	public String getHorario_Evento() {
		return horario_Evento;
	}

	public void setHorario_Evento(String horario_Evento) {
		this.horario_Evento = horario_Evento;
	}

	public String getLocal_Evento() {
		return local_Evento;
	}

	public void setLocal_Evento(String local_Evento) {
		this.local_Evento = local_Evento;
	}

	public GincanaModel getGincana() {
		return gincana;
	}

	public void setGincana(GincanaModel gincana) {
		this.gincana = gincana;
	}

	public StatusModel getStatus() {
		return status;
	}

	public void setStatus(StatusModel status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "EventoModel [id_Evento=" + id_Evento + ", nome_Evento=" + nome_Evento + ", descricao_Evento="
				+ descricao_Evento + ", tipo_Evento=" + tipo_Evento + ", data_Evento=" + data_Evento
				+ ", horario_Evento=" + horario_Evento + ", local_Evento=" + local_Evento + ", gincana=" + gincana
				+ ", status=" + status + "]";
	}

}