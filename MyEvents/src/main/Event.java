package main;

import java.util.Calendar;
import java.util.Date;

public class Event {
	private Integer id;
	private String title;
    private String start;
    private String end;
    
    public Event(String title, String from, String to){
    	this.title=title;
    	this.start=from;
    	this.end=to;
    }
    
    public Integer getId(){
    	return id;
    }
    
    public void setId(Integer id){
    	this.id=id;
    }
    
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
    
    
}
