package main;

import java.util.ArrayList;

public class OeffentlicherKalender {
	private static final long serialVersionUID = 100L;
	
	ArrayList<Integer> events;
	
	OeffentlicherKalender(){
		events=new ArrayList<Integer>();
	}
	
	public void setEvents(ArrayList<Integer> ev){
		this.events=ev;
	}
	
	public ArrayList<Integer> getEvents(){
		return events;
	}
	
	

}
