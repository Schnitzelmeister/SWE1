package reporting;

import java.io.*;
import user.*;

import DAO.PoolDAO;
/* 
 * Beispiel eines Reportes
 */
@ReportDescription(Description = "VeranstalterStat Report")
public class VeranstalterStat extends Report {
	public void exec(Writer w, java.util.TreeMap<String, Object> paramValues, javax.servlet.http.HttpServletResponse response) {

		try {
			if ( response != null ) {
	    		response.setHeader("Content-Type", "text/csv");
	    		response.setHeader("Content-Disposition", "attachment; filename=\"data.csv\"");
			}
			
			w.write("ID\tUsername\tRealName\tEmail\tPhone\r\n");
			for (User u : PoolDAO.poolDAO.getUserDAO().getItems().values()) {
				if (u instanceof user.Veranstalter) 
				{
					Veranstalter v = (Veranstalter)u;
					w.write(v.getUserId() + "\t" + v.getUsername()  + "\t" + v.getRealName()  + "\t" + v.getEmail()  + "\t" + v.getPhone() + "\r\n");
				}
			}

			w.flush();
			w.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
