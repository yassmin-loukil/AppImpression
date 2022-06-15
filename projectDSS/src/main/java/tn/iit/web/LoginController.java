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

import org.apache.tomcat.jni.User;


import tn.iit.dao.UserDao;



/**
 * @email Ramesh Fadatare
 */

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao loginDao;

    public void init() {
        loginDao = new UserDao();
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

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
    throws Exception {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role;
        role = loginDao.getRole(username);
        
        if (loginDao.validate(username, password) && role.equals("Admin")) {
            //RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
            //            dispatcher.forward(request, response);
        	HttpSession session = request.getSession();
			List<tn.iit.model.User> users = loginDao.getAllUser();
			session.setAttribute("user",users);
			getServletContext().getRequestDispatcher("/user-list.jsp").forward(request, response);

            
        } 
        else if(loginDao.validate(username, password) && role.equals("Enseignant")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Enseingnant-demande.jsp");
            dispatcher.forward(request, response);}
        
        else {
            throw new Exception("Login not successful..");
        }
       
        
    }
}