package com.resshare.framework.core.service;

import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.resshare.framework.core.DataUtil;

public class GetLayoutMethodScriptLayoutToRightOfListener extends ListenerBase {

	@Override
	public void onChildAdded(DataSnapshot snapshot1, String previousChildName) {
		try {
			if (snapshot1.child("processing").getValue() == null) {

				try {

					//
					// HashMap<String, Object> mapReturn = new HashMap<>();
					// mapReturn.put("user_id_destination",
					// snapshot1.child("user_id_destination").getValue());
					// mapReturn.put("event", snapshot1.child("event").getValue());
					// mapReturn.put("parameter", snapshot1.child("parameter").getValue());
					// // mapReturn.put("data", snapshot.getValue());
					// mapReturn.put("application", snapshot1.child("application").getValue());
					// mapReturn.put("session", snapshot1.child("session").getValue());
					//
					// mapReturn.put("type", snapshot1.child("type").getValue());
					// mapReturn.put("key_data", snapshot1.child("key_data").getValue());
					//
					// mapReturn.put("count_message", snapshot1.child("count_message").getValue());
					//
					//
					// UIBuilder uiBuilder=new UIBuilder();
					//
					//
					//
					// ReturnMethod control = new ReturnMethod("control");
					// uiBuilder.runFuntion("this", "findControlParam", null, null,control);
					////
					// ReturnMethod propertyValue = new ReturnMethod("propertyValue");
					// uiBuilder.runFuntion("this", "findValuelParam", null, null,propertyValue);
					//
					// uiBuilder.runFuntion("this", "findControlParam", null, null,control);
					// ReturnMethod relativeLayoutLayoutParams = new
					// ReturnMethod("relativeLayoutLayoutParams");
					// uiBuilder.runFuntion("this", "findLayoutParam", null,
					// null,relativeLayoutLayoutParams);
					//
					//
					//
					//
					// ReturnMethod controlRight = new ReturnMethod("controlRight");
					//
					// uiBuilder.runFuntion("this", "findControl", new Object [] {propertyValue},
					// new Class [] {ReturnMethod.class },controlRight);
					//
					//
					// int WRAP_CONTENT = -2;
					// int RIGHT_OF = 1;
					//
					//
					//
					// Object[] paramValue = new Object[] {WRAP_CONTENT,WRAP_CONTENT} ;
					//
					// Class[] paramType=new Class[] {int.class,int.class};
					//
					// ReturnMethod idControlRight = new ReturnMethod("idControlRight");
					// uiBuilder.runFuntion("controlRight", "getId", null,null,idControlRight);
					//
					//
					// uiBuilder.runFuntion("relativeLayoutLayoutParams", "addRule", new Object []
					// {RIGHT_OF,idControlRight }, new Class [] {int.class
					// ,int.class},relativeLayoutLayoutParams);
					//
					// mapReturn.put("data", uiBuilder.getScript());
					//
					//
					// ProxyDemo<IResponse> pr = new ProxyDemo<IResponse>();
					// IResponse iResponse = pr.create(IResponse.class);
					// iResponse.viewOject(mapReturn);

					Map mapReturn = DataUtil.ConvertDataSnapshotToMap(snapshot1);

					Map mapReturnData = DataUtil.ConvertDataSnapshotToMap(snapshot1.child("data"));
					if (mapReturnData == null)
						mapReturnData = new HashMap<>();

					mapReturnData.put("script", "com.deflh.GetLayoutMethodScriptLayoutToRightOfUI");

					mapReturnData.put("application_script", "resshare_core");
					mapReturn.put("script_type", "script_type_form");
					mapReturn.put("data", mapReturnData);

					// RequestClient.sendRequest("resshare", "key1",
					// FireBaseReference.draft_get_resshare_user_id, mapReturn);

					// Gson gson = new GsonBuilder().create();
					//
					// ProxyDemo<IRequest> pr = new ProxyDemo<IRequest>();
					// IRequest iRequest = pr.create(IRequest.class);
					//
					// Input input = new Input(RefFireBase.APPLICATION_resshare_ui_engine, "key1",
					// mapReturn);
					//
					// input.setDataCollection(FireBaseReference.draft_ui_engine_get_script_ui);
					//
					// input.setModule("core");
					// iRequest.input(input);
					
					
					RequestClient.sendRequest(RefFireBase.APPLICATION_resshare_ui_engine, "key1",
							FireBaseReference.draft_ui_engine_get_script_ui, mapReturn);

				} catch (Exception e) {
					e.printStackTrace();
				}

				FirebaseDatabase.getInstance().getReference(getReferenceName()).child(snapshot1.getKey())
						.child("processing").setValue("done");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onChildRemoved(DataSnapshot snapshot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCancelled(DatabaseError error) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getReferenceName() {
		// TODO Auto-generated method stub
		return ResFirebaseReference.getInputPathReference(FireBaseReference.get_layout_script_layout_toRightOf);
	}
}
