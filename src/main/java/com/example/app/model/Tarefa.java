package com.example.app.model;

import java.time.LocalDate;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tarefas")
public class Tarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTarefa")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "data")
	private LocalDate data;
	@Column(name = "concluida")
	private boolean concluida;

	private Long idUsuario;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "idUsuario")
//	@JsonBackReference
//	private Usuario usuario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}

	public Long getId() {
		return id;
	}

}
