package com.resshare.framework.core.service;

import java.util.HashMap;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.resshare.framework.core.service.Cache;
import com.resshare.framework.core.service.FireBaseReference;
import com.resshare.framework.core.service.ServiceBase;

public class CacheConfigurationListener extends ServiceBase implements ValueEventListener {

	private FirebaseDatabase database;

	@Override
	public void onDataChange(DataSnapshot snapshot) {

		try {

			Cache.configuration = snapshot;
		 

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

		return  ResFirebaseReference.getConfigurationPath("../");
	}

}
