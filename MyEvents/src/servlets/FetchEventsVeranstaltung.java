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
//import main.Termin;
import main.Veranstaltung;
import user.Veranstalter;

@WebServlet("/FetchEventsVeranstaltung")
public class FetchEventsVeranstaltung extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public FetchEventsVeranstaltung(){
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer userid = (Integer) request.getSession().getAttribute("userid");
		Veranstalter veranstalter=(Veranstalter) PoolDAO.poolDAO.getUserDAO().getItemById(userid);
		
		ArrayList<Integer> liste = veranstalter.getOeKalender().getEvents();
		//ArrayList<Event> event = new ArrayList<Event>();
		
		//event=Umwandlung(liste);
		Event addev;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String from;
		String to;
		Veranstaltung veranstaltung;
		ArrayList<Event> events=new ArrayList<Event>();
		
		for(int i=0; i<liste.size(); i++){
			try{
			veranstaltung=PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(liste.get(i));
			from = sdf.format(veranstaltung.getStartTime().getTime());
			to = sdf.format(veranstaltung.getEndTime().getTime());
			 addev=new Event(veranstaltung.getId(), veranstaltung.getName(), from, to, "#fddfe5", "public");
			 events.add(addev);
			}
			catch(Exception e){
				//throw new IllegalArgumentException(e.getMessage());
			}
		}
		
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.write(gson.toJson(events));			 //Arrayliste wird in JSON transformiert
		System.out.println(out);
	
	}
	
	/*public ArrayList<Event> Umwandlung(ArrayList<Integer> list)throws IllegalArgumentException{
		Event addev;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String from;
		String to;
		Veranstaltung veranstaltung;
		ArrayList<Event> events=new ArrayList<Event>();
		
		for(int i=0; i<list.size(); i++){
			try{
			veranstaltung=PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(list.get(i));
			from = sdf.format(veranstaltung.getStartTime().getTime());
			to = sdf.format(veranstaltung.getEndTime().getTime());
			 addev=new Event(veranstaltung.getId(), veranstaltung.getName(), from, to, "#fddfe5", "public");
			 events.add(addev);
			}
			catch(Exception e){
				throw new IllegalArgumentException(e.getMessage());
			}
		}
		return events;	
		
	}*/
	
}
