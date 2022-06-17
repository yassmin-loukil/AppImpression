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

import tn.iit.dao.DemandeDao;
import tn.iit.dao.DocumentDao;
import tn.iit.dao.MatiereDao;
import tn.iit.dao.UserDao;
import tn.iit.model.DemandeTirage;
import tn.iit.model.Document;
import tn.iit.model.Matiere;

/**
 * @email Ramesh Fadatare
 */

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao loginDao;
	private MatiereDao MatiereDao;

	public void init() {
		loginDao = new UserDao();
		MatiereDao = new MatiereDao();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			authenticate(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = loginDao.getRole(username);
		int id = loginDao.getIDByUserName(username);

		if (loginDao.validate(username, password) && role.equals("Admin")) {
			// RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
			// dispatcher.forward(request, response);
			HttpSession session = request.getSession();
			List<tn.iit.model.User> users = loginDao.getAllUser();
			session.setAttribute("user", users);
			getServletContext().getRequestDispatcher("/user-list.jsp").forward(request, response);

		} else if (loginDao.validate(username, password) && role.equals("Enseignant")) {
			HttpSession session = request.getSession();
			MatiereDao =new MatiereDao();
			List<tn.iit.model.Matiere> Matieres = MatiereDao.getAllMatiere(id);
			session.setAttribute("matiere", Matieres);
			
			
			
			DocumentDao DocumentDao = new DocumentDao();
			//int id1 = Integer.parseInt(request.getParameter("idMatiere"));

			
			List<Document> documents = DocumentDao.getAllDocument();
			session.setAttribute("document", documents);
			getServletContext().getRequestDispatcher("/EnseignantHome.jsp").forward(request, response);
		}
		else if (loginDao.validate(username, password) && role.equals("Agent")) {
			HttpSession session = request.getSession();
			DemandeDao demandeDao =new DemandeDao();
			List<DemandeTirage> DemandeTirage = demandeDao.getAllDemande();
			session.setAttribute("DemandeTirage", DemandeTirage);
		
				
			
			//DocumentDao DocumentDao = new DocumentDao();
			//int id1 = Integer.parseInt(request.getParameter("idMatiere"));

			
//		List<Document> documents = DocumentDao.getAllDocument();
//		session.setAttribute("document", documents);
			getServletContext().getRequestDispatcher("/AgentHome.jsp").forward(request, response);
		}

		else {
			throw new Exception("Login not successful..");
		}

	}
}