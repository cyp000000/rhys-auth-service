package za.co.infowarestudios.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the invoice_edit database table.
 * 
 */
@Entity
@Table(name="invoice_edit")
@NamedQuery(name="InvoiceEdit.findAll", query="SELECT i FROM InvoiceEdit i")
public class InvoiceEdit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String currency;

	private String description;

	private String name;

	private double price;

	@Column(name="product_name")
	private String productName;

	private int quantity;

	@Column(name="quote_order_id")
	private String quoteOrderId;

	public InvoiceEdit() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

}