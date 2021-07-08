package model;

import java.io.Serializable;

public class Fragments implements Serializable {
	
	private int id;
	private String day;
	private String title;
	private String fragment;
	
	public Fragments(){}
	
		
	public int getId() {
		return id;
	}
	public String getDay() {
		return day;
	}

	public String getTitle() {
		return title;
	}
	public String getFragment() {
		return fragment;
	}

	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setFragment(String fragment) {
		this.fragment = fragment;
	}
	
}
