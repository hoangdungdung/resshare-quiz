package com.resshare.framework.core.service;

import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class SubAppService extends ListenerBase {
	// public static String DATABASE_URL = "https://quattet-11188.firebaseio.com/";
	public static final Logger log = LoggerFactory.getLogger(SubAppService.class);
	public static Hashtable<String, String> subAppRest = new Hashtable<>();

	public SubAppService() {

	}

	@Override
	public void onChildAdded(DataSnapshot snapshot, String previousChildName) {

		try {
			subAppRest.put(snapshot.getKey(), snapshot.child("rest_service_uri").getValue(String.class));

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
		return "system_settings/application";
	}

}
