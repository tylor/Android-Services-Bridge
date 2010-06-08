package com.affinity.model;

/**
 * Simple class to represent content types in Drupal.
 * 
 * @author tylor
 *
 */
public class ContentType {
	private String title;
	private String body;
	private String type = "page";
	
	public ContentType() { }
	
	public ContentType(String title, String body) {
		this.title = title;
		this.body = body;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setBody(String body) {
		this.title = body;
	}
	public String getBody() {
		return body;
	}
	public String getType() {
		return type;
	}
}