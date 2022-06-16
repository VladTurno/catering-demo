package it.uniroma3.siw.demo.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotBlank;

@Entity
@NamedQuery(name = "findAllPiatti", query = "SELECT p FROM Piatto p")
public class Piatto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String descrizione;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Buffet buffet;
	
	@ManyToMany(mappedBy = "piatti", fetch = FetchType.EAGER)
	private List<Ingrediente> ingredienti;
	
	public Piatto() {
		
	}
	
	public Piatto(String nome, String descrizione, Buffet buffet) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.buffet = buffet;
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Buffet getBuffet() {
		return buffet;
	}

	public void setBuffet(Buffet buffet) {
		this.buffet = buffet;
	}

	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, buffet, descrizione, ingredienti, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piatto other = (Piatto) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(buffet, other.buffet)
				&& Objects.equals(descrizione, other.descrizione) && Objects.equals(ingredienti, other.ingredienti)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Piatto [nome=" + nome + ", descrizione=" + descrizione + ", ingredienti=" + ingredienti + "]";
	}
	
}
