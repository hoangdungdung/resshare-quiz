package com.resshare.framework.model;

public class ScriptMetadata {
	private String event;
	 private Script script;
	 private String user_id_destination;
	private String type;

	public void setType(String type) {
		this.type = type;

	}

	public String getType() {
		return this.type;

	}

	public ScriptMetadata() {
		this.type = "ScriptMetadata";
	}

	 // Getter Methods 

	 public String getEvent() {
	  return event;
	 }

	 public Script getScript() {
	  return script;
	 }

	 public String getUser_id_destination() {
	  return user_id_destination;
	 }

	 // Setter Methods 

	 public void setEvent(String event) {
	  this.event = event;
	 }

	 public void setScript(Script script) {
	  this.script = script;
	 }

	 public void setUser_id_destination(String user_id_destination) {
	  this.user_id_destination = user_id_destination;
	 }
	}