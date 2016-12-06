package user;

import management.*;

public class Admin extends User{
	
	private AdminManagement management;
	
	public Admin(int ui, String un, String pw, String rn, String e, String p, AdminManagement m){
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
