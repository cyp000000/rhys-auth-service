package za.co.infowarestudios.dto;

public class User {
	private String userId;
	private String emailAddress;
	private String created;
	private Boolean firstTimeLoggedIn;
	private Role role;
	private Boolean active;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public Boolean getFirstTimeLoggedIn() {
		return firstTimeLoggedIn;
	}

	public void setFirstTimeLoggedIn(Boolean firstTimeLoggedIn) {
		this.firstTimeLoggedIn = firstTimeLoggedIn;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
