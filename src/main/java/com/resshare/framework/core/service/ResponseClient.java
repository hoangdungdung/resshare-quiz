package com.resshare.framework.core.service;

import java.util.HashMap;
import java.util.Map;

import com.resshare.framework.core.reflectproxy.ProxyDemo;
import com.resshare.framework.core.response.IResponse;

public class ResponseClient {

	public static void sendResponse(Map objJs) {

		ProxyDemo<IResponse> pr = new ProxyDemo<IResponse>();
		IResponse iResponse = pr.create(IResponse.class);

		iResponse.viewOject(objJs);

	}

	public static void sendResponseScriptUI(Map objJs) {

		// ProxyDemo<IRequest> pr = new ProxyDemo<IRequest>();
		// IRequest iRequest = pr.create(IRequest.class);
		//
		//
		// Input input = new Input("resshare_ui_engine", "key1", objJs);
		//
		//
		//
		//
		// input.setDataCollection(FireBaseReference.draft_ui_engine_get_script_ui_v2);
		//
		// iRequest.input(input);

		RequestClient.sendRequest("resshare_ui_engine", "key1", FireBaseReference.draft_ui_engine_get_script_ui_v2,
				objJs);
	}

	 public static void removeResponse(String messageKey) {
	
	 ProxyDemo<IResponse> pr = new ProxyDemo<IResponse>();
	 IResponse iResponse = pr.create(IResponse.class);
	
	 iResponse.removeResponse(messageKey);
	
	
	 }

//	public static void sendDashboard1(DashboardMessage dashboardMessage) {
//
//		Map objJs = dashboardMessage.totHashMap();
//		sendResponse(objJs);
//		// TODO Auto-generated method stub
//
//	}

	public static void removeResponseMsg(String application, String user_id, String message_key) {
		Map objJs = new HashMap<>();
		objJs.put("application", application);
		objJs.put("user_id", user_id);
		objJs.put("message_key", message_key);

		// ProxyDemo<IRequest> prIRequest = new ProxyDemo<IRequest>();
		// IRequest iRequest = prIRequest.create(IRequest.class);
		// Gson gson = new GsonBuilder().create();
		//
		//
		// String jsonString = gson.toJson(objJs);
		// Input input = new Input("resshare", "key1", jsonString);
		//
		// input.setDataCollection(FireBaseReference.draft_remove_message_dasboard);
		// input.setModule("core");
		// iRequest.input(input);

		RequestClient.sendRequest("resshare", "key1", FireBaseReference.draft_remove_message_dasboard, objJs);

		// TODO Auto-generated method stub

	}

}
