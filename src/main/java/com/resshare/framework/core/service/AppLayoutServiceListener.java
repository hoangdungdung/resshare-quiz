package com.resshare.framework.core.service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AppLayoutServiceListener extends ServiceBase implements ValueEventListener {

	private FirebaseDatabase database;

	@Override
	public void onDataChange(DataSnapshot snapshot) {

		try {

			Object layout = snapshot.getValue();

			database.getReference(FireBaseReference.dashboard_inform_layout)
					.addValueEventListener(new ValueEventListener() {

						@Override
						public void onDataChange(DataSnapshot snapshot1) {
							// TODO Auto-generated method stub
							Cache.dashboard_inform_layout = snapshot1.getValue();
						}

						@Override
						public void onCancelled(DatabaseError error) {
							// TODO Auto-generated method stub

						}
					});

			Cache.dashboard_app_layout = layout;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onCancelled(DatabaseError error) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart() {
		database = FirebaseDatabase.getInstance();
		database.getReference(getReferenceName()).addValueEventListener(this);

	}

	@Override
	public void onStop() {
		database.getReference(getReferenceName()).removeEventListener(this);

	}

	@Override
	public String getReferenceName() {

		return ResFirebaseReference.getConfigurationPath( FireBaseReference.cfg_dashboard_app_layout);
	}

}
