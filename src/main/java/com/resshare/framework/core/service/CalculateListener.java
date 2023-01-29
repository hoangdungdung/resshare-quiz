package com.resshare.framework.core.service;

import java.util.HashMap;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import android.widget.TextView;

public class CalculateListener extends ListenerBase {

	@Override
	public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
		try {
			if (snapshot.child("processing").getValue() == null) {

				String user_id = snapshot.child("user_id").getValue(String.class);
				String event = snapshot.child("event").getValue(String.class);

				Double term1_value = snapshot.child("term1_value").getValue(Double.class);
				Double term2_value = snapshot.child("term2_value").getValue(Double.class);

				Double db_total = term1_value + term2_value;

				UIBuilder uIBuilder = new UIBuilder();

				TextView txtTotal = uIBuilder.<TextView>createShadow(TextView.class, "txtTotal");
				txtTotal.setText(String.valueOf(db_total));

				// txtTerm1 txtTerm2 txtTotal

				// System.out.print(uIBuilder.getScript().toString());

				try {

					HashMap<String, Object> mapReturn = new HashMap<>();
					mapReturn.put("user_id_destination", user_id);
					mapReturn.put("event", event);
					mapReturn.put("script", uIBuilder.getScript());

					// ProxyDemo<IResponse> pr = new ProxyDemo<IResponse>();
					// IResponse iResponse = pr.create(IResponse.class);
					//
					// iResponse.viewOject(mapReturn);
					//

					RequestClient.sendRequestResshareUserId(mapReturn);

				} catch (Exception e) {
					e.printStackTrace();
				}

				FirebaseDatabase.getInstance().getReference(getReferenceName()).child(snapshot.getKey())
						.child("processing").setValue("done");
			}
		} catch (Exception e) {
			FirebaseDatabase.getInstance().getReference(getReferenceName()).child(snapshot.getKey()).child("processing")
					.setValue("error");
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
		return "test_core_insert";
	}
}
