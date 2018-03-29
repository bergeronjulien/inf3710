import java.util.List;

import Model.Departement;
import Persistence.AbstractPersistence;

public class Main {

	public static void main(String[] args) {

		AbstractPersistence<Departement> o = 
				new AbstractPersistence<Departement>(Departement.class);
		o.setUp();
		o.ouvrirSession();// U1
//		Client c = o.read("c001");
//		System.out.println(c.getNom());
//		c.setDiscnt(12);
//		o.update(c);
//
//		for (Commande cm : c.getCommandes()) {
//			System.out.println(cm.getQty());
//		}
//
//		o.fermerSession();
//
//		o.ouvrirSession(); // U2
//		c = o.read("c001");
//		System.out.println(c.getNom());
//		o.fermerSession();
//
//		o.ouvrirSession(); // U2
//		List<Client> cls = o.read();
//		for (Client client : cls) {
//			System.out.println(client.getNom());
//		}
//
//
//		o.fermerSession();
//
//
//
//
//
//		o.close();
//



	}

}
