package com.resshare.framework.core.service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public abstract class ValueEventListenerBase implements ValueEventListener {

	protected FirebaseDatabase firebaseDb;

	public void onStart() {
		firebaseDb = FirebaseDatabase.getInstance();
		firebaseDb.getReference(getReferenceName()).addValueEventListener(this);

	}

	public void onStop() {
		firebaseDb.getReference(getReferenceName()).removeEventListener(this);
	}

	public abstract String getReferenceName();

	@Override
	public  abstract void onCancelled(DatabaseError arg0) ;

	@Override
	public abstract void onDataChange(DataSnapshot arg0) ;

}
