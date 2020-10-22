package com.spring.boot.backend.client.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_cursos")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_curso")
	private long idcurso;
	
	@Column(name = "nombre_curso")
	private String nombreCurso;
	
	@ManyToOne
	@JoinColumn(name="cliente_id_cte")
	private Cliente cliente;

	public long getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(long idcurso) {
		this.idcurso = idcurso;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
}
