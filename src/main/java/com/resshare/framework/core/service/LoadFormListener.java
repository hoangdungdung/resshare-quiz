package com.resshare.framework.core.service;

import java.util.HashMap;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.resshare.framework.model.MapObject;

import android.view.View;
import android.widget.TextView;

public class LoadFormListener extends ListenerBase {

	@Override
	public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
		try {
			if (snapshot.child("processing").getValue() == null) {

				UIBuilder uIBuilder = new UIBuilder();

				TextView txtTotal = uIBuilder.<TextView>createShadow(TextView.class, "txtTotal");

				// txtTerm1 txtTerm2 txtTotal

				ViewOnClickListener boiling_point_klis = new ViewOnClickListener() {
					@Override
					public void onClick(View v) {
						TextView txtTerm1 = uIBuilder.<TextView>createShadow(TextView.class, "txtTerm1");

						TextView txtTerm2 = uIBuilder.<TextView>createShadow(TextView.class, "txtTerm2");
						MapObject objMap = uIBuilder.createMapObjectShadow(MapObject.class, "mapObject");

						Object o = txtTerm1.getText();
						objMap.setFieldValue("term1_value", Double.class, o);

						Object a = txtTerm2.getText();
						objMap.setFieldValue("term2_value", Double.class, a);

						uIBuilder.post(objMap, "test_core_insert");

					}
				};

				uIBuilder.<ViewOnClickListener>createShadowOnClickListener(boiling_point_klis, "OnClickListener1");

				txtTotal.setOnClickListener(boiling_point_klis);

				// System.out.print(uIBuilder.getScript().toString());

				try {

					String user_id = snapshot.child("user_id").getValue(String.class);
					String event = snapshot.child("event").getValue(String.class);
					HashMap<String, Object> mapReturn = new HashMap<>();
					mapReturn.put("user_id_destination", user_id);
					mapReturn.put("event", event);
					mapReturn.put("script", uIBuilder.getScript());
					// hm.put("vehicle",vehicle_drive);
					// if (map.containsKey("user_id_destination") && map.containsKey("event")) {

					// ProxyDemo<IResponse> pr = new ProxyDemo<IResponse>();
					// IResponse iResponse = pr.create(IResponse.class);
					//
					// iResponse.viewOject(mapReturn);

					RequestClient.sendRequestResshareUserId(mapReturn);

				} catch (Exception e) {
					e.printStackTrace();
				}

				FirebaseDatabase.getInstance().getReference(getReferenceName()).child(snapshot.getKey())
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
		return "core/test";
	}
}
