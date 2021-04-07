package za.co.infowarestudios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dimensions database table.
 * 
 */
@Entity
@Table(name="dimensions")
@NamedQuery(name="Dimension.findAll", query="SELECT d FROM Dimension d")
public class Dimension implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private byte active;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name="gross_weight")
	private int grossWeight;

	@Column(name="m_depth")
	private int mDepth;

	@Column(name="m_height")
	private int mHeight;

	@Column(name="m_length")
	private int mLength;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	@Column(name="net_weight")
	private int netWeight;

	@Column(name="no_of_pieces")
	private int noOfPieces;

	@Column(name="p_depth")
	private int pDepth;

	@Column(name="p_height")
	private int pHeight;

	@Column(name="p_length")
	private int pLength;

	@Column(name="product_id")
	private String productId;

	public Dimension() {
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

	public int getMDepth() {
		return this.mDepth;
	}

	public void setMDepth(int mDepth) {
		this.mDepth = mDepth;
	}

	public int getMHeight() {
		return this.mHeight;
	}

	public void setMHeight(int mHeight) {
		this.mHeight = mHeight;
	}

	public int getMLength() {
		return this.mLength;
	}

	public void setMLength(int mLength) {
		this.mLength = mLength;
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

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}