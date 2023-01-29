package com.resshare.framework.core.service;

import java.util.HashMap;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

public class CreateApptListener extends ListenerBase {

	@Override
	public void onChildAdded(DataSnapshot snapshot1, String previousChildName) {
		try {
			if (snapshot1.child("processing").getValue() == null) {

				//
				// hminputLayoutApplication.put("default_layout_value", json_app_layout);
				// hminputLayoutApplication.put("default_layout_ref", "configuration/"+app_name
				// );
				//
				// hminputLayoutApplication.put("default_info_app_ref","configuration/"+app_name
				// +"/system_setting/layout/android/home/menu/data/0");
				// hminputLayoutApplication.put("default_info_app_value",hminputApplication);
				//

				HashMap<String, Object> mapReturn = new HashMap<>();
				String default_layout_ref = snapshot1.child("default_layout_ref").getValue(String.class);
				Object default_layout_value = snapshot1.child("default_layout_value").getValue();
				String default_info_app_ref = snapshot1.child("default_info_app_ref").getValue(String.class);
				Object default_info_app_value = snapshot1.child("default_info_app_value").getValue();

				FirebaseDatabase.getInstance().getReference(default_layout_ref).setValue(default_layout_value);
				FirebaseDatabase.getInstance().getReference(default_info_app_ref).setValue(default_info_app_value);

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
		return ResFirebaseReference.getInputPathReference(FireBaseReference.draft_core_creat_app_layout_temple);
	}
}
