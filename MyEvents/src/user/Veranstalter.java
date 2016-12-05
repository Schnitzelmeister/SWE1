package src.user;

import java.util.ArrayList;

import src.management.*;

public class Veranstalter extends User{
	
	private ArrayList<Integer> myEvents;
	private VeranstalterManagement management;

	public ArrayList<Integer> getMyEvents() {
		return myEvents;
	}

	public void setMyEvents(ArrayList<Integer> myEvents) {
		this.myEvents = myEvents;
	}
	public VeranstalerManagement getVeranstalterManagement(){
		return management;
	}
	
	public void setVeranstalterManagement(VeranstalterManagement m){
		this.management=m;
	}
	
	public Veranstalter(int ui, String un, String pw, String rn, String e, String p, Adminmanagement m){
		super(ui, un, pw, rn, e, p);
		this.management=m;
	}
	
	

}
