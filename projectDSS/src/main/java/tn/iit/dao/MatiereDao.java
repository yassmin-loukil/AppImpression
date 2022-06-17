package tn.iit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tn.iit.model.Matiere;
import tn.iit.model.User;
import tn.iit.util.HibernateUtil;

public class MatiereDao {
	public Matiere getMatiere(int id) {

		Transaction transaction = null;
		Matiere matiere = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			// user = session.get(User.class, id);
			matiere = (Matiere) session.createQuery("from Matiere WHERE id =:id ").setParameter("id", id).uniqueResult();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
		return matiere;
	}
	

	public List<Matiere> getAllMatiere(int idEnseignant) {


		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		Query query = session.createQuery("From Matiere m where m.idEnseignant =: idEnseignant");
		List<Matiere> listMatiere = query.setParameter("idEnseignant", idEnseignant).getResultList();
		return listMatiere;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
		
	}
	
	public int getIdUserByIdMatiere(int idMatiere) {

		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		int id = (int) s.createQuery("select idEnseignant FROM Matiere m WHERE m.id = :idMatiere")
				.setParameter("idMatiere", idMatiere).getSingleResult();
		s.getTransaction().commit();
		s.close();
		return id;
	}

}
