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
@Table(name = "Persons")
public class Person {
	
	@Column(name = "idPerson", nullable = false)
    @Id
    @GeneratedValue
	private int idPerson;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "lastname", nullable = false)
	private String lastname;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "administrator", nullable = false)
	private boolean administrator;
	
	@Column(name = "locked", nullable = false)
	private boolean locked;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = { CascadeType.MERGE })
	private List<Lost> lostList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = { CascadeType.MERGE })
	private List<Comment> commentsList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = { CascadeType.MERGE })
	private List<Additional> additionalList;
	
	public Person() {
	}
	
	public Person(int idPerson, String name, String lastname, String email, String phone, String password,
			boolean administrator, boolean locked) {
		this.idPerson = idPerson;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.administrator = administrator;
		this.locked = locked;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public List<Lost> getLostList() {
		return lostList;
	}

	public void setLostList(List<Lost> lostList) {
		this.lostList = lostList;
	}

	public List<Comment> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<Comment> commentsList) {
		this.commentsList = commentsList;
	}

	public List<Additional> getAdditionalList() {
		return additionalList;
	}

	public void setAdditionalList(List<Additional> additionalList) {
		this.additionalList = additionalList;
	}
}
