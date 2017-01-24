package reporting;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import DAO.PoolDAO;
import management.AnalytikerManagement;
import user.Veranstalter;
/* 
 * Beispiel eines Reportes
 */
@ReportDescription(Description = "Veranstaltungen Report")
public class VeranstaltungenStat extends Report {
	
	public VeranstaltungenStat() {
		this.params.put("DateFrom", reporting.ParamType.Date);
		this.params.put("DateTo", reporting.ParamType.Date);
		this.params.put("IsDiagramm", reporting.ParamType.Boolean);
	}
	
    private class InnerDataClass {
        String veranstalter;
        int anzahlVeranstaltungen;
        int anzahlAnmeldungen;
        
        InnerDataClass( String veranstalter, int anzahlVeranstaltungen, int anzahlAnmeldungen) {
			this.veranstalter = veranstalter;
			this.anzahlVeranstaltungen = anzahlVeranstaltungen;
			this.anzahlAnmeldungen = anzahlAnmeldungen;
        }
    }
    
	public void exec(Writer w, java.util.TreeMap<String, Object> paramValues, javax.servlet.http.HttpServletResponse response) {

		try {
			
			boolean isDiagram = (paramValues.get("IsDiagramm").equals("1"));
			Calendar dFC = Calendar.getInstance();
			dFC.setTime((Date)paramValues.get("DateFrom"));  
			dFC.set(Calendar.HOUR, 0);
			dFC.set(Calendar.MINUTE, 0);
			dFC.set(Calendar.SECOND, 0);
			dFC.add(Calendar.SECOND, -1);
			
			Date dateFrom = dFC.getTime();
			//System.out.println( dateFrom );
			
			Calendar dTC = Calendar.getInstance();
			dTC.setTime((Date)paramValues.get("DateTo")); 
			dTC.set(Calendar.HOUR, 0);
			dTC.set(Calendar.MINUTE, 0);
			dTC.set(Calendar.SECOND, 0);
			dTC.add(Calendar.DATE, 1);

			Date dateTo = dTC.getTime();
			//System.out.println( dateTo );

			//calc Data
			java.util.ArrayList<InnerDataClass> data = new java.util.ArrayList<InnerDataClass>();
			for (user.User u : PoolDAO.poolDAO.getUserDAO().getItems().values()) {
				if (u instanceof user.Veranstalter) 
				{
					Veranstalter v = (Veranstalter)u;
					int anzahlVeranstaltungen = 0, anzahlAnmeldungen = 0;

					for (main.Veranstaltung veranstaltung : PoolDAO.poolDAO.getVeranstaltungDAO().getItems().values()) {
/*						System.out.println( veranstaltung.getStartTime().getTime() );
						System.out.println( veranstaltung.getEndTime().getTime() );
						System.out.println( dateFrom );
						System.out.println( dateTo );
						Boolean a = (veranstaltung.getStartTime().after(dateFrom) || veranstaltung.getEndTime().after(dateFrom));
						
						Boolean q = (veranstaltung.getStartTime().getTime().compareTo( dateFrom ) > 0);
						System.out.println( q );

						System.out.println( veranstaltung.getStartTime().after(dateFrom) );
						System.out.println( veranstaltung.getStartTime().before(dateFrom) );
						System.out.println( veranstaltung.getStartTime().equals(dateFrom) );
						System.out.println( "----" );

						System.out.println( veranstaltung.getEndTime().after(dateFrom) );
						System.out.println( a.toString() );
						Boolean b = (veranstaltung.getStartTime().before(dateTo) || veranstaltung.getEndTime().before(dateTo) );
						System.out.println( veranstaltung.getStartTime().before(dateTo) );
						System.out.println( veranstaltung.getEndTime().before(dateTo) );
						System.out.println( b.toString() );*/
						if (veranstaltung.getUserId() == v.getId() 
								&& (veranstaltung.getStartTime().getTime().compareTo( dateFrom ) > 0 || veranstaltung.getEndTime().getTime().compareTo( dateFrom ) > 0)
								&& (veranstaltung.getStartTime().getTime().compareTo( dateTo ) < 0 || veranstaltung.getEndTime().getTime().compareTo( dateTo ) < 0)) {
							
							++anzahlVeranstaltungen;
							anzahlAnmeldungen += veranstaltung.getTeilnehmer();
							//anzahlAnmeldungen += ( veranstaltung.getAvailablePlaces() - veranstaltung.getPlaces() );
						}
					}

					data.add( new InnerDataClass( v.getRealName() /*+ " (id=" + v.getId() + ")"*/, anzahlVeranstaltungen, anzahlAnmeldungen) );
				}
			}

			
			if (!isDiagram) {
				if ( response != null ) {
		    		response.setHeader("Content-Type", "text/csv");
		    		response.setHeader("Content-Disposition", "attachment; filename=\"data.csv\"");
				}
				
				w.write("ID\tRealName\tAnzahlVeranstaltungen\tAnzahlAnmeldungen\r\n");
			}
			else {
	    		w.write("<HTML><HEAD>"
	    				+ "<title>Hauptseite</title>"
	    				+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
	    				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
	    				+ "  <!-- The above 2 meta tags *must* come first in the head; any other head content must come *after* these tags -->"
	    				+ "  <!-- Bootstrap core CSS -->"
	    				+ "  <link href=\"../style/css/bootstrap.min.css\" rel=\"stylesheet\">"
	    				+ "  <!-- Bootstrap theme -->"
	    				+ "  <link href=\"../style/css/bootstrap-theme.min.css\" rel=\"stylesheet\">"
	    				+ "  <!-- Custom styles for this template -->"
	    				+ "  <link href=\"../style/css/bootstrap-general-theme.css\" rel=\"stylesheet\">\r\n");
	    		w.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.min.js\"></script>");
	    		w.write("</HEAD><BODY>"
	    				+ "    <!--  Formular fürs ausloggen -->"
	    				+ "    <form method=\"post\" action=\"../logout\" id=\"my_form\">"
	    				+ "    </form>"
	    				+ " 	<!-- Fixed navbar -->"
	    				+ "    <nav class=\"navbar navbar-inverse navbar-fixed-top\">"
	    				+ "      <div class=\"container\">"
	    				+ "        <div class=\"navbar-header\">"
	    				+ "          <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">"
	    				+ "            <span class=\"sr-only\">Toggle navigation</span>"
	    				+ "            <span class=\"icon-bar\"></span>"
	    				+ "            <span class=\"icon-bar\"></span>"
	    				+ "            <span class=\"icon-bar\"></span>"
	    				+ "          </button>"
	    				+ "          <a class=\"navbar-brand\" href=\"#\">MyEvents</a>"
	    				+ "        </div>"
	    				+ "        <div id=\"navbar\" class=\"navbar-collapse collapse\">"
	    				+ "          <ul class=\"nav navbar-nav\">"
	    				+ "            <li><a href=\"/MyEvents/analytiker/main.jsp\">Startseite</a></li>");
	        		for(java.util.Iterator<java.util.Map.Entry<String, String> > it = AnalytikerManagement.getReportList().entrySet().iterator(); it.hasNext(); ) {
	    				java.util.Map.Entry<String, String> e = it.next();
	    				response.getWriter().println("<li><a href=\"?step=1&report="+ e.getKey() + "\">"+ e.getValue() + "</a></li>");
	    			}
	        		response.getWriter().println("</ul>"
	    				+ "          <ul class=\"nav navbar-nav navbar-right\">"
	    				+ "            <li><a href=\"javascript:{}\" onclick=\"document.getElementById('my_form').submit(); return false;\">Logout</a></li>"
	    				+ "          </ul>"
	    				+ "        </div><!--/.nav-collapse -->"
	    				+ "      </div>"
	    				+ "    </nav>"
	    				+ "    "
	    				+ "    <div class=\"container theme-showcase\" role=\"main\">"
	    				+ "<h1>Veranstaltungen Statistik</h1><canvas id=\"myChart\"></canvas>\r\n");
			}
			
			
			if (!isDiagram) {
				for (InnerDataClass d : data) {
					w.write( d.veranstalter  + "\t" + d.anzahlVeranstaltungen + "\t" + d.anzahlAnmeldungen + "\r\n");
				}
			}
			else {
	    		w.write("<script>\r\nvar ctx = document.getElementById(\"myChart\").getContext('2d');\r\n");
	    		w.write("var myChart = new Chart(ctx, { \r\n"
	    				+ "type: 'bar',\r\n"
	    				+ "data: { labels: [\r\n");
	    		
	    		if ( data.size() != 0 )
	    			w.write("\"" + data.get(0).veranstalter + "\"");
	    		for (int i = 1; i < data.size(); ++i)
	    			w.write(",\"" + data.get(i).veranstalter + "\"");
	    			
    			w.write("],\r\n"
	    				+ "datasets: [{ \r\n"
	    				+ "label: 'Die Anzahl der Veranstaltungen',\r\n"
	    				+ "data: [");
    			
	    		if ( data.size() != 0 )
	    			w.write(data.get(0).anzahlVeranstaltungen + "");
	    		for (int j = 1; j < data.size(); ++j)
	    			w.write("," + data.get(j).anzahlVeranstaltungen);
	    			
	    		w.write("],\r\n"
	    				+ "backgroundColor: \"rgba(153,255,51,1)\"\r\n"
	    				+ "}, {\r\n"
	    				+ "label: 'Die Anzahl der Anmeldungen',\r\n"
	    				+ "data: [");

	    		if ( data.size() != 0 )
	    			w.write(data.get(0).anzahlAnmeldungen + "");
	    		for (int k = 1; k < data.size(); ++k)
	    			w.write("," + data.get(k).anzahlAnmeldungen);
		    				
	    		w.write("],"
	    				+ "backgroundColor: \"rgba(255,153,0,1)\"\r\n"
	    				+ "}]\r\n"
	    				+ "}\r\n"
	    				+ "});\r\n");
	    		w.write("</script>"
	    				+ "    <!-- Bootstrap core JavaScript"
	    				+ "    ================================================== -->"
	    				+ "    <!-- Placed at the end of the document so the pages load faster -->"
	    				+ "    <script src=\"js/bootstrap.min.js\"></script>"
	    				+ "</BODY></HTML>");
			}
		 
			w.flush();
		}
		catch (Exception e) {
		}
		
	}
}
