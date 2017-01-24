package main;

import java.util.ArrayList;

public class OeffentlicherKalender implements java.io.Serializable{
	private static final long serialVersionUID = 100L;
	
	ArrayList<Integer> events;
	
	public OeffentlicherKalender(){
		events=new ArrayList<Integer>();
	}
	
	public void setEvents(ArrayList<Integer> ev){
		this.events=ev;
	}
	
	public ArrayList<Integer> getEvents(){
		return events;
	}
	
	

}
