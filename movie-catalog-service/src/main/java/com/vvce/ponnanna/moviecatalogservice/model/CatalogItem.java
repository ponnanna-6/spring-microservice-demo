package com.vvce.ponnanna.moviecatalogservice.model;

public class CatalogItem {
	private String name;
	private String descString;
	private int rating;
	
	
	public CatalogItem(String name, String descString, int rating) {
		super();
		this.name = name;
		this.descString = descString;
		this.rating = rating;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescString() {
		return descString;
	}
	public void setDescString(String descString) {
		this.descString = descString;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
