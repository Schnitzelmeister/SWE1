package servlets;
import java.io.IOException;

import java.text.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import main.Veranstaltung;
import user.Privatnutzer;
import user.User;


@WebServlet("/privatnutzer/bewertung")
public class BewertungServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	BewertungServlet(){}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalArgumentException{
		 try{
			 String bewertungstring =request.getParameter("wertung");
			 double bewertung = Double.parseDouble(bewertungstring);
			 //averagerRating ausrechnen
		 }
		 catch(IllegalArgumentException e){
			 request.setAttribute("errorMessage", "Ein Fehler ist aufgetreten.");
			 request.getRequestDispatcher("/privatnutzer/bewertung.jsp").forward(request, response);
		 }
	}
	
	

}
