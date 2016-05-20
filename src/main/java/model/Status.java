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
@Table(name = "Statuses")
public class Status {

	@Column(name = "idStatus", nullable = false)
    @Id
    @GeneratedValue
	private int idStatus;
	
	@Column(name = "situation", nullable = false)
	private String situation;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "status", cascade = { CascadeType.MERGE })
	private List<Additional> additionalList;
	
	public Status() {
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public List<Additional> getAdditionalList() {
		return additionalList;
	}

	public void setAdditionalList(List<Additional> additionalList) {
		this.additionalList = additionalList;
	}
}
