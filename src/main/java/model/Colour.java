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
@Table(name = "Colours")
public class Colour {
	
	@Column(name = "idColour", nullable = false)
    @Id
    @GeneratedValue
	private int idColour;
	
	@Column(name = "colour", nullable = false)
	private String colour;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colour", cascade = { CascadeType.MERGE })
	 private List<Lost> lostList;
	
	
	public Colour() {
	}


	public int getIdColour() {
		return idColour;
	}


	public void setIdColour(int idColour) {
		this.idColour = idColour;
	}


	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public List<Lost> getLostList() {
		return lostList;
	}


	public void setLostList(List<Lost> lostList) {
		this.lostList = lostList;
	}

	
}
