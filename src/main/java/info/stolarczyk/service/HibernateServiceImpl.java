package info.stolarczyk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import info.stolarczyk.dao.HibernateDao;
import info.stolarczyk.dao.HibernateDaoImpl;
import info.stolarczyk.javafx.models.Customers;

@Service
public class HibernateServiceImpl implements HibernateService {

	private HibernateDao hibernateDao = new HibernateDaoImpl();

	//@Override
	@Transactional
	public boolean addEmployee(Customers customer) {
		return hibernateDao.addEmployee(customer);
		

	}

	//@Override
	@Transactional
	public boolean removeEmployee(int id) {
		return hibernateDao.removeEmployee(id);

	}

	//@Override
	@Transactional
	public List<Customers> listEmployee() {

		return hibernateDao.listEmployee();

	}

	//@Override
	@Transactional
	public boolean updateEmployee(Customers customer) {
		return hibernateDao.updateEmployee(customer);

	}

	//@Override
	@Transactional
	public Customers findEmployee(int id) {
		return hibernateDao.findEmployee(id);

	}

}
