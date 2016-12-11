package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import management.AdminManagement;
import user.Privatnutzer;


@WebServlet("/register")
public class CreateNewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/MyEvents/register.html");
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	 AdminManagement management = new AdminManagement();
    	 PrintWriter out = response.getWriter();
    	 String username = request.getParameter("username");
    	 String password = request.getParameter("password");
    	 String realName = request.getParameter("name");
    	 String email = request.getParameter("email");
    	 String phone = request.getParameter("phonenr");
    	 String usertype = request.getParameter("usertype");    	     	  
    	 
    	 boolean created=false;
    	 try{ 
    		 validValues(username, password, realName, email, phone);
    	 
    		 if(usertype == "private"){
    			 management.createNewPrivateUser(username, password, realName, email, phone);
    			 created=true;
    		 }
    	 
    		 if(usertype == "analytiker"){
    		 
    		}
    	 
    		 if(usertype == "admin"){
    		 
    		 }
    	 
    		 if(usertype == "veranstalter"){
    		 
    		 }
    	 
    		 if(created){
    			 RequestDispatcher rs = request.getRequestDispatcher("login.html");
    			 out.println("<b>Das Konto wurde erfolgreich erstellt. </b>"); 
    			 rs.forward(request, response);
    		 }
    	 
    	 }catch(IllegalArgumentException e){
    		 RequestDispatcher rs = request.getRequestDispatcher("register.html");
    		 out.println("<b>"+e.getMessage()+"</b>"); 
    		 rs.include(request, response);
    	 }catch(Exception e){
    		 RequestDispatcher rs = request.getRequestDispatcher("register.html");
    		 out.println("<b>Ein Fehler ist aufgetreten</b>"); 
    		 rs.include(request, response);
    	 }
}
  
     
   public void validValues(String username, String password, String realName, String email, String phone) throws IllegalArgumentException{
    	
    	if(username=="" || password=="" || realName=="" || email=="" || phone=="")
    		throw new IllegalArgumentException("Kein Feld darf leer bleiben");

    	if(username.length() > 30){
    		throw new IllegalArgumentException("Der Benutzername darf nicht länger als 30 Zeichen sein");
    	}
    	
    	if(password.length() < 8){
    		throw new IllegalArgumentException("Das Passwort muss mindestens 8 Stellen haben");
    	}
    	
    	if(!validEmail(email)){
    		throw new IllegalArgumentException("Die angegebene Email Adresse ist keine gültige Email");
    	}
    }
    
    public boolean validEmail(String email){
    	Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);
		
		return mat.matches();
    }
    
   

}
