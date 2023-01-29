package com.resshare.framework.model;

public class Output {

	private String aplication;

	private String key;

	private String json;

	private String dataCollection;

	public Output() {

	}

	public Output(String aplication, String key, String json) {

		this.aplication = aplication;
		this.key = key;
		this.json = json;
	}

	public String getDataCollection() {
		return dataCollection;
	}

	public void setDataCollection(String dataCollection) {
		this.dataCollection = dataCollection;
	}

	public String getAplication() {
		return aplication;
	}

	public void setAplication(String aplication) {
		this.aplication = aplication;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	String userId;

	private String event;

	public String getUserId() {

		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;

	}
	public String getEvent() {

		return event;
	}

	public void setEvent(String event) {
		this.event = event;

	}
}
