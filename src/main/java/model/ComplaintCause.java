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
@Table(name = "ComplaintCauses")
public class ComplaintCause {
	
	@Column(name = "idComplaintCause", nullable = false)
    @Id
    @GeneratedValue
	private int idComplaintCause;
	
	@Column(name = "cause", nullable = false)
	private String cause;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "complaintCause", cascade = { CascadeType.MERGE })
	private List<Complaint> complaintsList;
	
	public ComplaintCause() {
	}

	public int getIdComplaintCause() {
		return idComplaintCause;
	}

	public void setIdComplaintCause(int idComplaintCause) {
		this.idComplaintCause = idComplaintCause;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public List<Complaint> getComplaintsList() {
		return complaintsList;
	}

	public void setComplaintsList(List<Complaint> complaintsList) {
		this.complaintsList = complaintsList;
	}
}
