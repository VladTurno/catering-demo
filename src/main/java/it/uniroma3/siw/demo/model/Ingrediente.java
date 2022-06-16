package it.uniroma3.siw.demo.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotBlank;

@Entity
@NamedQuery(name = "findAllIngredienti", query = "SELECT i FROM Ingrediente i")
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String origine;
	
	@NotBlank
	private String descrizione;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Piatto> piatti;
	
	public Ingrediente() {
		
	}
	
	public Ingrediente(String nome, String origine, String descrizione) {
		this.nome = nome;
		this.origine = origine;
		this.descrizione = descrizione;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Piatto> getPiatti() {
		return piatti;
	}

	public void setPiatti(List<Piatto> piatti) {
		this.piatti = piatti;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, descrizione, nome, origine, piatti);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(descrizione, other.descrizione)
				&& Objects.equals(nome, other.nome) && Objects.equals(origine, other.origine)
				&& Objects.equals(piatti, other.piatti);
	}

	@Override
	public String toString() {
		return "Ingrediente [nome=" + nome + ", origine=" + origine + ", descrizione=" + descrizione + "]";
	}

}
