package com.resshare.framework.core.service;

import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.resshare.framework.core.DataUtil;

public class FlowchartListenerExecute extends ListenerBase {

	@Override
	public void onChildAdded(DataSnapshot snapshot1, String previousChildName) {
		try {
			if (snapshot1.child("processing").getValue() == null) {
				HashMap<String, Object> mapReturn = new HashMap<>();
				String event = snapshot1.child("event").getValue(String.class);
				String user_id = snapshot1.child("user_id").getValue(String.class);
				String application = snapshot1.child("application").getValue(String.class);
				String flowchart_name = snapshot1.child("flowchart_name").getValue(String.class);
				mapReturn.put("user_id", user_id);
				mapReturn.put("user_id_destination", user_id);
				mapReturn.put("event", event);
				mapReturn.put("application", application);
				mapReturn.put("flowchart_name", flowchart_name);
				if (flowchart_name != null) {
					Iterable<DataSnapshot> data = snapshot1.child("data").getChildren();
					HashMap<String, Object> hm = new HashMap<String, Object>();
					for (DataSnapshot dataSnapshot : data) {
						hm.put(dataSnapshot.getKey(), dataSnapshot.getValue());
					}
					mapReturn.put("input", hm);
					/// configuration/qaz/system_setting/layout/android/flowchart/a1/diagram/mxGraphModel/root/diagram/mxGraphModel/root
					String flowchart_path = "";
					if (!flowchart_name.contains("configuration/")) {
						flowchart_path = "configuration/" + application + "/system_setting/layout/android/flowchart/"
								+ flowchart_name + "/diagram/mxGraphModel/root/diagram/mxGraphModel/root";
					} else {
						flowchart_path = flowchart_name + "/diagram/mxGraphModel/root/diagram/mxGraphModel/root";
					}

					
				
				
					
					
					
					
					FirebaseDatabase.getInstance().getReference(flowchart_path)
							.addListenerForSingleValueEvent(new ValueEventListener() {

								@Override
								public void onDataChange(DataSnapshot arg0) {

									if (arg0.exists()) {
										
										Map data1 = DataUtil.ConvertDataSnapshotToMap(arg0);
									 
										mapReturn.put("data", data1);
										
										RequestClient.sendRequest("flowchart_engine", "secretKey", FireBaseReference.draft_flowchart_engine_execute, mapReturn);
										

//										FlowchartInstance flowchartInstance = new FlowchartInstance();
//										flowchartInstance.setData(data);
//
//										flowchartInstance.setContext(mapReturn);
//										flowchartInstance.setInput(hm);
//										flowchartInstance.executeMain();

									}

								}

								@Override
								public void onCancelled(DatabaseError error) {
									// TODO Auto-generated method stub

								}
							});
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
		/// draft/resshare_configuration/create_funtion_temple
		return  ResFirebaseReference.getInputPathReference( FireBaseReference.draft_core_flowchart_execute1);
	}
}
