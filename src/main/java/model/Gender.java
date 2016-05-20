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
@Table(name = "Genders")
public class Gender {

	@Column(name = "idGender", nullable = false)
    @Id
    @GeneratedValue
	private int idGender;
	
	@Column(name = "gender", nullable = false)
	private String gender;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gender", cascade = { CascadeType.MERGE })
	private List<Lost> lostList;
	
	
	public Gender() {
	}


	public int getIdGender() {
		return idGender;
	}


	public void setIdGender(int idGender) {
		this.idGender = idGender;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public List<Lost> getLostList() {
		return lostList;
	}


	public void setLostList(List<Lost> lostList) {
		this.lostList = lostList;
	}
}
