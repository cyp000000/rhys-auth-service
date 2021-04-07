package za.co.infowarestudios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the quote_order_product database table.
 * 
 */
@Entity
@Table(name="quote_order_product")
@NamedQuery(name="QuoteOrderProduct.findAll", query="SELECT q FROM QuoteOrderProduct q")
public class QuoteOrderProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private double cost;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private String currency;

	@Column(name="currency_symbol")
	private String currencySymbol;

	private String description;

	@Column(name="model_number")
	private String modelNumber;

	private String name;

	private double price;

	@Column(name="product_id")
	private String productId;

	private int quantity;

	@Column(name="quote_order_id")
	private String quoteOrderId;

	//bi-directional many-to-many association to QuoteOrder
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="quote_order_quote_order_products"
		, joinColumns={
			@JoinColumn(name="quote_order_products")
			}
		, inverseJoinColumns={
			@JoinColumn(name="quote_order")
			}
		)
	private List<QuoteOrder> quoteOrders;

	public QuoteOrderProduct() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCurrencySymbol() {
		return this.currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
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

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getQuoteOrderId() {
		return this.quoteOrderId;
	}

	public void setQuoteOrderId(String quoteOrderId) {
		this.quoteOrderId = quoteOrderId;
	}

	public List<QuoteOrder> getQuoteOrders() {
		return this.quoteOrders;
	}

	public void setQuoteOrders(List<QuoteOrder> quoteOrders) {
		this.quoteOrders = quoteOrders;
	}

}