package it.uniroma3.siw.demo.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
@NamedQuery(name = "findAllBuffets", query = "SELECT b FROM Buffet b")
public class Buffet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String descrizione;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Chef chef;
	
	@OneToMany(mappedBy = "buffet", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Piatto> portate;
	
	public Buffet() {
		
	}
	
	public Buffet(String nome,String descrizione, Chef chef) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.chef = chef;
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

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public List<Piatto> getPortate() {
		return portate;
	}

	public void setPortate(List<Piatto> portate) {
		this.portate = portate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, chef, descrizione, nome, portate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Buffet other = (Buffet) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(chef, other.chef)
				&& Objects.equals(descrizione, other.descrizione) && Objects.equals(nome, other.nome)
				&& Objects.equals(portate, other.portate);
	}

	@Override
	public String toString() {
		return "Buffet [nome=" + nome + ", descrizione=" + descrizione + ", chef=" + chef + "]";
	}

}
