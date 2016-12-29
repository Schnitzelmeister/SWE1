package user;

import java.util.ArrayList;

import main.OeffentlicherKalender;
import management.*;

public class Veranstalter extends User{
	
	private static final long serialVersionUID = 100L;
	
	private ArrayList<Integer> myEvents;
	private OeffentlicherKalender kalender;

	public ArrayList<Integer> getMyEvents() {
		return myEvents;
	}

	public void setMyEvents(ArrayList<Integer> myEvents) {
		this.myEvents = myEvents;
	}
	
	public OeffentlicherKalender getOeKalender(){
		return kalender;
	}
	
	public void setOeKalender(OeffentlicherKalender kal){
		this.kalender=kal;
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
