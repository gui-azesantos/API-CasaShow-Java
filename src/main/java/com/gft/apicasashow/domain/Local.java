package com.gft.apicasashow.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Local", description = "Representa uma casa de show")
@Entity
public class Local {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Nome é obrigatório!")
	@Size(max = 60, message = "O nome não pode conter mais de 60 caracteres!")
	private String nome;

	@NotEmpty(message = "Endereço é obrigatório!")
	@Size(max = 60, message = "O endereço não pode conter mais de 60 caracteres!")
	private String endereco;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "local")
	List<Evento> evento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Evento> getEvento() {
		return evento;
	}

	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}
	
	
}
