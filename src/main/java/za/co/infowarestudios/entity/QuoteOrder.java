package za.co.infowarestudios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the quote_order database table.
 * 
 */
@Entity
@Table(name="quote_order")
@NamedQuery(name="QuoteOrder.findAll", query="SELECT q FROM QuoteOrder q")
public class QuoteOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private byte active;

	@Column(name="cancellation_reason")
	private String cancellationReason;

	@Column(name="cancellation_request")
	private byte cancellationRequest;

	@Column(name="cancellation_response")
	private String cancellationResponse;

	private String country;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expected_delivery_date")
	private Date expectedDeliveryDate;

	private byte hasawb;

	private byte hasbol;

	private byte haspl;

	private byte haspop;

	private byte hassi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	@Column(name="quote_order_id")
	private String quoteOrderId;

	private String status;

	@Column(name="supplier_id")
	private String supplierId;

	@Column(name="total_price")
	private double totalPrice;

	@Column(name="total_quantity")
	private int totalQuantity;

	@Column(name="user_id")
	private String userId;

	//bi-directional many-to-many association to QuoteOrderProduct
	@ManyToMany(mappedBy="quoteOrders", fetch=FetchType.EAGER)
	private List<QuoteOrderProduct> quoteOrderProducts;

	public QuoteOrder() {
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

	public String getCancellationReason() {
		return this.cancellationReason;
	}

	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}

	public byte getCancellationRequest() {
		return this.cancellationRequest;
	}

	public void setCancellationRequest(byte cancellationRequest) {
		this.cancellationRequest = cancellationRequest;
	}

	public String getCancellationResponse() {
		return this.cancellationResponse;
	}

	public void setCancellationResponse(String cancellationResponse) {
		this.cancellationResponse = cancellationResponse;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getExpectedDeliveryDate() {
		return this.expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public byte getHasawb() {
		return this.hasawb;
	}

	public void setHasawb(byte hasawb) {
		this.hasawb = hasawb;
	}

	public byte getHasbol() {
		return this.hasbol;
	}

	public void setHasbol(byte hasbol) {
		this.hasbol = hasbol;
	}

	public byte getHaspl() {
		return this.haspl;
	}

	public void setHaspl(byte haspl) {
		this.haspl = haspl;
	}

	public byte getHaspop() {
		return this.haspop;
	}

	public void setHaspop(byte haspop) {
		this.haspop = haspop;
	}

	public byte getHassi() {
		return this.hassi;
	}

	public void setHassi(byte hassi) {
		this.hassi = hassi;
	}

	public Date getModified() {
		return this.modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getQuoteOrderId() {
		return this.quoteOrderId;
	}

	public void setQuoteOrderId(String quoteOrderId) {
		this.quoteOrderId = quoteOrderId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalQuantity() {
		return this.totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<QuoteOrderProduct> getQuoteOrderProducts() {
		return this.quoteOrderProducts;
	}

	public void setQuoteOrderProducts(List<QuoteOrderProduct> quoteOrderProducts) {
		this.quoteOrderProducts = quoteOrderProducts;
	}

}