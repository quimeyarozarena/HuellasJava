package model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Breeds")
public class Breed {
	
	@Column(name = "idBreed", nullable = false)
    @Id
    @GeneratedValue
	private int idBreed;
	
	@Column(name = "breed", nullable = false)
	private String breed;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
    @JoinColumn(name = "idSpecies", nullable = false) // FK
	private Species species;
	
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "breed", cascade = { CascadeType.MERGE })
	 private List<Lost> lostList;
	
	public Breed() {
	}

	public int getIdBreed() {
		return idBreed;
	}

	public void setIdBreed(int idBreed) {
		this.idBreed = idBreed;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public List<Lost> getLostList() {
		return lostList;
	}

	public void setLostList(List<Lost> lostList) {
		this.lostList = lostList;
	}
}
