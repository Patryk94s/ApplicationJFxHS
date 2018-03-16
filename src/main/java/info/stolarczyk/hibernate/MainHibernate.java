package info.stolarczyk.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import info.stolarczyk.javafx.models.Customers;

public class MainHibernate {

	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;

	public static void main(String[] args) {

		// entityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");

		// entityManager = entityManagerFactory.createEntityManager();

		// entityManager.getTransaction().begin();
		HibernateBegin();

		create();

		HibernateEnd();

		// entityManager.getTransaction().commit();

		// entityManager.close();
		// entityManagerFactory.close();
	}

	private static void HibernateBegin() {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

	}

	private static void HibernateEnd() {
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	private static void create() {

		Customers kc = new Customers();
		kc.setFirstName("Cezary");
		kc.setLastName("Stolarczyk");
		kc.setStreet("Okrezna");
		kc.setZipCode("08-300");
		kc.setPlaceOfResidence("Kostki");
		kc.setMobilePhone("535345353");

		entityManager.persist(kc);
	}

	private static void find() {
		int primaryKey = 2;
		Customers klienci = entityManager.find(Customers.class, primaryKey);
	}

	private static void query() {

		String jpql = "";

		Query query = entityManager.createQuery(jpql);

		List<Customers> resultList = query.getResultList();

	}

	public static void remove() {

		int primaryKey = 3;

		Customers reference = entityManager.getReference(Customers.class, primaryKey);

		entityManager.remove(reference);
	}

	/*
	 * kc2.setImie("Cezary"); kc2.setNazwisko("Stolarczyk");
	 * kc2.setKod_poczt("08-300"); kc2.setMiejsc("Kostki"); kc2.setUlica("Okrezna");
	 * kc2.setTel_kom("516877212");
	 * 
	 * kc3.setImie("Honorata"); kc3.setNazwisko("Stolarczyk");
	 * kc3.setKod_poczt("08-300"); kc3.setMiejsc("Kostki"); kc3.setUlica("Okrezna");
	 * kc3.setTel_kom("523441562");
	 */

}
