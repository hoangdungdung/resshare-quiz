package com.resshare.framework.core.service;

import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.resshare.framework.core.DataUtil;
import com.resshare.framework.core.reflectproxy.ProxyDemo;
import com.resshare.framework.model.Input;

public class LoadFormRunFlowchartListener2 extends ListenerBase {

	@Override
	public void onChildAdded(DataSnapshot snapshot1, String previousChildName) {
		try {
			if (snapshot1.child("processing").getValue() == null) {
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

				Map mapReturn = DataUtil.ConvertDataSnapshotToMap(snapshot1);
				mapReturn.put("type", "load_form_script");
				mapReturn.put("key_data", "load_form_script");

				Map mapReturnData = DataUtil.ConvertDataSnapshotToMap(snapshot1.child("data"));
				if (mapReturnData == null)
					mapReturnData = new HashMap<>();

				mapReturnData.put("script", "com.deflh.GetFlowchartUI");

				mapReturnData.put("application_script", "resshare_core");
				mapReturn.put(" script_type", "script_type_form");
				mapReturn.put("data", mapReturnData);

				Gson gson = new GsonBuilder().create();

				ProxyDemo<IRequest> pr = new ProxyDemo<IRequest>();
				IRequest iRequest = pr.create(IRequest.class);
				// gson = new GsonBuilder().create();
				// String jsonString = gson.toJson(mapReturn);

				Input input = new Input(RefFireBase.APPLICATION_resshare_ui_engine, "key1", mapReturn);

				input.setDataCollection(FireBaseReference.draft_ui_engine_get_script_ui);

				input.setModule("core");
				iRequest.input(input);

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
		return ResFirebaseReference.getInputPathReference(FireBaseReference.draft_core_run_flowchart_load_form_script1);
	}
}
