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

import tn.iit.dao.DocumentDao;
import tn.iit.dao.UserDao;
import tn.iit.model.Document;
import tn.iit.model.User;

/**
 * Servlet implementation class DocumentController
 */
@WebServlet("/DocumentController")
public class DocumentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocumentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { if (request.getParameter("EnvoyerDemande") != null) {
				HttpSession session = request.getSession();
				
				String nom = request.getParameter("nomDocument");
				String nombreCopie = request.getParameter("nombreCopie");
				String date = request.getParameter("date");
				// int ihMatiere =  request.getParameter("idMatiere");

				DocumentDao DocumentDao = new DocumentDao();
				//int id = Integer.parseInt(request.getParameter("idMatiere"));

				
				List<Document> documents = DocumentDao.getAllDocument();
				session.setAttribute("document", documents);
				getServletContext().getRequestDispatcher("").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
			request.setAttribute("err", e.getMessage());
			dispatcher.include(request, response);
		}
	}

}
