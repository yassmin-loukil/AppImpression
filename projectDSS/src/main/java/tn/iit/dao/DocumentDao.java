package tn.iit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tn.iit.model.Document;
import tn.iit.model.Matiere;
import tn.iit.util.HibernateUtil;

public class DocumentDao {

	
	public Document getDocument(int id) {

		Transaction transaction = null;
		Document document = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			// user = session.get(User.class, id);
			document = (Document) session.createQuery("from Document where id =:id ").setParameter("id", id).uniqueResult();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
		return document;
	}

	public List<Document> getAllDocument(int idMatiere) {


		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		Query query = session.createQuery("From Document m where m.idMatiere =: idMatiere");
		List<Document> listDocument = query.setParameter("idMatiere", idMatiere).getResultList();
		return listDocument;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}
	
	public List<Document> getAllDocument() {


		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		Query query = session.createQuery("From Document d ");
		List<Document> listDocument = query.getResultList();
		return listDocument;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}
	
}
