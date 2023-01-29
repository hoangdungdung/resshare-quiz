package com.resshare.framework.core.service;

import java.util.HashMap;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

public class CreateFlowchartListener extends ListenerBase {

	@Override
	public void onChildAdded(DataSnapshot snapshot1, String previousChildName) {
		try {
			if (snapshot1.child("processing").getValue() == null) {
				HashMap<String, Object> mapReturn = new HashMap<>();
				String event = snapshot1.child("event").getValue(String.class);
				String user_id = snapshot1.child("user_id").getValue(String.class);
				mapReturn.put("user_id_destination", user_id);
				mapReturn.put("event", event);
				String ref = snapshot1.child("ref").getValue(String.class);
				String file_json = snapshot1.child("file_json").getValue(String.class);
				Gson gs = new Gson();

				HashMap map = gs.fromJson(file_json, HashMap.class);
				// JSONObject json = new JSONObject(file_json);

				FirebaseDatabase.getInstance().getReference(ref).setValue(map);

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
		/// draft/resshare_configuration/create_funtion_temple
		return FireBaseReference.draft_core_flowchart;
	}
}
