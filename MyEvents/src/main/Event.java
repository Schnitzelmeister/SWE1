package main;

import java.util.Calendar;
import java.util.Date;

public class Event {
	private Integer id;
	private String title;
    private String start;
    private String end;
    private String color;
    
    public Event(Integer id,String title, String from, String to, String color){ 
    	this.id=id;
    	this.title=title;
    	this.start=from;
    	this.end=to;
    	this.color=color;
    }
 /*   
    public Integer getId(){
    	return id;
    }
    
    public void setId(Integer id){
    	this.id=id;
    }
   */ 
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
    
    public String color(){
    	return this.color;
    }
	
	public void setColor(String color){
		this.color=color;
	}
    
    
}
