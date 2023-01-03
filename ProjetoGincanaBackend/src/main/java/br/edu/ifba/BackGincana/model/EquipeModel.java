package br.edu.ifba.BackGincana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity /*   Esse Anotation indica que essa classe representa uma entidade, ou seja, uma tabela do banco de dados   */
@Table(name = "tb_equipe") /*   Configuração do nome da tabela !!! Deve ser Igual ao Banco de Dados !!!   */
public class EquipeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Equipe", nullable = false)
	private Integer id_Equipe;

	@Column(name = "nome_Equipe", length = 20, nullable = false)
	private String nome_Equipe;

	@Column(name = "descricao_Equipe", length = 300, nullable = false)
	private String descricao_Equipe;

	@ManyToOne
	@JoinColumn(name = "id_Gincana", nullable = false)
	private GincanaModel gincana;

	@OneToOne
	@JoinColumn(name = "id_Curso")
	private CursoModel curso;

	@OneToOne
	@JoinColumn(name = "id_Usuario")
	private UsuarioModel usuario;

	public EquipeModel() {
		super();
	}

	public EquipeModel(Integer id_Equipe, String nome_Equipe, String descricao_Equipe, GincanaModel gincana,
			CursoModel curso, UsuarioModel usuario) {
		super();
		this.id_Equipe = id_Equipe;
		this.nome_Equipe = nome_Equipe;
		this.descricao_Equipe = descricao_Equipe;
		this.gincana = gincana;
		this.curso = curso;
		this.usuario = usuario;
	}

	public Integer getId_Equipe() {
		return id_Equipe;
	}

	public void setId_Equipe(Integer id_Equipe) {
		this.id_Equipe = id_Equipe;
	}

	public String getNome_Equipe() {
		return nome_Equipe;
	}

	public void setNome_Equipe(String nome_Equipe) {
		this.nome_Equipe = nome_Equipe;
	}

	public String getDescricao_Equipe() {
		return descricao_Equipe;
	}

	public void setDescricao_Equipe(String descricao_Equipe) {
		this.descricao_Equipe = descricao_Equipe;
	}

	public GincanaModel getGincana() {
		return gincana;
	}

	public void setGincana(GincanaModel gincana) {
		this.gincana = gincana;
	}

	public CursoModel getCurso() {
		return curso;
	}

	public void setCurso(CursoModel curso) {
		this.curso = curso;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "EquipeModel [id_Equipe=" + id_Equipe + ", nome_Equipe=" + nome_Equipe + ", descricao_Equipe="
				+ descricao_Equipe + ", gincana=" + gincana + ", curso=" + curso + ", usuario=" + usuario + "]";
	}

}
