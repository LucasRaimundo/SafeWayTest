package com.lucasraimundo.safeway.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UsuarioNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String name;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	@Email(message="E-mail inválido")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	private String cpf;
	
	
	
	@NotEmpty(message="Preenchimento obrigatorio")
	private String password;
	
	
	
	public UsuarioNewDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
