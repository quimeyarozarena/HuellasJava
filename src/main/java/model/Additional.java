package model;

import java.util.Date;
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
@Table(name = "Additional")
public class Additional {

	@Column(name = "idAdditional", nullable = false)
    @Id
    @GeneratedValue
	private int idAdditional;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
    @JoinColumn(name = "idStatus", nullable = false) // FK
	private Status status;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
    @JoinColumn(name = "idPerson", nullable = false) // FK
	private Person person;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "additional", cascade = { CascadeType.MERGE })
	private List<Comment> commentsList;
	
	@Column(name = "foto", nullable = false)
	private String photo;
	
	@Column(name = "donacion", nullable = false)
	private boolean donation;
	
	public Additional() {
	
	}

	public int getIdAdditional() {
		return idAdditional;
	}

	public void setIdAdditional(int idAdditional) {
		this.idAdditional = idAdditional;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Comment> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<Comment> commentsList) {
		this.commentsList = commentsList;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isDonation() {
		return donation;
	}

	public void setDonation(boolean donation) {
		this.donation = donation;
	}
}
