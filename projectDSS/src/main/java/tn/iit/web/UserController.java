package tn.iit.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import tn.iit.dao.UserDao;
import tn.iit.model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		UserDao user = new UserDao();
		try {
			if (request.getParameter("addUser") != null) {
				HttpSession session = request.getSession();
				
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String username = request.getParameter("username");
				String pass = request.getParameter("pass");
				String role = request.getParameter("role");
				String etat = request.getParameter("etat");
				User currentUser = new User(nom, prenom, username, pass, role, etat);
				user.saveUser(currentUser);

				List<User> users = user.getAllUser();
				session.setAttribute("user", users);
				getServletContext().getRequestDispatcher("/user-list.jsp").forward(request, response);
				
			} 
			else if (request.getParameter("updateUser") != null) {
				HttpSession session = request.getSession();

				UserDao userDao = new UserDao();
				int id = Integer.parseInt(request.getParameter("id"));

				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String username = request.getParameter("username");
				String pass = request.getParameter("pass");
				String role = request.getParameter("role");
				String etat = request.getParameter("etat");
				User currentUser = new User(id,nom, prenom, username, pass, role, etat);
				user.updateUser(currentUser);

				List<User> users = user.getAllUser();
				session.setAttribute("user", users);
				getServletContext().getRequestDispatcher("/user-list.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
			request.setAttribute("err", e.getMessage());
			dispatcher.include(request, response);
		}

	}

}
