package src.user;

import src.management.*;

public class Analytiker extends User{
	
	private AnalytikerManagement management;
	
	public Analytiker(int ui, String un, String pw, String rn, String e, String p, Adminmanagement m){
		super(ui, un, pw, rn, e, p);
		this.management=m;
	}
	
	public AnalytikerManagement getAnManagement(){
		return management;
	}
	
	public void setAnManagement(AnalytikerManagement m){
		this.management=m;
	}
	

}
