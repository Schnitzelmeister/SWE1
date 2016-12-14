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
		String starts = request.getParameter("starttime");
		String ends = request.getParameter("endtime");
		String datums=request.getParameter("datum");
		int platz=request.getParameter("availablePlaces");
		String kat =request.getParameter("kat");
		Calender start = getZeit(starts);
		Calendar end = getZeit(ends);
		Calendar datum=getDatum(datums);
		int month=datum.get(Calendar.MONTH);
		int year=datum.get(Calendar.YEAR);
		int day=datum.get(Calendar.DAY_OF_MONTH);
		start.set(DAY_OF_MONTH,day);
		start.set(MONTH, month);
		start.set(YEAR, year);
		end.set(DAY_OF_MONTH,day);
		end.set(MONTH, month);
		end.set(YEAR, year);
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
				//veranstaltung.setDatum(datum);
				
				
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
	
	public Calendar getZeit(String s){
	 if(s.charAt(2)!=":") throw new IllegalArgumentException("Bitte Zeit im Format HH:MM ausgeben");
	 int hour; int min;
	 	String hours=s.charAt(0)+s.charAt(1);
	 	Stringmins=s.charAt(3)+s.charAt(4);
		hour=Integer.parseInt(hours);
		min=Integer.parseInt(mins);	 
	 Calendar c= Calendar.getInstance();
	 c.set(Calendar.HOUR_OF_DAY, hour);
	 c.set(Calendar.Minute(min);
	 return c;
	}
	
	public Calendar getDatum(String s){
	if((s.charAt(2)!="-")&&(s.charAt(5)!="-") thorw new IllegalArgumentException ("Bitte Datum im Format DD-MM-YYYY angeben");
	int month, int year, int day;
	String days=s.charAt(0)+s.charAt(1);
	String months = s.charAt(3)+charAt(4);
	String years = s-charAt(6)+s.charAt(7); 
	month=Integer.parseInt(months);
	year=Integer.parseInt(years);
	day=Integer.parseInt(days);
	Calendar c=Calendar.getInstance();
	c.set(year, month, day);
	return c;
	}
	
	

}
*/
