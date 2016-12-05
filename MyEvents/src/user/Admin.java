package src.user;

import src.management.*;

public class Admin extends User{
	
	private AdminManagement management;
	
	public Admin(int ui, String un, String pw, String rn, String e, String p, Adminmanagement m){
		super(ui, un, pw, rn, e, p);
		this.management=m;
	}
	
	public AdminManagement getAdManagement(){
		return management;
	}
	
	public void setAdManagement(AdminManagement m){
		this.management=m;
	}
	
	

}