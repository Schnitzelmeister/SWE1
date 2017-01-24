package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import management.AnalytikerManagement;

@WebServlet("/analytiker/main.jsp")
public class AnalytikerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String step = request.getParameter("step");
    	if (step == null) {
    		response.getWriter().println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">"
				+ "<html>"
				+ "<HEAD>"
				+ "<title>Hauptseite</title>"
				+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
				+ "  <!-- The above 2 meta tags *must* come first in the head; any other head content must come *after* these tags -->"
				+ "  <!-- Bootstrap core CSS -->"
				+ "  <link href=\"../style/css/bootstrap.min.css\" rel=\"stylesheet\">"
				+ "  <!-- Bootstrap theme -->"
				+ "  <link href=\"../style/css/bootstrap-theme.min.css\" rel=\"stylesheet\">"
				+ "  <!-- Custom styles for this template -->"
				+ "  <link href=\"../style/css/bootstrap-general-theme.css\" rel=\"stylesheet\">"
				+ "</HEAD>"
				+ "<BODY>"
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
				+ "            <li class=\"active\"><a href=\"#\">Startseite</a></li>");
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
				+ "      <!-- Main jumbotron for a primary marketing message or call to action -->"
				+ "      <div class=\"jumbotron\">"
				+ "        <h1>Willkommen!</h1>"
				+ "        <p>Willkommen auf der Hauptseite des Analytikers</p>"
				+ "        <p>Bitte wähle oben eine Statisik!</p>"
				+ "      </div>"
				+ "    </div>"
				+ "<!-- Bootstrap core JavaScript"
				+ "    ================================================== -->"
				+ "    <!-- Placed at the end of the document so the pages load faster -->"
				+ "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>"
				+ "    <script src=\"js/bootstrap.min.js\"></script>"
				+ "</BODY>"
				+ "</html>");
    	}
    	else if (step.equals("1")) {
    		String report = request.getParameter("report");
    		
    		response.getWriter().println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">"
    				+ "<html>"
    				+ "<HEAD>"
    				+ "<title>Hauptseite</title>"
    				+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
    				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
    				+ "  <!-- The above 2 meta tags *must* come first in the head; any other head content must come *after* these tags -->"
    				+ "  <!-- Bootstrap core CSS -->"
    				+ "  <link href=\"../style/css/bootstrap.min.css\" rel=\"stylesheet\">"
    				+ "  <!-- Bootstrap theme -->"
    				+ "  <link href=\"../style/css/bootstrap-theme.min.css\" rel=\"stylesheet\">"
    				+ "  <!-- Custom styles for this template -->"
    				+ "  <link href=\"../style/css/bootstrap-general-theme.css\" rel=\"stylesheet\">"
    				+ "<link rel=\"stylesheet\" href=\"https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">"
    				+ "<script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>"
    				+ "<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script><script>$( function() {\r\n"); 
    		
    		for(java.util.Iterator<java.util.Map.Entry<String, reporting.ParamType> > it = AnalytikerManagement.getReportByName(report).getParams().entrySet().iterator(); it.hasNext(); ) {
    			java.util.Map.Entry<String, reporting.ParamType> e = it.next();
    			if (e.getValue().equals(reporting.ParamType.Date) )
    				response.getWriter().println("$( \"#"+e.getKey()+"\" ).datepicker({ dateFormat: 'dd.mm.yy' });\r\n");
    		}
    		
    		response.getWriter().println("\r\n} );</script></HEAD>"
    				+ "<BODY>"
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
    				+ "            <li class=\"active\"><a href=\"#\">Startseite</a></li>"
    				+ "          </ul>"
    				+ "          <ul class=\"nav navbar-nav navbar-right\">"
    				+ "            <li><a href=\"javascript:{}\" onclick=\"document.getElementById('my_form').submit(); return false;\">Logout</a></li>"
    				+ "          </ul>"
    				+ "        </div><!--/.nav-collapse -->"
    				+ "      </div>"
    				+ "    </nav>"
    				+ "    "
    				+ "    <div class=\"container theme-showcase\" role=\"main\">"
    				+ "<form method=\"post\" action=\"main.jsp\"><input type=\"hidden\" name=\"step\" value=\"2\" />"
    				+ "<input type=\"hidden\" name=\"report\" value=\"" + report + "\" /><ul class=\"list-group\">");

    		for(java.util.Iterator<java.util.Map.Entry<String, reporting.ParamType> > it = AnalytikerManagement.getReportByName(report).getParams().entrySet().iterator(); it.hasNext(); ) {
    			java.util.Map.Entry<String, reporting.ParamType> e = it.next();
    			if (e.getValue().equals(reporting.ParamType.Date) )
    				response.getWriter().println("<li class=\"list-group-item\"><label>" + e.getKey() + ":</label>  <input id=\"" + e.getKey() + "\" name=\"" + e.getKey() + "\" type=\"text\"/></li>");
    			else if (e.getValue().equals(reporting.ParamType.Boolean) )
    				response.getWriter().println("<li class=\"list-group-item\"><label>" + e.getKey() + ":</label>  <select name=\"" + e.getKey() + "\"/><option value=\"1\">True</option><option value=\"0\">False</option></select></label></li>");
    			else
    				throw new java.lang.UnsupportedOperationException("not impl");
    		}
    			
    		response.getWriter().println("</br>"
    				+ "<li class=\"list-group-item\"><input type=\"submit\" value=\"Done\"/></li></ul></form></div>"
    				+ "    <!-- Bootstrap core JavaScript"
    				+ "    ================================================== -->"
    				+ "    <!-- Placed at the end of the document so the pages load faster -->"
    				+ "    <script src=\"js/bootstrap.min.js\"></script>"
    				+ "</BODY></HTML>");
    	}
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String step = request.getParameter("step");

    	if (step.equals("2")) {
    		
    		String report = request.getParameter("report");
    		System.out.println("report = "+ report);
    		
    		java.util.TreeMap<String, Object> paramValues = new java.util.TreeMap<String, Object>();
    		for(java.util.Iterator<java.util.Map.Entry<String, reporting.ParamType> > it = AnalytikerManagement.getReportByName(report).getParams().entrySet().iterator(); it.hasNext(); ) {
    			java.util.Map.Entry<String, reporting.ParamType> e = it.next();
    			if (e.getValue().equals(reporting.ParamType.Date) ) {
    				try {
						java.text.DateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
						//System.out.println( "request.getParameter(e.getKey()) = " + e.getKey() + "  " + request.getParameter(e.getKey()) );
						paramValues.put(e.getKey(), format.parse( request.getParameter(e.getKey()) ) );
						//System.out.println( ((java.util.Date)paramValues.get(e.getKey())) );
    				}
    				catch (Exception ex) {
    					ex.printStackTrace();
    				}
    			}
    			else
    				paramValues.put(e.getKey(), request.getParameter(e.getKey()) );
    		}
    		
    		AnalytikerManagement.execReport(response, report, paramValues);
    		
    		//AnalytikerManagement.execReport(getServletContext().getRealPath("/analytiker/report.csv"), report, paramValues);
    		//response.getWriter().println(getServletContext().getRealPath("/analytiker/report.csv"));
    		//response.sendRedirect( "/analytiker/report.csv" );   		
    	}
    	else
    		doGet(request, response);
    }
}
