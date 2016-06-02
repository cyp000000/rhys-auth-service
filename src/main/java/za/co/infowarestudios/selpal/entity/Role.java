package za.co.infowarestudios.selpal.entity;

import javax.persistence.*;

/**
 * Created by chrismipi on 2015/12/23.
 */
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;

	@Column
	private String roleName;

	public Role() {
	}

	public Role(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
