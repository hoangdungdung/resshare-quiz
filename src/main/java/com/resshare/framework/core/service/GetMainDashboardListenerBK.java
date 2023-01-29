package com.resshare.framework.core.service;

import java.util.HashMap;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.resshare.core.screen.DynamicFragment;
import com.resshare.framework.core.reflectproxy.ProxyDemo;
import com.resshare.framework.model.Input;
import com.resshare.framework.model.Script;
import com.resshare.widget.GridViewAdapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GetMainDashboardListenerBK extends ListenerBase {

	@Override
	public void onChildAdded(DataSnapshot snapshot1, String previousChildName) {
		try {
			if (snapshot1.child("processing").getValue() == null) {
				String application = snapshot1.child("application").getValue(String.class);
				String user_id = snapshot1.child("user_id").getValue(String.class);
				String event = snapshot1.child("event").getValue(String.class);

				String reference = "configuration/" + application + "/system_setting/layout/android/main_dashboard";

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

										mapReturnData.put("layout", snapshot.child("layout").getValue());
										Object grid_view_layout_item = snapshot.child("grid_view_layout_item")
												.getValue();
										Object grid_view_data = snapshot.child("grid_view_data").child("list_item")
												.getValue();

										mapReturn.put("data", mapReturnData);
										mapReturn.put("view_type", 1);

										UIBuilder uIBuilder = new UIBuilder();

										// GridView simpleGridView = uIBuilder.<GridView>createShadow(GridView.class,
										// "simpleGridView");
										GridViewAdapter gridViewAdapter = uIBuilder.<GridViewAdapter>createShadow(
												GridViewAdapter.class, "dashboardGridView.Adapter");

										gridViewAdapter.setLayout(grid_view_layout_item);

										UIBuilder uIBuilderItem = new UIBuilder();
										TextView txtDescriptionItem = uIBuilderItem
												.<TextView>createShadow(TextView.class, "txtDescriptionItem");

										GridViewAdapter gridViewAdapterScript = uIBuilderItem
												.<GridViewAdapter>createShadow(GridViewAdapter.class, "this");
										Object descriptionValue1 = gridViewAdapterScript.getSelectField("description");
										Object icon = gridViewAdapterScript.getSelectField("icon");

										String descriptionValue = uIBuilderItem.convert(String.class,
												descriptionValue1);
										txtDescriptionItem.setText(descriptionValue);
										String stringUrl = uIBuilderItem.convert(String.class, icon);
										uIBuilderItem.showImageView("iconItem", stringUrl);

										gridViewAdapter.setScript(uIBuilderItem.getScript());

										UIBuilder uIBuilderItemClick = new UIBuilder();
										GridViewAdapter gridViewAdapterScriptItemClick = uIBuilderItemClick
												.<GridViewAdapter>createShadow(GridViewAdapter.class,
														"dashboardGridView.Adapter");
										Object jsonPathFormObj = gridViewAdapterScriptItemClick
												.getSelectField("layout_form");
										String jsonPathForm = uIBuilderItemClick.convert(String.class, jsonPathFormObj);

										Object jsonPathFlowChart = gridViewAdapterScriptItemClick
												.getSelectField("flow_chart");
										String jsonPathFormflow_chart = uIBuilderItemClick.convert(String.class,
												jsonPathFlowChart);

										uIBuilderItemClick.openFormFlowchart(jsonPathForm, jsonPathFormflow_chart);

										// openFormFlowchart

										Script script = uIBuilderItemClick.getScript();
										System.out.println(script.getList_command());

										gridViewAdapter.setScriptItemClick(script);

										gridViewAdapter.setData(grid_view_data);

										mapReturnData.put("script", uIBuilder.getScript());

										//
										// ProxyDemo<IResponse> pr = new ProxyDemo<IResponse>();
										// IResponse iResponse = pr.create(IResponse.class);
										//
										// iResponse.viewOject(mapReturn);

										RequestClient.sendRequestResshareUserId(mapReturn);

										// uupdate user_app_recently
										ProxyDemo<IRequest> prIRequest = new ProxyDemo<IRequest>();
										IRequest iRequest = prIRequest.create(IRequest.class);
										Gson gson = new GsonBuilder().create();
										HashMap<String, Object> hm = new HashMap<>();
										hm.put("application", application);
										hm.put("user_id", user_id);
										gson = new GsonBuilder().create();
										String jsonString = gson.toJson(hm);
										Input input = new Input("resshare", "key1", jsonString);

										input.setDataCollection(FireBaseReference.draft_user_app_recently);
										input.setModule("core");
										iRequest.input(input);

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

										//
										//
										// ProxyDemo<IResponse> prrt = new ProxyDemo<IResponse>();
										// IResponse iResponse1 = prrt.create(IResponse.class);
										//
										// iResponse1.viewOject(mapReturn);

										RequestClient.sendRequestResshareUserId(mapReturn);

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
		return FireBaseReference.draft_core_get_main_dashboard_app;
	}
}
