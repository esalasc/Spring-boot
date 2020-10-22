package com.spring.boot.backend.client.entity;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="tb_clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cte")
	private Long id;
	
	@Column(name="nombre_cte", nullable = false)
	@NotEmpty
	@Size(min = 4, max = 15)
	private String nombre;
	
	@Column(name="apellido_cte")
	@NotEmpty
	private String apellido;
	
	@Column(name="fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	
	@Column(name="email_cte",nullable = false, unique = true)
	@NotEmpty
	@NotNull
	@Email
	private String email;
	
	@javax.persistence.Transient
	private String puerto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	@PrePersist
	public void prePersist() {
		this.setFecha(new Date());
	}

}
