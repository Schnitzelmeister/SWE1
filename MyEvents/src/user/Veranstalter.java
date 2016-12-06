package user;

import java.util.ArrayList;

import management.*;

public class Veranstalter extends User{
	
	private ArrayList<Integer> myEvents;
	private VeranstalterManagement management;

	public ArrayList<Integer> getMyEvents() {
		return myEvents;
	}

	public void setMyEvents(ArrayList<Integer> myEvents) {
		this.myEvents = myEvents;
	}
	public VeranstalterManagement getVeranstalterManagement(){
		return management;
	}
	
	public void setVeranstalterManagement(VeranstalterManagement m){
		this.management=m;
	}
	
	public Veranstalter(int ui, String un, String pw, String rn, String e, String p, VeranstalterManagement m){
		super(ui, un, pw, rn, e, p);
		this.management=m;
	}
	
	

}
