package za.co.infowarestudios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private byte active;

	@Column(name="company_id")
	private String companyId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private String currency;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	private String name;

	@Column(name="physical_address")
	private String physicalAddress;

	@Column(name="physical_country")
	private String physicalCountry;

	@Column(name="postal_address")
	private String postalAddress;

	@Column(name="postal_country")
	private String postalCountry;

	private String role;

	@Column(name="vat_number")
	private String vatNumber;

	public Company() {
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

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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

	public Date getModified() {
		return this.modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhysicalAddress() {
		return this.physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public String getPhysicalCountry() {
		return this.physicalCountry;
	}

	public void setPhysicalCountry(String physicalCountry) {
		this.physicalCountry = physicalCountry;
	}

	public String getPostalAddress() {
		return this.postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getPostalCountry() {
		return this.postalCountry;
	}

	public void setPostalCountry(String postalCountry) {
		this.postalCountry = postalCountry;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getVatNumber() {
		return this.vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

}