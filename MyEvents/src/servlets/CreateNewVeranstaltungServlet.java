	/**
 * */
 
package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import main.Veranstaltung;


@WebServlet("/veranstalter/NewVeranstaltung")
public class CreateNewVeranstaltungServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	public CreateNewVeranstaltungServlet(){}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("/veranstalter/NewVeranstaltung.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name= request.getParameter("name");
		String location=request.getParameter("location");
		String info =request.getParameter("info");
		String startTime = request.getParameter("starttime");
		String endTime = request.getParameter("endtime");
		String startDatum = request.getParameter("startdatum");
		String endDatum = request.getParameter("enddatum");
		String platzAnzahl = request.getParameter("availablePlaces"); 
		String kat = request.getParameter("kat");
		Calendar dateStart=Calendar.getInstance();
		Calendar dateEnd=Calendar.getInstance();
		
		try{
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
			
			verifyInput(name, location, info, dateStart, dateEnd, platzAnzahl);

			int currentUserId = (Integer) request.getSession().getAttribute("userid");
			int plaetze = Integer.parseInt(platzAnzahl);
			
			Veranstaltung veranstaltung = new Veranstaltung(currentUserId, name, info, kat, location, dateStart, dateEnd, plaetze, 0, 0);
			PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem(veranstaltung);
			request.setAttribute("infoMessage", "Die Veranstaltung mit dem Namen "+name+" wurde erfolgreich erstellt ");
			request.getRequestDispatcher("/veranstalter/NewVeranstaltung.jsp").forward(request, response);
			System.out.println(PoolDAO.poolDAO.getVeranstaltungDAO().getItems().size());
			
		}catch(IllegalArgumentException e){
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/veranstalter/NewVeranstaltung.jsp").forward(request, response);
		}catch(Exception e){
			request.setAttribute("errorMessage", "Ein Fehler ist aufgetreten ");
			request.getRequestDispatcher("/veranstalter/NewVeranstaltung.jsp").forward(request, response);
		}
		
	}
	
	void verifyInput(String name, String location, String info, Calendar start, Calendar end, String platzAnzahl){
		if(name.length()==0 || location.length()==0 || info.length()==0 || platzAnzahl.length()==0) throw new IllegalArgumentException("Kein Feld darf leer bleiben. ");
		if(start.after(end)) throw new IllegalArgumentException("Anfangszeitpunkt darf nicht hinter dem Endzeitpunkt der Veranstaltung liegen.");

		int plaetze;
		 
		 try{
		    plaetze = Integer.parseInt(platzAnzahl);
		 }catch(NumberFormatException e){
		    throw new IllegalArgumentException("Das Nummernfeld darf nur Ziffern enthalten ");
		 }
		 
		if (plaetze < 1) throw new IllegalArgumentException("Ungültige Platzanzahl ");
	}
}

