package za.co.infowarestudios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_product database table.
 * 
 */
@Entity
@Table(name="user_product")
@NamedQuery(name="UserProduct.findAll", query="SELECT u FROM UserProduct u")
public class UserProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private byte active;

	private double cost;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private String currency;

	private String description;

	@Column(name="model_number")
	private String modelNumber;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	private int moq;

	private String name;

	private double price;

	@Column(name="product_id")
	private String productId;

	@Column(name="supplier_id")
	private String supplierId;

	@Column(name="user_id")
	private String userId;

	@Column(name="user_product_id")
	private String userProductId;

	public UserProduct() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModelNumber() {
		return this.modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public Date getModified() {
		return this.modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public int getMoq() {
		return this.moq;
	}

	public void setMoq(int moq) {
		this.moq = moq;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserProductId() {
		return this.userProductId;
	}

	public void setUserProductId(String userProductId) {
		this.userProductId = userProductId;
	}

}