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
@Table(name = "Comments")
public class Comment {
	
	@Column(name = "idComment", nullable = false)
    @Id
    @GeneratedValue
	private int idComment;
	
	@Column(name = "comment", nullable = false)
	private String comment;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
    @JoinColumn(name = "idPerson", nullable = false) // FK
	private Person person;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
    @JoinColumn(name = "idAdditional", nullable = false) // FK
	private Additional additional;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
    @JoinColumn(name = "idPerdido", nullable = false) // FK
	private Lost lost;
	
	@Column(name = "readComment", nullable = false)
	private boolean read;
	
	@Column(name = "locked", nullable = false)
	private boolean locked;
	
	public Comment() {
	}

	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Additional getAdditional() {
		return additional;
	}

	public void setAdditional(Additional additional) {
		this.additional = additional;
	}

	public Lost getLost() {
		return lost;
	}

	public void setLost(Lost lost) {
		this.lost = lost;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}
