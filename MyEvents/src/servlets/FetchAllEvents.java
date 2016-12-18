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
import user.Privatnutzer;


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

		ArrayList<Termin> terminListe = user.getKalender().getPrivate_appointments();

		ArrayList<Event> eventListe = new ArrayList<Event>();
		
		Event eventToAdd;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String from;
		String to;
		
		for(int i=0; i<terminListe.size(); i++){
			from=sdf.format(terminListe.get(i).getStartTime().getTime());
			to=sdf.format(terminListe.get(i).getEndTime().getTime());
			System.out.println(from+" "+to);
			eventToAdd = new Event(terminListe.get(i).getName(), from, to);
			eventListe.add(eventToAdd);
		}

		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.write(gson.toJson(eventListe));			 //Arrayliste wird in JSON transformiert
		System.out.println(gson.toJson(eventListe)); //Das Ergebnis wird ausgegeben
	}


}
