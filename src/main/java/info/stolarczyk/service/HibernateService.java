package info.stolarczyk.service;

import java.util.List;

import info.stolarczyk.javafx.models.Customers;

public interface HibernateService {

	public boolean addEmployee(Customers customer);

	public boolean removeEmployee(int id);

	public List<Customers> listEmployee();

	public boolean updateEmployee(Customers customer);

	public Customers findEmployee(int id);

}
