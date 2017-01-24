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
import main.Veranstaltung;

/**
 * Servlet implementation class LoadPublicEvents
 */
@WebServlet("/LoadPublicEvents")
public class LoadPublicEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoadPublicEvents() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Das Servlet wurde gestartet");
		TreeMap<Integer, Veranstaltung> treemap = PoolDAO.poolDAO.getVeranstaltungDAO().getItems();
		String kategorie = request.getParameter("kategorie");
		ArrayList<Veranstaltung> liste = new ArrayList<Veranstaltung>(treemap.values());
		ArrayList<Event> eventListe = new ArrayList<Event>();
		System.out.println("Die Kategorie ist: "+kategorie);
		
		Event eventToAdd;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String from;
		String to;
		Veranstaltung veranstaltung;
	  if(kategorie == null || kategorie.equals("Alle Kategorien") || kategorie.equals("")){
		for(int i=0; i<liste.size(); i++){
			veranstaltung=liste.get(i);
			from=sdf.format(veranstaltung.getStartTime().getTime());
			to=sdf.format(veranstaltung.getEndTime().getTime());
			
			eventToAdd= new Event(veranstaltung.getId(), veranstaltung.getName(), from, to, "#6600FF", "private");
			eventListe.add(eventToAdd);
		}
	  }else{	
	    for(int i=0; i<liste.size(); i++){
			veranstaltung=liste.get(i);
			if(veranstaltung.getCategory().equals(kategorie)){
			  from=sdf.format(veranstaltung.getStartTime().getTime());
			  to=sdf.format(veranstaltung.getEndTime().getTime());
			
			eventToAdd= new Event(veranstaltung.getId(), veranstaltung.getName(), from, to, "#6600FF", "private");
			eventListe.add(eventToAdd);
		 }
		}
	  }
			Gson gson = new Gson();
			PrintWriter out = response.getWriter();
			out.write(gson.toJson(eventListe));			 //Arrayliste wird in JSON transformiert
			System.out.println(gson.toJson(eventListe)); //Das Ergebnis wird ausgegeben
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
