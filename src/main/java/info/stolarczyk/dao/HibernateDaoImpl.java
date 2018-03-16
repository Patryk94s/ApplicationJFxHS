package info.stolarczyk.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.stolarczyk.javafx.models.Customers;


@Repository
public class HibernateDaoImpl implements HibernateDao {

	
	public static EntityManagerFactory entityManagerFactory;
	@Autowired
	public static EntityManager entityManager;

	@Override
	public boolean addEmployee(Customers customer) {
		
		
		HibernateBegin();

		entityManager.persist(customer);

		HibernateEnd();
		

		return true;

	}

	public static void HibernateBegin() {

		entityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

	}

	public static void HibernateEnd() {

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}

	@Override
	public boolean removeEmployee(int id) {

		HibernateBegin();
		Customers reference = entityManager.getReference(Customers.class, id);

		entityManager.remove(reference);
		HibernateEnd();
		
		return true;

	}

	@Override
	public List<Customers> listEmployee() {
		List<Customers> list = new ArrayList<Customers>();
		String jpql = "from Customers";
		HibernateBegin();



		list = entityManager.createQuery(jpql).getResultList();
		

		HibernateEnd();

		return list;
	}

	@Override
	public boolean updateEmployee(Customers customer) {

		HibernateBegin();
		entityManager.merge(customer);
		HibernateEnd();
		return true;
	}

	@Override
	public Customers findEmployee(int id) {
		HibernateBegin();
		Customers customer = entityManager.find(Customers.class, id);

		HibernateEnd();

		return customer;
	}

}
