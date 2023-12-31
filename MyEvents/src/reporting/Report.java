package reporting;

import java.io.Writer;

/*
 * Die Abstracte Klasse fuer aller Reporting im System. Man muss von dieser Klasse ableiten, um einen neuen Report zu erstellen
 */
public abstract class Report {

	protected java.util.TreeMap<String, ParamType> params = new java.util.TreeMap<String, ParamType>();
	
	public java.util.TreeMap<String, ParamType> getParams() { return params; }

	/*
	 * executiert den Report
	 */
	public abstract void exec(Writer w, java.util.TreeMap<String, Object> paramValues, javax.servlet.http.HttpServletResponse response);

	public void exec(Writer w, java.util.TreeMap<String, Object> paramValues) {
		exec(w, paramValues, null);
	}
}
