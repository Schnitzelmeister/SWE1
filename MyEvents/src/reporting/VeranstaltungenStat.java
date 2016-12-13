package reporting;

import java.io.*;

import DAO.PoolDAO;
/* 
 * Beispiel eines Reportes
 */
@ReportDescription(Description = "Veranstaltungen Report")
public class VeranstaltungenStat extends Report {
	
	public VeranstaltungenStat() {
		this.params.put("DateFrom", reporting.ParamType.Date);
		this.params.put("DateTo", reporting.ParamType.Date);
	}
	
	public void exec(Writer w, java.util.TreeMap<String, Object> paramValues) {

		try {
			
			w.write(paramValues.get("DateFrom") + "\r\n");
			w.write(paramValues.get("DateTo") + "\r\n");
			
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
