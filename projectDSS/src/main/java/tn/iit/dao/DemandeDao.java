package tn.iit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tn.iit.model.DemandeTirage;
import tn.iit.model.User;
import tn.iit.util.HibernateUtil;

public class DemandeDao {
	public void saveDemande(DemandeTirage demande) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(demande);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}
	public List<DemandeTirage> getAllDemande() {


		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		Query query = session.createQuery("From DemandeTirage d");
		List<DemandeTirage> listDemande = query.getResultList();
		return listDemande;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}
	

	
	

}
