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

/**
 * Servlet implementation class DemandeTirageController
 */
@WebServlet("/DemandeTirageController")
public class DemandeTirageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandeTirageController() {
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
		try {  
			HttpSession session = request.getSession();
			int idDoc=Integer.parseInt(request.getParameter("idDoc"));

			int nombreCopie =  Integer.parseInt(request.getParameter("nombreCopie"));

			String date = request.getParameter("date");

			int idMatiere =  Integer.parseInt(request.getParameter("idMatiere"));

			MatiereDao MatiereDao = new MatiereDao();
			int idEnseignant = MatiereDao.getIdUserByIdMatiere(idMatiere);
			DemandeTirage demT =new DemandeTirage(date,nombreCopie,idEnseignant,idDoc);
			DemandeDao demaDao = new DemandeDao();
			demaDao.saveDemande(demT);


			session.setAttribute("demT", demT);
			getServletContext().getRequestDispatcher("/EnseignantHome.jsp").forward(request, response);
		
	} catch (Exception e) {
System.out.println(e);	
	}
	}

}
