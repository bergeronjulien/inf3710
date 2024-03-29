package Persistence;

import java.beans.Customizer;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Model.Departement;

public class Pdepartement {
	private SessionFactory sessionFactory = null;
	private Session currentSession = null;

	public void setUp () {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		try { 
			sessionFactory = new MetadataSources(registry)
					.buildMetadata()
					.buildSessionFactory();
		} catch (Exception ex) { 
			StandardServiceRegistryBuilder.destroy(registry); 
		}

	}

	public void ouvrirSession() {
		try {
			currentSession = sessionFactory.openSession();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public Client read(String id) {
		return currentSession.find(Client.class, id);
	}

	public List<Client> read() {
		return currentSession.createQuery("from " + Client.class.getName()).getResultList();
	}

	public void update (Client c) {
		Transaction tx = currentSession.getTransaction();
		try {
			tx.begin();
			currentSession.update(c);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	public void fermerSession() {
		/* Instructions � */
		currentSession .close();

	}
	public void close() {
		sessionFactory.close();
	}

}
