package info.stolarczyk.dao;

import java.util.List;

import info.stolarczyk.javafx.models.Customers;

public interface HibernateDao {

	public boolean addEmployee(Customers customer);

	public boolean removeEmployee(int id);

	public List<Customers> listEmployee();

	public boolean updateEmployee(Customers ustomer);

	public Customers findEmployee(int id);

}
