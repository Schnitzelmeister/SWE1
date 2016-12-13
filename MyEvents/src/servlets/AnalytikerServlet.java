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
		response.getWriter().println("<HTML><HEAD><link rel=\"stylesheet\" type=\"text/css\" href=\"/MyEvents/style/login.css\"></HEAD><BODY>"
				+ "<form method=\"post\"><input type=\"hidden\" name=\"step\" value=\"1\" /><select name=\"report\">");

		for(java.util.Iterator<java.util.Map.Entry<String, String> > it = AnalytikerManagement.getReportList().entrySet().iterator(); it.hasNext(); ) {
			java.util.Map.Entry<String, String> e = it.next();
			response.getWriter().println("<option value=\""+ e.getKey() + "\">"+ e.getValue() + "</option>");
		}
			
		response.getWriter().println("</select><input type=\"submit\" value=\"Weiter\"/></form>"
				+ "</BODY></HTML>");
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String step = request.getParameter("step");
    	if (step.equals("1")) {
    		
    		String report = request.getParameter("report");
    		
    		response.getWriter().println("<HTML><HEAD><link rel=\"stylesheet\" type=\"text/css\" href=\"/MyEvents/style/login.css\"><link rel=\"stylesheet\" href=\"https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">"
    				+ "<script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script><script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script><script>$( function() {\r\n");
    		
    		for(java.util.Iterator<java.util.Map.Entry<String, reporting.ParamType> > it = AnalytikerManagement.getReportByName(report).getParams().entrySet().iterator(); it.hasNext(); ) {
    			java.util.Map.Entry<String, reporting.ParamType> e = it.next();
    			if (e.getValue().equals(reporting.ParamType.Date) )
    				response.getWriter().println("$( \"#"+e.getKey()+"\" ).datepicker({ dateFormat: \"dd.mm.yy\" });\r\n");
    		}
    		
    		response.getWriter().println("\r\n} );</script></HEAD><BODY>"
    				+ "<form method=\"post\"><input type=\"hidden\" name=\"step\" value=\"2\" />"
    				+ "<input type=\"hidden\" name=\"report\" value=\"" + report + "\" />"
    				+ "<table>");

    		for(java.util.Iterator<java.util.Map.Entry<String, reporting.ParamType> > it = AnalytikerManagement.getReportByName(report).getParams().entrySet().iterator(); it.hasNext(); ) {
    			java.util.Map.Entry<String, reporting.ParamType> e = it.next();
    			if (e.getValue().equals(reporting.ParamType.Date) )
    				response.getWriter().println("<tr><td>" + e.getKey() + ":</td><td><input id=\"" + e.getKey() + "\" name=\"" + e.getKey() + "\" type=\"text\"/></td></tr>");
    		}
    			
    		response.getWriter().println("</table><input type=\"submit\" value=\"Download as CSV\"/></form>"
    				+ "</BODY></HTML>");
    	}
    	else if (step.equals("2")) {
    		
    		String report = request.getParameter("report");
    		
    		java.util.TreeMap<String, Object> paramValues = new java.util.TreeMap<String, Object>();
    		for(java.util.Iterator<java.util.Map.Entry<String, reporting.ParamType> > it = AnalytikerManagement.getReportByName(report).getParams().entrySet().iterator(); it.hasNext(); ) {
    			java.util.Map.Entry<String, reporting.ParamType> e = it.next();
    			if (e.getValue().equals(reporting.ParamType.Date) ) {
    				try {
						java.text.DateFormat format = new java.text.SimpleDateFormat("dd.mm.yyyy");
						paramValues.put(e.getKey(), format.parse( request.getParameter(e.getKey()) ) );
    				}
    				catch (Exception ex) {}
    			}
    			else
    				paramValues.put(e.getKey(), request.getParameter(e.getKey()) );
    		}
    		
    		AnalytikerManagement.execReport(response.getWriter(), report, paramValues);
    		
    		//AnalytikerManagement.execReport(getServletContext().getRealPath("/analytiker/report.csv"), report, paramValues);
    		//response.getWriter().println(getServletContext().getRealPath("/analytiker/report.csv"));
    		//response.sendRedirect( "/analytiker/report.csv" );   		
    	}
    	else
    		doGet(request, response);
    }
}
