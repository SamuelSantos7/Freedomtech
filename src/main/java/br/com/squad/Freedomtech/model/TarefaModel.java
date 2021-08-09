package br.com.squad.Freedomtech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_tarefa")
public class TarefaModel {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotNull
	private String linkAluno;// link de entrega

	@Column
	@NotNull
	private String descricaoTarefa;

	@Column
	@NotNull
	private String linkAuxiliar;// link de explicaçao
	
	/*@Column
	private String like;
	
	@Column
	private String deslike;*/
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new java.sql.Date(System.currentTimeMillis());

	
	/*
	 * @ManyToOne
	 * 
	 * @JsonIgnoreProperties("tarefa ") private UsuarioModel usuarios;
	 * 
	 * 
	 * 
	 * public UsuarioModel getUsuarios() { return usuarios;
	 * 
	 * 
	 * public void setUsuarios(UsuarioModel usuarios) { this.usuarios = usuarios;
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLinkAluno() {
		return linkAluno;
	}

	public void setLinkAluno(String linkAluno) {
		this.linkAluno = linkAluno;
	}

	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}

	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}

	public String getLinkAuxiliar() {
		return linkAuxiliar;
	}

	public void setLinkAuxiliar(String linkAuxiliar) {
		this.linkAuxiliar = linkAuxiliar;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}