package br.edu.ifba.BackGincana.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity /*   Esse Anotation indica que essa classe representa uma entidade, ou seja, uma tabela do banco de dados   */
@Table(name = "tb_perfil") /*   Configuração do nome da tabela !!! Deve ser Igual ao Banco de Dados !!!   */
public class PerfilModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Perfil", nullable = false)
	private Integer id_Perfil;

	@Column(name = "cargo_Perfil", length = 15, nullable = false)
	private String cargo_Perfil;

	@OneToMany(mappedBy = "perfil")
	private Set<UsuarioModel> usuarios = new HashSet<UsuarioModel>();

	public PerfilModel() {
		super();
	}

	public PerfilModel(Integer id_Perfil, String cargo_Perfil) {
		super();
		this.id_Perfil = id_Perfil;
		this.cargo_Perfil = cargo_Perfil;
	}

	public Integer getId_Perfil() {
		return id_Perfil;
	}

	public void setId_Perfil(Integer id_Perfil) {
		this.id_Perfil = id_Perfil;
	}

	public String getCargo_Perfil() {
		return cargo_Perfil;
	}

	public void setCargo_Perfil(String cargo_Perfil) {
		this.cargo_Perfil = cargo_Perfil;
	}

	@Override
	public String toString() {
		return "PerfilModel [id_Perfil=" + id_Perfil + ", cargo_Perfil=" + cargo_Perfil + ", usuarios=" + usuarios
				+ "]";
	}
	
	

}
