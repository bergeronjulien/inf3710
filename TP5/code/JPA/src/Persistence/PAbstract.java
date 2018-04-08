package Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Transaction;

import java.util.List;

import Model.Chercheur;

public class PAbstract<TYPE> {
	
	private Class<TYPE> clazz;

	private static EntityManagerFactory managerFactory = null;
	private static EntityManager manager = null;
	
	public PAbstract(Class<TYPE> c) {
		this.clazz = c;
	}

	public void setUp () {
		if (managerFactory == null) {
			managerFactory = Persistence.
					createEntityManagerFactory("CAPO");
		}
		if (manager == null) {
			manager = managerFactory.createEntityManager();
		}
	}

	public TYPE read(String id) {
		return manager.find(this.clazz, id);
	}

	public List<TYPE> read() {
		return manager.createQuery("from " + this.clazz.getName()).getResultList();
	}
	
	public Object queryOne(String queryString) {
		return manager.createQuery("from " + clazz.getName() + " " + queryString).getSingleResult();
	}
	
	public List<TYPE> query(String queryString) {
		return manager.createQuery("from " + clazz.getName() + " " + queryString).getResultList();
	}
	
	public void add (TYPE c) {
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
			manager.persist(c);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	public void update (TYPE c) {
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
			manager.merge(c);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	public void delete (String queryString) {
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
			System.out.println("delete " + clazz.getName() + " " + queryString);
			Query q = manager.createQuery("delete " + clazz.getName() + " " + queryString);
			q.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	public void close() {
		manager.close();
		managerFactory.close();
	}

}
