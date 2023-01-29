package com.resshare.framework.core.service;

import java.util.HashMap;
import java.util.Map;

public class DashboardMessage {

	private String application;
	private String event;
	private String processing;
	private String user_id_destination;

	// Getter Methods

	public String getApplication() {
		return application;
	}

	public String getEvent() {
		return event;
	}

	public String getProcessing() {
		return processing;
	}

	public String getUser_id_destination() {
		return user_id_destination;
	}

	// Setter Methods

	public void setApplication(String application) {
		this.application = application;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public void setProcessing(String processing) {
		this.processing = processing;
	}

	public void setUser_id_destination(String user_id_destination) {
		this.user_id_destination = user_id_destination;
	}

	private HashMap data;

	public HashMap getData() {
		return data;
	}

	public void setData(HashMap data) {
		this.data = data;
	}

	HashMap mHashMap = new HashMap();

	// private String application;
	// private String event;
	// private String processing;
	// private String user_id_destination;
	public Map totHashMap() {

		mHashMap.put("application", application);
		mHashMap.put("event", event);
		mHashMap.put("user_id_destination", user_id_destination);
		mHashMap.put("data", data);
		mHashMap.put("delete", delete);

		return mHashMap;
	}

	int delete;
//0 nodelete
	//1 delete
	public void setDelete(int delete) {

		this.delete = delete;
	}

	public int getDelete() {

		return delete;
	}

}
