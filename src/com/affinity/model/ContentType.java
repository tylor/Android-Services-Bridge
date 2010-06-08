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
	private String name;
	private Vector<Field> fields;
	
	public ContentType() { }
	
	public ContentType(String name, String machineName) {
		this.name = name;
		this.machineName = machineName;
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
	
	public String getName() {
		return name;
	}
}