package za.co.infowarestudios.entity;

import javax.persistence.*;

/**
 * Created by jomolumina on 2018/06/11. 
 */
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;

	@Column
	private String description;

	public Role() {
	}

	public Role(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
