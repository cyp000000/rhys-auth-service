package za.co.infowarestudios.selpal.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by chrismipi on 2015/12/23.
 */
@Entity
public class User {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true)
	private String userId;

	@Column
	private String emailAddress;

	@Column
	private String firstName;

	@JsonIgnore
	@Column
	private String pin;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Role role;

	@JsonIgnore
	@Column
	private Boolean active;

	@JsonIgnore
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone="CAT")
	private DateTime created;

	@JsonIgnore
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone="CAT")
	private DateTime modified;

	@Column(unique = true)
	private String contact;

	@Column
	private String lastName;

	@Column(unique = true)
	private String identificationNumber;

	public User() {
	}

	public User(String userId, String emailAddress, String pin, String firstName, Role role) {
		this.userId = userId;
		this.emailAddress = emailAddress;
		this.pin = pin;
		this.role = role;
		this.active = false;
		this.firstName = firstName;
		this.created = new DateTime();
		this.modified = new DateTime();
	}

	public User(String userId, String emailAddress, String firstName, String lastName, String contact, Role role) {
		this.userId = userId;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.contact = contact;
		this.active = false;
		this.pin = ""; // this is the default PIN
		this.created = new DateTime();
		this.modified = new DateTime();
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String email) {
		this.emailAddress = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public DateTime getCreated() {
		return created;
	}

	public DateTime getModified() {
		return modified;
	}

	public void setModified(DateTime modified) {
		this.modified = modified;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public long getId() {
		return id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

}
