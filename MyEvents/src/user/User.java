package user;

import DAO.*;

public abstract class User extends PersistableObject {
	
	private String username;
	private String passwort;
	private String realName;
	private String email;
	private String phone;
	
	
	public int getUserId() {
		return super.id;
	}

	public String getUsername() {
		return username;
	}

	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public User(String un, String pw, String rn, String e, String p){
		this.username=un;
		this.passwort=pw;
		this.realName=rn;
		this.phone=p;
	}
	
	public User(){
	}
	
	
}
