/** 
 *  

package servlets;
import java.io.IOException;
import java.util.Calendar;

import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.Termin;
import user.Privatnutzer;
import management.PrivatnutzerManagement;


@WebServlet("/NewTermin")
public class CreateNewTerminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CreateNewTerminServlet(){}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Termin termin =new Termin();
		String name= request.getParameter("name");
		String location=request.getParameter("location");
		String info =request.getParameter("info");
		Calendar start = request.getParameter("starttime");
		Calendar end = request.getParameter("endtime");
		
		try{
			if(!end.after(start)){
				throw new IllegalArgumentException("Endzeitpunkt muss nach Startzeit liegen.");
				
			}
			else
				termin.setName(name);
				termin.setLocation(location);
				termin.setStartTime(start);
				termin.setEndTime(end);
				termin.setBeschreibung(info);
				
				PrivatnutzerManagement.addPrivateEvent(termin);
				RequestDispatcher rs= request.getRequestDispatcher("/privatnutzer/main.jsp");
				rs.forward(request, response);
	    		out.println("<b>Neuer Termin wurde erstellt. </b>");
		}
		catch(IllegalArgumentException e){
			 RequestDispatcher rs = request.getRequestDispatcher("privatnutzer/newTermin.jsp");
    		 out.println("<b>"+e.getMessage()+"</b>"); 
    		 rs.include(request, response);
		}
		
	}
}

*/