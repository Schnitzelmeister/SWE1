package reporting;

import java.io.*;

import DAO.PoolDAO;
/* 
 * Beispiel eines Reportes
 */
@ReportDescription(Description = "VeranstalterStat Report")
public class VeranstalterStat extends Report {
	public void exec(Writer w, java.util.TreeMap<String, Object> paramValues) {

		try {
			for (user.User v : PoolDAO.poolDAO.getUserDAO().getItems().values()) {
				//if (v instanceof user.Veranstalter) 
				{
					w.write(v.getRealName() + "\r\n");
				}
			}
		 
			w.flush();
		}
		catch (Exception e) {
		}
		
	}
}
