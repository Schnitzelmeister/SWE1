/**
 * 
 */
package servlets;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.Termin;
import user.Privatnutzer;

/**
 * @author 
 *
 */
@WebServlet("/NewTermin")
public class CreateNewTerminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CreateNewTerminServlet(){}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Termin termin =new Termin();
		String name= request.getParameter("Name");
		String location=request.getParameter("location");
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
		}
	}
}
