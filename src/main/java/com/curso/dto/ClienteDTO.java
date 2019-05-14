package com.curso.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.curso.dominio.Cliente;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Campo Obrigatório")
	@Length(min = 5, max = 100, message = "Obrigatório de 5 a 100 caracteres")
	private String nome;

	@NotEmpty(message = "Campo Obrigatório")
	@Email(message = "Email Invalido !")
	private String email;

	public ClienteDTO() {
	}

	public ClienteDTO(Cliente obj) {
		setId(obj.getId());
		nome = obj.getNome();
		email = obj.getEmail();
	}

	public ClienteDTO(Integer id, String nome, String email) {
		super();
		this.setId(id);
		this.nome = nome;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
