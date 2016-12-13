/**
 * 
 
package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.Veranstaltung;


@WebServlet("/NewVeranstaltung")
public class CreateNewVeranstaltungServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	CreateNewVeranstaltungServlet(){}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Veranstaltung veranstaltung =new Veranstaltung();
		String name= request.getParameter("name");
		String location=request.getParameter("location");
		String info =request.getParameter("info");
		Calendar start = request.getParameter("starttime");
		Calendar end = request.getParameter("endtime");
		int platz=request.getParameter("availablePlaces");
		String kat =request.getParameter("kat");
		try{
			if(!end.after(start)){
				throw new IllegalArgumentException("Endzeitpunkt muss nach Startzeit liegen.");
				
			}
			else
				veranstaltung.setName(name);
				veranstaltung.setLocation(location);
				veranstaltung.setStartTime(start);
				veranstaltung.setEndTime(end);
				veranstaltung.setDescription(info);
				veranstaltung.setCategory(kat);
				veranstaltung.setAvailablePlaces(platz);
				
				
				RequestDispatcher rs= request.getRequestDispatcher("/veranstalter/main.jsp");
				rs.forward(request, response);
		}
		catch(IllegalArgumentException e){
			RequestDispatcher rs = request.getRequestDispatcher("veranstalter/newTermin.jsp");
			//out.println("<b>"+e.getMessage()+"</b>"); 
			request.setAttribute("errorMessage", "Ein Fehler ist aufgetreten");
			rs.forward(request, response);
		}
	}
	

}
*/
