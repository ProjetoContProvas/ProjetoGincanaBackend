package br.edu.ifba.BackGincana.model;

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
@Table(name = "tb_galeria") /*   Configuração do nome da tabela !!! Deve ser Igual ao Banco de Dados !!!   */
public class GaleriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Galeria")
	private Integer id_Galeria;

	@Column(name = "nome_Galeria", length = 30, nullable = false)
	private String nome_Galeria;

	@Column(name = "descricao_Galeria", length = 300, nullable = false)
	private String descricao_Galeria;

	@ManyToOne
	@JoinColumn(name = "id_Gincana")
	private GincanaModel gincana;

	@OneToMany(mappedBy = "galeria")
	private Set<ImagemModel> imagens = new HashSet<ImagemModel>();

	public GaleriaModel() {
		super();
	}

	public GaleriaModel(Integer id_Galeria, String nome_Galeria, String descricao_Galeria, GincanaModel gincana) {
		super();
		this.id_Galeria = id_Galeria;
		this.nome_Galeria = nome_Galeria;
		this.descricao_Galeria = descricao_Galeria;
		this.gincana = gincana;
	}

	public Integer getId_Galeria() {
		return id_Galeria;
	}

	public void setId_Galeria(Integer id_Galeria) {
		this.id_Galeria = id_Galeria;
	}

	public String getNome_Galeria() {
		return nome_Galeria;
	}

	public void setNome_Galeria(String nome_Galeria) {
		this.nome_Galeria = nome_Galeria;
	}

	public String getDescricao_Galeria() {
		return descricao_Galeria;
	}

	public void setDescricao_Galeria(String descricao_Galeria) {
		this.descricao_Galeria = descricao_Galeria;
	}

	public GincanaModel getGincana() {
		return gincana;
	}

	public void setGincana(GincanaModel gincana) {
		this.gincana = gincana;
	}
    /*
	public Set<ImagemModel> getImagens() {
		return imagens;
	}

	public void setImagens(Set<ImagemModel> imagens) {
		this.imagens = imagens;
	}*/

	@Override
	public String toString() {
		return "GaleriaModel [id_Galeria=" + id_Galeria + ", nome_Galeria=" + nome_Galeria + ", descricao_Galeria="
				+ descricao_Galeria + ", gincana=" + gincana + ", imagens=" + imagens + "]";
	}

}
