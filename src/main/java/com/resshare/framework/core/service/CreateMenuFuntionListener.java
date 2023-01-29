package com.resshare.framework.core.service;

import java.util.HashMap;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateMenuFuntionListener extends ListenerBase {

	@Override
	public void onChildAdded(DataSnapshot snapshot1, String previousChildName) {
		try {
			if (snapshot1.child("processing").getValue() == null) {
				HashMap<String, Object> mapReturn = new HashMap<>();
				String app_name = snapshot1.child("application").getValue(String.class);
				String event = snapshot1.child("event").getValue(String.class);

				String user_id = snapshot1.child("user_id").getValue(String.class);
				mapReturn.put("user_id_destination", user_id);
				mapReturn.put("event", event);

				mapReturn.put("application", app_name);
				// mapReturn.put("session", snapshot1.child("session").getValue());
				String type = snapshot1.child("type").getValue(String.class);
				String ref = snapshot1.child("ref").getValue(String.class);
				if ("application".equals(type)) {

					String text = snapshot1.child("text").getValue(String.class);
					String logo = snapshot1.child("logo").getValue(String.class);

					HashMap<String, Object> hminputFuntion = new HashMap<>();
					hminputFuntion.put("text", text);
					hminputFuntion.put("type", "application");
					hminputFuntion.put("logo", logo);
					hminputFuntion.put("user_id", user_id);
					FirebaseDatabase.getInstance().getReference(ref + "/0").setValue(hminputFuntion);

				} else {
					if ("form".equals(type)) {
						String funtion_name = snapshot1.child("funtion_name").getValue(String.class);
						FirebaseDatabase.getInstance().getReference(ref)
								.addListenerForSingleValueEvent(new ValueEventListener() {

									@Override
									public void onDataChange(DataSnapshot snapshot) {

										if (snapshot.exists()) {
											long iCount = snapshot.getChildrenCount();
											if (iCount > 0) {
												int k = 0;
												Iterable<DataSnapshot> child = snapshot.getChildren();

												for (DataSnapshot dataSnapshot : child) {

													if (dataSnapshot.hasChild("funtion_name")) {
														String funtion_name_old = dataSnapshot.child("funtion_name")
																.getValue(String.class);
														if (funtion_name.equals(funtion_name_old)) {
															break;

														}
													}
													k++;
												}

												insertfuntion(k);
												return;

											}
										}
										insertApp();
										insertfuntion(1);

									}

									private void insertApp() {
										HashMap<String, Object> hminputFuntion = new HashMap<>();
										hminputFuntion.put("text", app_name);
										hminputFuntion.put("type", "application");
										hminputFuntion.put("user_id", user_id);
										FirebaseDatabase.getInstance().getReference(ref + "/0")
												.setValue(hminputFuntion);

									}

									private void insertfuntion(long i) {

										FirebaseDatabase.getInstance().getReference(ref + "/" + String.valueOf(i))
												.setValue(snapshot1.getValue());

									}

									@Override
									public void onCancelled(DatabaseError error) {
										// TODO Auto-generated method stub

									}
								});

					} else {

					}

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
		return FireBaseReference.draft_core_menu_funtion;
	}
}
