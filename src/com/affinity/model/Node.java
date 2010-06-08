package com.affinity.model;

public class Node {
	private ContentType type;
	private int nid;
	private String title;
	private String body;

	Node() {
		
	}
	
	public Node(String title, String body, ContentType type) {
		this.title = title;
		this.body = body;
		this.type = type;
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
	public ContentType getType() {
		return type;
	}
	public int getNid() {
		return nid;
	}
}
