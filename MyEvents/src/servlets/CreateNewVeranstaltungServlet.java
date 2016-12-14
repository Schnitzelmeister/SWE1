/**
 * */
 
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
		Calendar start = getZeit(starts);
		Calendar end = getZeit(ends);
		Calendar datum=getDatum(datums);
		int month=datum.get(Calendar.MONTH);
		int year=datum.get(Calendar.YEAR);
		int day=datum.get(Calendar.DAY_OF_MONTH);
		start.set(Calendar.DAY_OF_MONTH,day);
		start.set(Calendar.MONTH, month);
		start.set(Calendar.YEAR, year);
		end.set(Calendar.DAY_OF_MONTH,day);
		end.set(Calendar.MONTH, month);
		end.set(Calendar.YEAR, year);
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
	
	public Calendar getZeit(String s) throws IllegalArgumentException{
		 if(s.charAt(2)!=':') {throw new IllegalArgumentException("Bitte Zeit im Format HH:MM ausgeben");}
		 int hour; int min;
		 	char h1= s.charAt(0); char h2=s.charAt(1);
		 	char m1=s.charAt(3); char m2=s.charAt(4);
		 	String hours=Character.toString(h1)+Character.toString(h2);
		 	String mins=Character.toString(m1)+Character.toString(m2);
			hour=Integer.parseInt(hours);
			min=Integer.parseInt(mins);	 
		 Calendar c= Calendar.getInstance();
		 c.set(Calendar.HOUR_OF_DAY, hour);
		 c.set(Calendar.MINUTE, min);
		 return c;
		}
		
		public Calendar getDatum(String v)throws IllegalArgumentException{
		if((v.charAt(2)!='-')&&(v.charAt(5)!='-')) {throw new IllegalArgumentException("Bitte Datum im Format DD-MM-YYYY angeben");}
		int month; int year; int day;
		char d1=v.charAt(0); char d2=v.charAt(1);
		char m1=v.charAt(3); char m2=v.charAt(4);
		char y1=v.charAt(6); char y2=v.charAt(7);
		
		String days=Character.toString(d1)+Character.toString(d2);
		String months =Character.toString(m1)+Character.toString(m2);
		String years = Character.toString(y1)+Character.toString(y2); 
		month=Integer.parseInt(months);
		year=Integer.parseInt(years);
		day=Integer.parseInt(days);
		Calendar c=Calendar.getInstance();
		c.set(year, month, day);
		return c;
		}

}

