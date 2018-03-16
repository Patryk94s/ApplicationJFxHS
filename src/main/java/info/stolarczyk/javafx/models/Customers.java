package info.stolarczyk.javafx.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "Customers")
public class Customers {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private Integer id;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "Street")
	private String street;

	@Column(name = "ZipCode")
	private String zipCode;

	@Column(name = "Placeofresidence")
	private String placeOfResidence;

	@Column(name = "Mobilephone")
	private String mobilePhone;
	
	
	

	public Customers(Integer id, String firstName, String lastName, String street, String zipCode,
			String placeOfResidence, String mobilePhone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.zipCode = zipCode;
		this.placeOfResidence = placeOfResidence;
		this.mobilePhone = mobilePhone;
	}

	public Customers(Integer id) {

		this.id = id;

	}

	public Customers() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPlaceOfResidence() {
		return placeOfResidence;
	}

	public void setPlaceOfResidence(String placeOfResidence) {
		this.placeOfResidence = placeOfResidence;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

}