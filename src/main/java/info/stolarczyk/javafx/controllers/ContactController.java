package info.stolarczyk.javafx.controllers;

import java.util.List;

import org.springframework.stereotype.Component;

import info.stolarczyk.javafx.models.Customers;
import info.stolarczyk.service.HibernateService;
import info.stolarczyk.service.HibernateServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Component
public class ContactController {
	
	private HibernateService contactService = new HibernateServiceImpl();
	//private ObservableList<Customers> contactList = FXCollections.observableArrayList();

	public boolean addEmployee(Customers customer) {
		return contactService.addEmployee(customer);
		

	}

	public boolean removeEmployee(int id) {

		return contactService.removeEmployee(id);

	}
	/*

	public ObservableList<Customers> getCustomersList() {
		if (!contactList.isEmpty())
			contactList.clear();
		contactList = FXCollections.observableList((List<Customers>) contactService.listEmployee());
		return contactList;
	}
	*/

	public boolean updateEmployee(Customers customer) {

		return contactService.updateEmployee(customer);

	}

	public Customers findEmployee(int id) {

		return contactService.findEmployee(id);

	}

}
