package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.PoolDAO;
import main.Event;
import main.Termin;
import main.Veranstaltung;
import user.Privatnutzer;


/*
 * Diese Servlet ist dafür zuständig die privat erstellten Termine zu laden und im Fallcalendar anzuzeigen. 
 */

@WebServlet("/FetchAllEvents")
public class FetchAllEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FetchAllEvents() {
        super();
    }

    /*
    *Diese Methode ist zuständig für das Laden und Transformieren der Java Termin Objekte in JavaScript Objekte
    *
    */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer userid = (Integer) request.getSession().getAttribute("userid");
		Privatnutzer user = (Privatnutzer) PoolDAO.poolDAO.getUserDAO().getItemById(userid);
		ArrayList<Integer> terminListe = user.getKalender().getPrivate_appointments();

		ArrayList<Integer> publicEvent = user.getKalender().getPublic_events();
		ArrayList<Event> eventListe = new ArrayList<Event>();
		
		Event eventToAdd;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String from;
		String to;
		Termin termin;
		
		for(int i=0; i<terminListe.size(); i++){ //Privat erstellte Termine werden gesammelt
		 try{	
			 termin = PoolDAO.poolDAO.getTerminDAO().getItemById(terminListe.get(i));
			 from=sdf.format(termin.getStartTime().getTime());
			 to=sdf.format(termin.getEndTime().getTime());
			
			 eventToAdd = new Event(termin.getId(), termin.getName(), from, to, "FFC900", "private"); //Termine die der Privatbenutzer erstellt hat werden hinzugefügt (KEINE ÖFFENTLICHEN TERMINE)
			 eventListe.add(eventToAdd);
		  }catch(Exception e){}
		}

		Veranstaltung veranstaltung;
		for(int i=0; i<publicEvent.size(); i++){ //öffentliche Veranstaltungen werden hinzugefügt
		 try{
		   	 veranstaltung = PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(publicEvent.get(i));
			 from = sdf.format(veranstaltung.getStartTime().getTime());
			 to = sdf.format(veranstaltung.getEndTime().getTime());
			
			 eventToAdd = new Event(veranstaltung.getId(), veranstaltung.getName(), from, to, "#6600FF", "public"); //Veranstaltungen die der Privatbenutzer hinzugefügt hat werden geladen
			 eventListe.add(eventToAdd);
		 }catch(Exception e){ }
		}

		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.write(gson.toJson(eventListe));			 //Arrayliste wird in JSON transformiert
		System.out.println(out);
	}
}
