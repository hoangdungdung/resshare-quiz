package com.resshare.framework.model;

import java.io.Serializable;

public class Maper implements Serializable {
	/**
	 * 
	 */
	private String type;

	public void setType(String type) {
		this.type = type;

	}

	public String getType() {
		return this.type;

	}

	public Maper() {
		this.type = "ReturnMethod";
	}
	private static final long serialVersionUID = 1L;
	Script script;
	private String name;

	public Maper(Script script, String name) {
		this.script = script;
		this.name = name;
		this.type = "Maper";
	}

	public void save(String variandName, Object text) {
		String command = "add value: " + text.toString() + " to variandName " + variandName;
		script.addCommand(command);

	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
