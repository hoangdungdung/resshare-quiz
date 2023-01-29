package com.resshare.framework.core.service;

import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.resshare.core.screen.DynamicFragment;
import com.resshare.framework.core.DataUtil;

import android.view.View;
import android.widget.ImageView;

public class GetMainDashboardListenerBK20211127 extends ListenerBase {

	@Override
	public void onChildAdded(DataSnapshot snapshot1, String previousChildName) {
		try {
			if (snapshot1.child("processing").getValue() == null) {
				String application = snapshot1.child("application").getValue(String.class);
				String user_id = snapshot1.child("user_id").getValue(String.class);
				String event = snapshot1.child("event").getValue(String.class);

				String reference = application + "/configuration" + "/system_setting/layout/android/main_dashboard";

				// String application = snapshot1.child("application").getValue(String.class);
				FirebaseDatabase.getInstance().getReference(reference)
						.addListenerForSingleValueEvent(new ValueEventListener() {

							@Override
							public void onDataChange(DataSnapshot snapshot) {
								HashMap<String, Object> mapReturnData = new HashMap<>();
								HashMap<String, Object> mapReturn = new HashMap<>();
								mapReturn.put("user_id_destination", user_id);
								mapReturn.put("event", event);

								mapReturn.put("application", application);

								if (snapshot.exists()) {
									try {

										// https://abhiandroid.com/ui/gridview

										// simpleGrid = (GridView) findViewById(R.id.simpleGridView); // init GridView
										// // Create an object of CustomAdapter and set Adapter to GirdView
										// CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),
										// logos);

										// simpleGrid.setAdapter(customAdapter);
										// // implement setOnItemClickListener event on GridView
										// simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
										// @Override
										// public void onItemClick(AdapterView<?> parent, View view, int position, long
										// id) {
										// // set an Intent to Another Activity
										// Intent intent = new Intent(MainActivity.this, SecondActivity.class);
										// intent.putExtra("image", logos[position]); // put image data in Intent
										// startActivity(intent); // start Intent
										// }
										// });
										// mapReturnData.put("script_param", script_param);
										// mapReturnData.put("main_dashboard_app", true);

										// mapReturnData.put("layout", snapshot.child("layout").getValue());

										DataSnapshot layout = snapshot.child("layout");

										if (layout.hasChild("views/0/properties/5/text")) {
											try {
												Map slayout = DataUtil.ConvertDataSnapshotToMapAll(layout);
												String sslayout = ((Map) ((Map) ((Map) ((Map) slayout.get("views"))
														.get("0")).get("properties")).get("5")).get("text").toString();
												String slayoutR = sslayout.replaceFirst("@app_name", application);
												((Map) ((Map) ((Map) ((Map) slayout.get("views")).get("0"))
														.get("properties")).get("5")).put("text", slayoutR);
												mapReturnData.put("layout", slayout);
												
											} catch (Exception e) {
												mapReturnData.put("layout", snapshot.child("layout").getValue());
											} 

											
										} else
											mapReturnData.put("layout", snapshot.child("layout").getValue());

										mapReturn.put("view_type", 1);
										mapReturn.put("main_dashboard_app", true);

										mapReturn.put("script_type", "script_type_grid_dashboard");

										Object grid_view_layout_item = snapshot.child("grid_view_layout_item")
												.getValue();
										Object grid_view_data = snapshot.child("grid_view_data").child("list_item")
												.getValue();

										// GetMainDashboardUI getMainDashboardUI = new GetMainDashboardUI();
										//
										// UIBuilder uIBuilder = getMainDashboardUI.getUIBuilder();

										// UIBuilder uIBuilder = new UIBuilder();
										HashMap script_param = new HashMap<>();
										script_param.put("grid_view_layout_item", grid_view_layout_item);
										script_param.put("grid_view_data", grid_view_data);

										mapReturnData.put("script_param", script_param);
										mapReturnData.put("script", "com.deflh.GetMainDashboardUI");

										mapReturnData.put("application_script", "resshare_core");
										mapReturn.put("data", mapReturnData);
										// Gson gson = new GsonBuilder().create();

										// ProxyDemo<IRequest> pr = new ProxyDemo<IRequest>();
										// IRequest iRequest = pr.create(IRequest.class);
										// gson = new GsonBuilder().create();
										// String jsonString = gson.toJson(mapReturn);

										// Input input = new Input("resshare_ui_engine", "key1", mapReturn);
										//
										// input.setDataCollection(FireBaseReference.draft_ui_engine_get_script_ui);
										//
										// input.setModule("core");
										// iRequest.input(input);

										RequestClient.sendRequest("resshare_ui_engine", "key1",
												FireBaseReference.draft_ui_engine_get_script_ui, mapReturn);

										// uupdate user_app_recently
										// ProxyDemo<IRequest> prIRequest = new ProxyDemo<IRequest>();
										// iRequest = prIRequest.create(IRequest.class);
										// gson = new GsonBuilder().create();
										HashMap<String, Object> hm = new HashMap<>();
										hm.put("application", application);
										hm.put("user_id", user_id);
										// gson = new GsonBuilder().create();
										// String jsonString = gson.toJson(hm);
										// input = new Input("resshare", "key1", jsonString);
										//
										// input.setDataCollection(FireBaseReference.draft_user_app_recently);
										// input.setModule("core");
										// iRequest.input(input);

										RequestClient.sendRequest("resshare", "key1",
												FireBaseReference.draft_user_app_recently, hm);

									} catch (Exception e) {
										e.printStackTrace();
									}
								} else {

									UIBuilder uIBuilder111 = new UIBuilder();
									DynamicFragment screen = uIBuilder111
											.<DynamicFragment>createShadow(DynamicFragment.class, "screen");
									screen.showAlertDialog("Ung dung dang xay dung chua trien khai");

									try {

										//
										mapReturn.put("data", uIBuilder111.getScript());

										// RequestClient.sendRequestResshareUserId(mapReturn);

										// ProxyDemo<IResponse> prrt = new ProxyDemo<IResponse>();
										// IResponse iResponse1 = prrt.create(IResponse.class);
										//
										// iResponse1.viewOject(mapReturn);

									} catch (Exception e) {
										e.printStackTrace();
									}

								}

							}

							private void showMsg(UIBuilder uIBuilder, String sNameIcon) {
								ImageView icon0 = uIBuilder.<ImageView>createShadow(ImageView.class, sNameIcon);

								ViewOnClickListener boiling_point_klis0 = new ViewOnClickListener() {

									@Override
									public void onClick(View v) {

										DynamicFragment screen = uIBuilder
												.<DynamicFragment>createShadow(DynamicFragment.class, "screen");
										screen.showAlertDialog("Chuc nang: " + sNameIcon);

									}
								};

								uIBuilder.<ViewOnClickListener>createShadowOnClickListener(boiling_point_klis0,
										"OnClickListener" + sNameIcon);

								icon0.setOnClickListener(boiling_point_klis0);
							}

							@Override
							public void onCancelled(DatabaseError error) {
								// TODO Auto-generated method stub

							}
						});
				cleanInput(snapshot1);

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
		return ResFirebaseReference.getInputPathReference(FireBaseReference.draft_core_get_main_dashboard_app);
	}
}
