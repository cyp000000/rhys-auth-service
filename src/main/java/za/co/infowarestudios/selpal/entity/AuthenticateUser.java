package za.co.infowarestudios.selpal.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by victorrikhotso on 2016/01/29.
 */
public class AuthenticateUser {

	private String userId; // UserId that the user types in on the mobile app
	private String login;  // UserId that the user types in on the mobile app
	private String password; // PIN that the user types in on the mobile app
	private long role;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public AuthenticateUser() {
	}

	public AuthenticateUser(AuthenticateUser authenticateUser){
		super();
		this.userId = authenticateUser.getUserId();
		this.login = authenticateUser.getLogin();
		this.password = authenticateUser.getPassword();
	}

	public AuthenticateUser(String userId, String login, String password) {
		this.userId = userId;
		this.login = login;
		this.password = password;
	}

	public long getRole() {
		return role;
	}

	public void setRole(long role) {
		this.role = role;
	}
}
