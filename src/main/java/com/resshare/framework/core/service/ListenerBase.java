package com.resshare.framework.core.service;

import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.resshare.framework.core.DataUtil;
import com.resshare.springboot.StartServiceListenerCore;

public abstract class ListenerBase implements ChildEventListener {
	
	
	
//	protected FirebaseDatabase firebaseDb;
//
//	public void onStart() {
//		firebaseDb=FirebaseDatabase.getInstance();
//		firebaseDb.getReference(getReferenceName()).addChildEventListener(this);
//
//	}
//
//	public void onStop() {
//		firebaseDb.getReference(getReferenceName()).removeEventListener(this);
//	}
//
//	public abstract String getReferenceName();
	
	
	
	
	
	
	
	
	

	protected FirebaseDatabase firebaseDb;

	public void onStart() {
		firebaseDb=FirebaseDatabase.getInstance();
		firebaseDb.getReference(getReferenceName()).addChildEventListener(this);

	}

	public void onStop() {
		firebaseDb.getReference(getReferenceName()).removeEventListener(this);
	}

	public   void cleanInput(DataSnapshot snapshot1) {
		if(StartServiceListenerCore.DEBUG)
		{
		FirebaseDatabase.getInstance().getReference(getReferenceName()).child(snapshot1.getKey())
				.child("processing").setValue("done");
		}else
			FirebaseDatabase.getInstance().getReference(getReferenceName()).child(snapshot1.getKey())
			. setValue(null);
			
	}
	public abstract String getReferenceName();
	
	
	
	public void requestScriptUI(DataSnapshot snapshot1, String script_class,String app_name,String collection) {
		
		
		
 

	
		
		
		
		
		
		
		
		HashMap script_param=new HashMap<>();
		script_param.put("post_collection", collection);
		requestScriptUI(snapshot1, script_class, app_name,script_param);
	}
	
	
	
	public void requestScriptUI(DataSnapshot snapshot1, String script_class,String app_name,HashMap script_param) {
		Map mapReturn = DataUtil.ConvertDataSnapshotToMap(snapshot1);
		mapReturn.put("type", "load_form_script");
		mapReturn.put("cc", "cc");
		mapReturn.put("key_data", "load_form_script");
//		HashMap script_param = new HashMap<>();
//		script_param.put("grid_view_layout_item", grid_view_layout_item);
//		script_param.put("grid_view_data", grid_view_data);

		

		Map mapReturnData = DataUtil.ConvertDataSnapshotToMap(snapshot1.child("data"));
		if (mapReturnData == null)
			mapReturnData = new HashMap<>();

		mapReturnData.put("script",script_class );
	

	
		mapReturnData.put("application_script", app_name);
		mapReturn.put("script_type", "script_type_form");
		mapReturn.put("data", mapReturnData);
		mapReturn.put("script_parameter", script_param);

		// Gson gson = new GsonBuilder().create();
		//
		// ProxyDemo<IRequest> pr = new ProxyDemo<IRequest>();
		// IRequest iRequest = pr.create(IRequest.class);
		// // gson = new GsonBuilder().create();
		// // String jsonString = gson.toJson(mapReturn);
		//
		// Input input = new Input("ui-engine", "key1", mapReturn);
		//
		// input.setDataCollection(FireBaseReference.draft_ui_engine_get_script_ui);
		//
		// iRequest.input(input);
		
		RequestClient.sendRequest("ui-engine", "key1",
				FireBaseReference.draft_ui_engine_get_script_ui, mapReturn);
	}

}
