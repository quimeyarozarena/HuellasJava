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
@Table(name = "Ages")
public class Age {

	@Column(name = "idAge", nullable = false)
    @Id
    @GeneratedValue
	private int idAge;
	
	@Column(name = "age", nullable = false)
	private String age;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "age", cascade = { CascadeType.MERGE })
	private List<Lost> lost;

	public Age() {
	}

	public int getIdAge() {
		return idAge;
	}

	public void setIdAge(int idAge) {
		this.idAge = idAge;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public List<Lost> getLost() {
		return lost;
	}

	public void setLost(List<Lost> lost) {
		this.lost = lost;
	}
}
