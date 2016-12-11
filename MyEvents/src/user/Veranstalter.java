package user;

import java.util.ArrayList;

import management.*;

public class Veranstalter extends User{
	
	private ArrayList<Integer> myEvents;

	public ArrayList<Integer> getMyEvents() {
		return myEvents;
	}

	public void setMyEvents(ArrayList<Integer> myEvents) {
		this.myEvents = myEvents;
	}
	
	public Veranstalter(String un, String pw, String rn, String e, String p){
		super(un, pw, rn, e, p);
		myEvents = new ArrayList<Integer>();
	}
	
	public void addEventToMyEvents(Integer eventId){
		myEvents.add(eventId);
	}
	
	public void removeEventFromMyEvents(Integer eventId){
		myEvents.remove(eventId);
	}
	

}
