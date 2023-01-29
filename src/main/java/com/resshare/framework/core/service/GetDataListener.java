package com.resshare.framework.core.service;

import java.util.HashMap;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GetDataListener extends ListenerBase {

	@Override
	public void onChildAdded(DataSnapshot snapshot1, String previousChildName) {
		try {
			if (snapshot1.child("processing").getValue() == null) {

				try {

					String user_id = snapshot1.child("user_id").getValue(String.class);
					String event = snapshot1.child("event").getValue(String.class);
					String reference = snapshot1.child("reference").getValue(String.class);
					String parameter = snapshot1.child("parameter").getValue(String.class);
					String application = snapshot1.child("application").getValue(String.class);
					FirebaseDatabase.getInstance().getReference(reference)
							.addListenerForSingleValueEvent(new ValueEventListener() {

								@Override
								public void onDataChange(DataSnapshot snapshot) {
									if (snapshot.exists())
										try {

											HashMap<String, Object> mapReturn = new HashMap<>();
											mapReturn.put("user_id_destination", user_id);
											mapReturn.put("event", event);
											mapReturn.put("parameter", parameter);
											mapReturn.put("data", snapshot.getValue());
											mapReturn.put("application", application);

											RequestClient.sendRequest("resshare", "key1",
													FireBaseReference.draft_get_resshare_user_id, mapReturn);

											// hm.put("vehicle",vehicle_drive);
											// if (map.containsKey("user_id_destination") && map.containsKey("event")) {

											// ProxyDemo<IResponse> pr = new ProxyDemo<IResponse>();
											// IResponse iResponse = pr.create(IResponse.class);
											//
											// iResponse.viewOject(mapReturn);

										} catch (Exception e) {
											e.printStackTrace();
										}
								}

								@Override
								public void onCancelled(DatabaseError error) {
									// TODO Auto-generated method stub

								}
							});

				} catch (Exception e) {
					e.printStackTrace();
				}
				cleanInput(snapshot1);
				//
				// FirebaseDatabase.getInstance().getReference(getReferenceName()).child(snapshot1.getKey())
				// .child("processing").setValue("done");
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
		return ResFirebaseReference.getInputPathReference(FireBaseReference.get_data);
	}
}
