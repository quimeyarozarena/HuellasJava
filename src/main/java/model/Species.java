package model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Species")
public class Species {
	
	@Column(name = "idSpecies", nullable = false)
    @Id
    @GeneratedValue
	private int idSpecies;
	
	@Column(name = "species", nullable = false)
	private String species;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "species", cascade = { CascadeType.MERGE })
	private List<Lost> lostList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "breed", cascade = { CascadeType.MERGE })
	private List<Breed> breedsList;
	
	public Species() {
		
	}

	public int getIdSpecies() {
		return idSpecies;
	}

	public void setIdSpecies(int idSpecies) {
		this.idSpecies = idSpecies;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public List<Lost> getLostList() {
		return lostList;
	}

	public void setLostList(List<Lost> lostList) {
		this.lostList = lostList;
	}

	public List<Breed> getBreedsList() {
		return breedsList;
	}

	public void setBreedsList(List<Breed> breedsList) {
		this.breedsList = breedsList;
	}
}
