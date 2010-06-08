package com.affinity.model;

import java.util.Vector;

/**
 * Simple class to represent content types in Drupal.
 * 
 * @author tylor
 *
 */
public class ContentType {
	private String machineName;
	private Vector<Field> fields;
	
	public ContentType() { }
	
	public ContentType(String type) {
		this.machineName = type;
	}
	
	public String getMachineName() {
		return machineName;
	}

	public void setFields(Vector<Field> fields) {
		this.fields = fields;
	}

	public Vector<Field> getFields() {
		return fields;
	}
}