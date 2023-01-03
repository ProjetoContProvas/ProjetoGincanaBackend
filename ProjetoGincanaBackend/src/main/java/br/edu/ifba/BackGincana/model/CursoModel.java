package br.edu.ifba.BackGincana.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity /*   Esse Anotation indica que essa classe representa uma entidade, ou seja, uma tabela do banco de dados   */
@Table(name = "tb_curso") /*   Configuração do nome da tabela !!! Deve ser Igual ao Banco de Dados !!!   */
public class CursoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Curso", nullable = false)
	private Integer id_Curso;

	@Column(name = "nome_Curso", length = 25, nullable = false)
	private String nome_Curso;

	@Column(name = "modalidade_Curso", length = 12, nullable = false)
	private String modalidade_Curso;

	@OneToOne(mappedBy = "curso")
	private EquipeModel equipe;

	public CursoModel() {
		super();
	}

	public CursoModel(Integer id_Curso, String nome_Curso, String modalidade_Curso) {
		super();
		this.id_Curso = id_Curso;
		this.nome_Curso = nome_Curso;
		this.modalidade_Curso = modalidade_Curso;
	}

	public Integer getId_Curso() {
		return id_Curso;
	}

	public void setId_curso(Integer id_Curso) {
		this.id_Curso = id_Curso;
	}

	public String getNome_Curso() {
		return nome_Curso;
	}

	public void setNome_Curso(String nome_Curso) {
		this.nome_Curso = nome_Curso;
	}

	public String getModalidade_Curso() {
		return modalidade_Curso;
	}

	public void setModalidade_Curso(String modalidade_Curso) {
		this.modalidade_Curso = modalidade_Curso;
	}

	@Override
	public String toString() {
		return "CursoModel [id_curso=" + id_Curso + ", nome_Curso=" + nome_Curso + ", modalidade_Curso="
				+ modalidade_Curso + ", equipes=" + equipe + "]";
	}
	
	

}
