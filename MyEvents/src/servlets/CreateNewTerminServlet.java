/** 
 *  */

package servlets;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import main.Termin;
import user.Privatnutzer;
import user.User;
import management.PrivatnutzerManagement;


@WebServlet("/privatnutzer/NewTermin")
public class CreateNewTerminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CreateNewTerminServlet(){}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("/MyEvents/newtermin.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalArgumentException{
	
	try{
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String info = request.getParameter("info");
		String startTime = request.getParameter("starttime");
		String endTime = request.getParameter("endtime");
		String startDatum = request.getParameter("startdatum");
		String endDatum = request.getParameter("enddatum");
		Calendar dateStart=Calendar.getInstance();
		Calendar dateEnd=Calendar.getInstance();
		
		Integer id = (Integer) request.getSession().getAttribute("userid");
		Privatnutzer user = (Privatnutzer) PoolDAO.poolDAO.getUserDAO().getItemById(id);
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd.MM.yyyy");
		try {
			dateStart.setTime(sdf.parse(startTime+" "+startDatum));
		} catch (ParseException e) {
			throw new IllegalArgumentException("Ungültiges Datum oder Uhrzeit wurde angegeben");
		}
		
		try {
			dateEnd.setTime(sdf.parse(endTime+" "+endDatum));
		} catch (ParseException e) {
			throw new IllegalArgumentException("Ungültiges Datum oder Uhrzeit wurde angegeben");
		}
		
		checkValidityOfInput(dateStart, dateEnd, name, location, info);
		
		Termin termin = new Termin(name, location, dateStart, dateEnd, info);
		user.getKalender().getPrivate_appointments().add(termin);
		PoolDAO.poolDAO.getUserDAO().speichereItem(user);
		
		// PoolDAO.poolDAO.getTerminDAO().speichereItem(termin);
		request.setAttribute("infoMessage", "Der Termin "+name+" wurde erfolgreich im Privatkalender gespeichert.");
		request.getRequestDispatcher("/privatnutzer/newtermin.jsp").forward(request, response);
		System.out.println("Ein Terminobjekt mit dem Anfangsdatum: "+dateStart.getTime()+" wurde erstellt");
		
		
	}catch(IllegalArgumentException e){ //Specific Error message tied to the error
		request.setAttribute("errorMessage", e.getMessage());
		request.getRequestDispatcher("/privatnutzer/newtermin.jsp").forward(request, response);
	}catch(Exception e){ //Generic Error Message
		request.setAttribute("errorMessage", "Ein Fehler ist aufgetreten");
		request.getRequestDispatcher("/privatnutzer/newtermin.jsp").forward(request, response);
		e.printStackTrace();
	}
		
	}
	
	void checkValidityOfInput(Calendar from, Calendar to, String name, String location, String info){
		if(from.after(to)) throw new IllegalArgumentException("Das Anfangsdatum muss vor dem Enddatum stehen.");
		if(name.length()==0 || location.length()==0 || info.length()==0) throw new IllegalArgumentException("Kein Feld darf leer bleiben.");
	}
	
}

