package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import main.Event;
import main.OeffentlicherKalender;
import main.Veranstaltung;
import user.Veranstalter;

@WebServlet("/veranstalter/UpdateVeranstaltung")
public class UpdateVeranstaltung extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public UpdateVeranstaltung(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try{
			String name= request.getParameter("name");
			String location= request.getParameter("location");
			String plaetze = request.getParameter("plaetze");
			String  ende =request.getParameter("endtime");
			String anfang =request.getParameter("starttime");
			String anfangsdatum =request.getParameter("startdatum");
			String enddatum =request.getParameter("enddatum");
			String info =request.getParameter("info");
			String cat=request.getParameter("kat");
			Calendar start =Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			
			Integer veranstaltungid= Integer.parseInt(request.getParameter("id"));
			int platz=Integer.parseInt(plaetze);
			
			
			Veranstaltung event = PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(veranstaltungid); //Veranstaltung vs Event, Veranstaltung wird zum Speichern gebraucht
			
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd.MM.yyyy");
			
			try{
			start.setTime(sdf.parse(anfang+" "+anfangsdatum));
			end.setTime(sdf.parse(ende+" " +enddatum));
			}
			catch(ParseException e){
				throw new IllegalArgumentException ("Ungültiges Datum oder ungültige Uhrzeit wurde angegeben.");
			}
			
			if(end.before(start)) throw new IllegalArgumentException("Anfangszeitpunkt muss vor Endzeitpuinkt liegen.");
			if(name.length()==0||location.length()==0|| info.length()==0||plaetze.length()==0) throw new IllegalArgumentException("Keines der Felder darf leer bleiben.");
			event.setName(name);
			event.setAvailablePlaces(platz);
			event.setLocation(location);
			event.setDescription(info);
			event.setCategory(cat);
			event.setStartTime(start);
			event.setEndTime(end);		
			
			response.sendRedirect("/MyEvents/veranstalter/UpdateVeranstaltung.jsp?id="+veranstaltungid + "&info=Die Änderungen wurden gespeichert");
			
		}
		catch(IllegalArgumentException e){
			Integer veranstaltungid= Integer.parseInt(request.getParameter("id"));
			response.sendRedirect("/MyEvents/veranstalter/UpdateVeranstaltung.jsp?id="+veranstaltungid + "&error="+e.getMessage());
		}
		catch(Exception e){
			Integer veranstaltungid= Integer.parseInt(request.getParameter("id"));
			response.sendRedirect("/MyEvents/veranstalter/UpdateVeranstaltung.jsp?id="+veranstaltungid + "&error=Ein Fehler ist aufgetreten.");
		}
	}

}
