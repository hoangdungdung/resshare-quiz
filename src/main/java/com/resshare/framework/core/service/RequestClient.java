package com.resshare.framework.core.service;

import java.util.HashMap;
import java.util.Map;

import com.resshare.framework.core.reflectproxy.ProxyDemo;
import com.resshare.framework.model.Input;

public class RequestClient {

	public  static  void sendRequest(String application, String secretKey, String sDataCollection, Map objJs) {
		ProxyDemo<IRequest> pr = new ProxyDemo<IRequest>();
		IRequest iRequest = pr.create(IRequest.class);
		Input input = new Input(application, secretKey, objJs);
		input.setDataCollection(sDataCollection);
		iRequest.input(input);
	}
	//RequestClient.sendRequest("resshare", "key1", FireBaseReference.draft_get_resshare_user_id, mapReturn);
	
	public  static  void sendRequestResshareUserId( Map objJs) {
		ProxyDemo<IRequest> pr = new ProxyDemo<IRequest>();
		IRequest iRequest = pr.create(IRequest.class);
		Input input = new Input("resshare", "key1", objJs);
		input.setDataCollection(FireBaseReference.draft_get_resshare_user_id);
		iRequest.input(input);
	}
	
	public  static  void appConnectRS(String app_name, String backend_key,String backend_address) {
		
//		String app_name = snapshot1.child("app_name").getValue(String.class);
//		String backend_key_input = (String) snapshot1.child("backend_key").getValue(String.class);
//		String backend_address_input = (String) snapshot1.child("backend_address").getValue(String.class);
		HashMap objJs=new HashMap<>();
		objJs.put("app_name", app_name);
		objJs.put("backend_key", backend_key);
		objJs.put("backend_address", backend_address);
		objJs.put("application", "resshare_configuration");
		
		
		sendRequest("resshare_configuration",backend_key,FireBaseReference.draft_backend_address_register_app,objJs);
		  
		
	}

	public  static  void registerDeveloper(String mail_address) {

//		String app_name = snapshot1.child("app_name").getValue(String.class);
//		String backend_key_input = (String) snapshot1.child("backend_key").getValue(String.class);
//		String backend_address_input = (String) snapshot1.child("backend_address").getValue(String.class);
		HashMap objJs=new HashMap<>();
		objJs.put("mail_address", mail_address);

		objJs.put("application", "resshare_configuration");


		sendRequest("resshare_configuration","backend_key",FireBaseReference.register_developer,objJs);


	}


	public  static  void createApplication(String mail_address, String register_developer_key, String name) {

//		String app_name = snapshot1.child("app_name").getValue(String.class);
//		String backend_key_input = (String) snapshot1.child("backend_key").getValue(String.class);
//		String backend_address_input = (String) snapshot1.child("backend_address").getValue(String.class);
		HashMap objJs=new HashMap<>();
		objJs.put("register_developer_key", register_developer_key);
		objJs.put("mail_address", mail_address);
		objJs.put("name", name);


		objJs.put("application", "resshare_configuration");


		sendRequest("resshare_configuration","backend_key",FireBaseReference.create_application,objJs);


	}

}
