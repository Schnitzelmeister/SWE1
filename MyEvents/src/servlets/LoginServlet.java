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

import user.Admin;
import user.Analytiker;
import user.Privatnutzer;
import user.User;
import user.Veranstalter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public LoginServlet() {

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
		
	    PrintWriter out = response.getWriter();
	    
	    if(password.length() < 8){
	    	RequestDispatcher rs = request.getRequestDispatcher("login.html");
	        rs.include(request, response);
	        out.println("<b>Das Passwort muss mindestens 8 Zeichen haben.</b>");
	        return;
	    }
	    
	    User currentUser = getUserbyUsername(username);
	    
	    if(loginIsCorrect(username, password) && (currentUser instanceof Privatnutzer)){
	    	
	    	HttpSession session = request.getSession();
	    	session.setAttribute("username", currentUser);
	    	session.setAttribute("usertype", "privateuser");

	    	response.sendRedirect("/MyEvents/privatnutzer/main.html");
	    }
	    
	    if(loginIsCorrect(username, password) && (currentUser instanceof Admin)){
	    	
	    	HttpSession session = request.getSession();
	    	session.setAttribute("username", currentUser);
	    	session.setAttribute("usertype", "admin");

	    	
	    	response.sendRedirect("/MyEvents/admin/main.html");
	    }
	    
	    if(loginIsCorrect(username, password) && (currentUser instanceof Analytiker)){
	    	
	    	HttpSession session = request.getSession();
	    	session.setAttribute("username", currentUser);
	    	session.setAttribute("usertype", "analyst");

	    	
	    	response.sendRedirect("/MyEvents/analytiker/main.html");  	
	    }

	    if(loginIsCorrect(username, password) && (currentUser instanceof Veranstalter)){
	    	
	    	HttpSession session = request.getSession();
	    	session.setAttribute("username", currentUser);
	    	session.setAttribute("usertype", "organiser");

	    	
	    	response.sendRedirect("/MyEvents/veranstalter/main.html");
	    }
	
        RequestDispatcher rs = request.getRequestDispatcher("login.html");
        rs.include(request, response);
        out.println("<b>Username or Password incorrect</b>");
	}

	public boolean loginIsCorrect(String username, String password){
		//muss noch implementiert werden
		return true;
	}
	
	public User getUserbyUsername(String username){
		//muss noch implementiert werden
		return new Privatnutzer();
	}
	
}



