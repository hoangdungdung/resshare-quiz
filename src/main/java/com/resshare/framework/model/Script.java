package com.resshare.framework.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Script implements Serializable {
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

	public Script() {
		this.type = "Script";
	}

	private static final long serialVersionUID = 1L;

	public int getVarianCount() {
		return list_return_method.size();

	}

	public void addReturn(Serializable returnVarian) {
		list_return_method.add(returnVarian);

	}

	public void addCommand(Serializable command) {
		if ((openFuntion == true) && (script_funtion != null)) {
			script_funtion.addCommand(command);
		} else {
			list_command.add(command);

		}
	}

	boolean openFuntion = false;

	public void addOpenFuntion(Script script_funtion) {
		this.script_funtion = script_funtion;
		openFuntion = true;
	}

	public void addcloseFuntion() {
		openFuntion = false;

	}

	private ArrayList<Serializable> list_command = new ArrayList<>();
	private ArrayList<Serializable> list_return_method = new ArrayList<>();
	private Script script_funtion;

	// Getter Methods

	public ArrayList<Serializable> getList_command() {
		return list_command;
	}

	public ArrayList<Serializable> getList_return_method() {
		return list_return_method;
	}

	public Script getScript_funtion() {
		return script_funtion;
	}

	// Setter Methods

	public void setList_command(ArrayList<Serializable> list_command) {
		this.list_command = list_command;
	}

	public void setList_return_method(ArrayList<Serializable> list_return_method) {
		this.list_return_method = list_return_method;
	}

	public void setScript_funtion(Script script_funtion) {
		this.script_funtion = script_funtion;
	}

	LinkedHashMap hm = new LinkedHashMap();

	public void addVarian(Object varian, Object referent) {
		hm.put(varian, referent);

	}

	public Object getVarian(Object varian) {
		if(hm.containsKey(varian))
		return hm.get(varian);
		return null;

	}

	public void clearVarian() {

		hm.clear();
	}
}
