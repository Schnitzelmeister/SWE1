package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.*;
import DAO.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {

    }

    /*
     * Init Application Data in PoolDAO.poolDAO
     */
	public void init() throws ServletException {
		PoolDAO.init( getServletContext().getRealPath("/WEB-INF/data") );
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
			     	   
	    User currentUser;
	    try {
	    	currentUser = PoolDAO.poolDAO.getUserDAO().getUserbyUsername(username);
	    }
	    catch (IllegalArgumentException e) {
	        request.setAttribute("errorMessage", "Der Benutzername konnte nicht gefunden werden");
	    	request.getRequestDispatcher("/login.jsp").forward(request, response);
	        return;
	    }
	    
	    if ( (currentUser instanceof Privatnutzer) && currentUser.getPasswort().equals(password) ){
	    	HttpSession session = request.getSession();
	    	session.setAttribute("username", currentUser);
	    	session.setAttribute("usertype", "privateuser");
	    	session.setAttribute("userid", currentUser.getId());

	    	
	    	response.sendRedirect("/MyEvents/privatnutzer/main.jsp");
	    	return;
	    }
	    else if ( (currentUser instanceof Admin) && currentUser.getPasswort().equals(password) ){	    	
	    	HttpSession session = request.getSession();
	    	session.setAttribute("username", currentUser);
	    	session.setAttribute("usertype", "admin");
	    	session.setAttribute("userid", currentUser.getId());

	    	response.sendRedirect("/MyEvents/admin/main.jsp");
	    	return;
	    }
	    else if ( (currentUser instanceof Analytiker) && currentUser.getPasswort().equals(password) ){	    	   	
	    	HttpSession session = request.getSession();
	    	session.setAttribute("username", currentUser);
	    	session.setAttribute("usertype", "analyst");
	    	session.setAttribute("userid", currentUser.getId());

	    	response.sendRedirect("/MyEvents/analytiker/main.jsp");  	
	    	return;
	    }

	    else if ( (currentUser instanceof Veranstalter) && currentUser.getPasswort().equals(password) ){	    		    	
	    	HttpSession session = request.getSession();
	    	session.setAttribute("username", currentUser);
	    	session.setAttribute("usertype", "organiser");
	    	session.setAttribute("userid", currentUser.getId());

	    	response.sendRedirect("/MyEvents/veranstalter/vermain.jsp");
	    	return;
	    }
	    
        request.setAttribute("errorMessage", "Benutzername oder Passwort falsch");
    	request.getRequestDispatcher("/login.jsp").forward(request, response);        
		
	}
	
}


