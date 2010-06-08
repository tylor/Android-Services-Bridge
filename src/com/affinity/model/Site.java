package com.affinity.model;

import java.util.Vector;

public class Site {
	private String url;
	private Vector<ContentType> contentTypes = new Vector<ContentType>();
	
	Site(String url) {
		this.url = url;
	}
	
	String getUrl() {
		return url;
	}
	
	Vector<ContentType> getContentTypes() {
		return contentTypes;
	}
	
	void addContentType(ContentType type) {
		contentTypes.add(type);
	}
}
