package za.co.infowarestudios.entity;

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

	@JsonIgnore
	@Column
	private String password;

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


	public User() {
	}

	public User(String userId, String emailAddress, String password, Role role) {
		this.userId = userId;
		this.emailAddress = emailAddress;
		this.password = password;
		this.role = role;
		this.active = false;
		this.created = new DateTime();
		this.modified = new DateTime();
	}

	public User(String userId, String emailAddress, Role role) {
		this.userId = userId;
		this.emailAddress = emailAddress;
		this.role = role;
		this.active = false;
		this.password = ""; // this is the default PIN
		this.created = new DateTime();
		this.modified = new DateTime();
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String email) {
		this.emailAddress = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
