package it.uniroma3.siw.demo.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
@NamedQuery(name = "findAllChefs", query = "SELECT c FROM Chef c")
public class Chef {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cognome;
	
	@NotBlank
	private String nazionalita;
	
	@OneToMany(mappedBy = "chef", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Buffet> buffets;
	
	public Chef() {
		
	}
	
	public Chef(String nome, String cognome, String nazionalita) {
		this.nome = nome;
		this.cognome = cognome;
		this.nazionalita = nazionalita;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public List<Buffet> getBuffets() {
		return buffets;
	}

	public void setBuffets(List<Buffet> buffets) {
		this.buffets = buffets;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, buffets, cognome, nazionalita, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chef other = (Chef) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(buffets, other.buffets)
				&& Objects.equals(cognome, other.cognome) && Objects.equals(nazionalita, other.nazionalita)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Chef [nome=" + nome + ", cognome=" + cognome + ", nazionalita=" + nazionalita + "]";
	}

}
