package com.resshare.framework.core.service;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.FirebaseDatabase;

public abstract class ServiceBaseChildEventListener  extends ServiceBase implements ChildEventListener {
 static  protected	FirebaseDatabase database ;
	public void onStart() {
		  database = FirebaseDatabase.getInstance();
		FirebaseDatabase.getInstance().getReference(getReferenceName()).addChildEventListener(this);

	}

	public void onStop() {
		 FirebaseDatabase.getInstance().getReference(getReferenceName()).removeEventListener(this);
	}

	public abstract String getReferenceName();

}
