package info.stolarczyk.javafx.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CustomersTable {
	
	private final SimpleIntegerProperty propertyid ;
	
	private final SimpleStringProperty firstName;
	private final SimpleStringProperty lastName;
	
	private final SimpleStringProperty street;
	

	private final SimpleStringProperty zipCode;
	private final SimpleStringProperty placeOfResidence;
	private final SimpleStringProperty mobilePhone;
	
	public CustomersTable(Integer propertyid, String firstName, String lastName,
			String street, String zipCode, String placeOfResidence,
			String mobilePhone) {
		super();
		this.propertyid = new SimpleIntegerProperty (propertyid);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.street = new SimpleStringProperty(street);
		this.zipCode = new SimpleStringProperty(zipCode);
		this.placeOfResidence = new SimpleStringProperty(placeOfResidence);
		this.mobilePhone = new SimpleStringProperty(mobilePhone);
	}
	
	public SimpleIntegerProperty getId() {
		return propertyid;
	}

	public SimpleStringProperty getFirstName() {
		return firstName;
	}

	public SimpleStringProperty getLastName() {
		return lastName;
	}

	public SimpleStringProperty getStreet() {
		return street;
	}

	public SimpleStringProperty getZipCode() {
		return zipCode;
	}

	public SimpleStringProperty getPlaceOfResidence() {
		return placeOfResidence;
	}

	public SimpleStringProperty getMobilePhone() {
		return mobilePhone;
	}
	
	

}
