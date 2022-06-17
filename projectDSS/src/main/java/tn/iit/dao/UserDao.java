package tn.iit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import tn.iit.model.User;
import tn.iit.util.HibernateUtil;

public class UserDao {

	public void saveUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(user);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	public boolean validate(String userName, String password) {

		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = (User) session.createQuery("FROM User U WHERE U.username = :userName")
					.setParameter("userName", userName).uniqueResult();

			if (user != null && user.getPassword().equals(password)) {
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return false;
	}

	public String getRole(String userName) {

		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		String roleempl = (String) s.createQuery("select role FROM User U WHERE U.username = :userName")
				.setParameter("userName", userName).getSingleResult();
		s.getTransaction().commit();
		s.close();
		return roleempl;
	}

	public void updateUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.merge(user);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	/**
	 * Delete User
	 * 
	 * @param id
	 */
	public void deleteUser(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			User user = session.get(User.class, id);
			if (user != null) {
				session.delete(user);
				System.out.println("user is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	/**
	 * Get User By ID
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(int id) {

		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			// user = session.get(User.class, id);
			user= (User) session.createQuery("from User where id =:id ").setParameter("id", id).uniqueResult();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
		return user;
	}
	
	public int getIDByUserName(String username) {

		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		int id = (int) s.createQuery("select id FROM User U WHERE U.username = :username")
				.setParameter("username", username).getSingleResult();
		s.getTransaction().commit();
		s.close();
		return id;
	}

	
	public String getNomByID(int idEnseignant) {

		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		String nom = (String) s.createQuery("select username FROM User U WHERE U.id = :idEnseignant")
				.setParameter("idEnseignant", idEnseignant).getSingleResult();
		s.getTransaction().commit();
		s.close();
		return nom;
	}

	
	public List<User> getAllUser() {


		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		Query query = session.createQuery("From User u");
		List<User> listUser = query.getResultList();
		return listUser;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

}
