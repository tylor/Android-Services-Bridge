package com.affinity.model;

import java.util.Vector;

public class Site {
	private String name;
	private String url;
	private Vector<ContentType> contentTypes = new Vector<ContentType>();
	
	public Site(String name, String url) {
		this.setName(name);
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public Vector<ContentType> getContentTypes() {
		return contentTypes;
	}
	
	public void addContentType(ContentType type) {
		contentTypes.add(type);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
