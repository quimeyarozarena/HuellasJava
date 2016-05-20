package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Complaints")
public class Complaint {

	@Column(name = "idComplaint", nullable = false)
    @Id
    @GeneratedValue
	private int idComplaint;
	
	@Column(name = "user", nullable = false)
	private boolean user;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
    @JoinColumn(name = "idComplaintCause", nullable = false) // FK
	private ComplaintCause complaintCause;
	
	@Column(name = "idReference", nullable = false)
	private int idReference;
	
	@Column(name = "accountant", nullable = false)
	private int accountant;
	
	@Column(name = "tableName", nullable = false)
	private String table;
	
	public Complaint() {
	}

	public int getIdComplaint() {
		return idComplaint;
	}

	public void setIdComplaint(int idComplaint) {
		this.idComplaint = idComplaint;
	}

	public boolean isUser() {
		return user;
	}

	public void setUser(boolean user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ComplaintCause getComplaintCause() {
		return complaintCause;
	}

	public void setComplaintCause(ComplaintCause complaintCause) {
		this.complaintCause = complaintCause;
	}

	public int getIdReference() {
		return idReference;
	}

	public void setIdReference(int idReference) {
		this.idReference = idReference;
	}

	public int getAccountant() {
		return accountant;
	}

	public void setAccountant(int accountant) {
		this.accountant = accountant;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}
}
