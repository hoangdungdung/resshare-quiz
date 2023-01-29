package com.resshare.framework.model;

import java.util.Map;

public class Input {

	 
	private String application;
	
	private String key;
	
	private  String json;
	private  Map jsonmap;
	

	private String dataCollection;
	private String sUri;
	private String module;

	private String id;

	public Input(){
		 
	}
	
	public Input(  String application, String key,  String json){
	 
		this.application = application;
		this.key = key;
		this.json = json;
	}

	public Input(  String application, String key,  Map  jsonmap){
		 
		this.application = application;
		this.key = key;
		this.jsonmap = jsonmap;
	}


	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}
	
 
	public String getDataCollection() {
		return dataCollection;
	}

	public void setDataCollection(String dataCollection) {
		this.dataCollection = dataCollection;
	}
	
 

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public  String getJson() {
		return json;
	}

	public void setJson( String json) {
		this.json = json;
	}

	public  Map getJsonmap() {
		return jsonmap;
	}

	public void setJsonmap( Map jsonmap) {
		this.jsonmap = jsonmap;
	}
	  

	@Override
	public String toString() {
		return "Input [ aplication=" + application + ", key=" + key
				+ ", json=" + json + "]";
	}

	public String getUri() {
		
		return this.sUri;
	}

	
	public void setUri(String sUri) {
		this.sUri = sUri;
		
	}

	public void setId(String id) {
		this.id = id;
		
	}
	
	public String getId() {
		
		return this.id;
	}


}
