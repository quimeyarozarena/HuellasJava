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
@Table(name = "Sizes")
public class Size {
	
	@Column(name = "idSize", nullable = false)
    @Id
    @GeneratedValue
	private int idSize;
	
	@Column(name = "size", nullable = false)
	private String size;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "size", cascade = { CascadeType.MERGE })
	private List<Lost> lostList;
	
	public Size() {
	}

	public int getIdSize() {
		return idSize;
	}

	public void setIdSize(int idSize) {
		this.idSize = idSize;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<Lost> getLostList() {
		return lostList;
	}

	public void setLostList(List<Lost> lostList) {
		this.lostList = lostList;
	}
}
