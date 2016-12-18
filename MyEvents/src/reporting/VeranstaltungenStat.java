package reporting;

import java.io.*;
import java.util.Date;
import DAO.PoolDAO;
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
			Date dateFrom = (Date)paramValues.get("DateFrom");
			Date dateTo = (Date)paramValues.get("DateTo");
			
			//calc Data
			java.util.ArrayList<InnerDataClass> data = new java.util.ArrayList<InnerDataClass>();
			for (user.User u : PoolDAO.poolDAO.getUserDAO().getItems().values()) {
				if (u instanceof user.Veranstalter) 
				{
					Veranstalter v = (Veranstalter)u;
					int anzahlVeranstaltungen = 0, anzahlAnmeldungen = 0;

					for (main.Veranstaltung veranstaltung : PoolDAO.poolDAO.getVeranstaltungDAO().getItems().values()) {
						if (veranstaltung.getUserId() == v.getId() 
								&& !veranstaltung.getStartTime().after(dateTo)
								&& !veranstaltung.getEndTime().after(dateFrom)) {
							
							++anzahlVeranstaltungen;
							anzahlAnmeldungen += veranstaltung.getAvailablePlaces();
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
	    		w.write("<HTML><HEAD><style> .container { width: 80%; margin: 15px auto; } </style>\r\n");
	    		w.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.min.js\"></script>");
	    		w.write("</HEAD><BODY><h2>Veranstaltungen Statistik</h2><canvas id=\"myChart\"></canvas>\r\n");
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
	    		w.write("</script></BODY></HTML>");
			}
		 
			w.flush();
		}
		catch (Exception e) {
		}
		
	}
}
