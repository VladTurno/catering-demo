package it.uniroma3.siw.demo.model;

import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cognome;
	
	@Min(0)
	@Max(120)
	@NotNull
	private Integer eta;
	
	public Persona() {
		
	}
	
	public Persona(String nome, String cognome, Integer eta)  {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}
	
	public Long getId() {
		return this.id;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, eta, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(cognome, other.cognome) && eta == other.eta && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + "]";
	}

}
