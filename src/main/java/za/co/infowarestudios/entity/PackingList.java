package za.co.infowarestudios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the packing_list database table.
 * 
 */
@Entity
@Table(name="packing_list")
@NamedQuery(name="PackingList.findAll", query="SELECT p FROM PackingList p")
public class PackingList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private byte active;

	private String carton;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name="gross_weight")
	private int grossWeight;

	@Column(name="model_number")
	private String modelNumber;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	@Column(name="net_weight")
	private int netWeight;

	@Column(name="no_of_pieces")
	private int noOfPieces;

	@Column(name="order_id")
	private String orderId;

	@Column(name="p_depth")
	private int pDepth;

	@Column(name="p_height")
	private int pHeight;

	@Column(name="p_length")
	private int pLength;

	@Column(name="prod_name")
	private String prodName;

	@Column(name="product_id")
	private String productId;

	public PackingList() {
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

	public String getCarton() {
		return this.carton;
	}

	public void setCarton(String carton) {
		this.carton = carton;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getGrossWeight() {
		return this.grossWeight;
	}

	public void setGrossWeight(int grossWeight) {
		this.grossWeight = grossWeight;
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

	public int getNetWeight() {
		return this.netWeight;
	}

	public void setNetWeight(int netWeight) {
		this.netWeight = netWeight;
	}

	public int getNoOfPieces() {
		return this.noOfPieces;
	}

	public void setNoOfPieces(int noOfPieces) {
		this.noOfPieces = noOfPieces;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getPDepth() {
		return this.pDepth;
	}

	public void setPDepth(int pDepth) {
		this.pDepth = pDepth;
	}

	public int getPHeight() {
		return this.pHeight;
	}

	public void setPHeight(int pHeight) {
		this.pHeight = pHeight;
	}

	public int getPLength() {
		return this.pLength;
	}

	public void setPLength(int pLength) {
		this.pLength = pLength;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}