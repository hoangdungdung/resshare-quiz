package com.resshare.framework.core.service;

import java.util.HashMap;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.resshare.framework.model.ReturnMethod;

public class GetLayoutMethodScriptContentInsetLeftListener extends ListenerBase {

	@Override
	public void onChildAdded(DataSnapshot snapshot1, String previousChildName) {
		try {
			if (snapshot1.child("processing").getValue() == null) {

				try {

					HashMap<String, Object> mapReturn = new HashMap<>();
					mapReturn.put("user_id_destination", snapshot1.child("user_id_destination").getValue());
					mapReturn.put("event", snapshot1.child("event").getValue());
					mapReturn.put("parameter", snapshot1.child("parameter").getValue());
					// mapReturn.put("data", snapshot.getValue());
					mapReturn.put("application", snapshot1.child("application").getValue());
					mapReturn.put("session", snapshot1.child("session").getValue());

					mapReturn.put("type", snapshot1.child("type").getValue());
					mapReturn.put("key_data", snapshot1.child("key_data").getValue());

					mapReturn.put("count_message", snapshot1.child("count_message").getValue());

					UIBuilder uiBuilder = new UIBuilder();
					// Toolbar toolbar=
					// uiBuilder.createShadowParam(android.support.v7.widget.Toolbar.class,"toobar");
					// Object objLeft = uiBuilder.createShadowParam("contentInsetLeft");

					ReturnMethod returnMethodControl = new ReturnMethod();
					returnMethodControl.setVarianName("toolbar");
					uiBuilder.runFuntion("this", "findControl", new String[] { "@+id/toolbar" },
							new Class[] { String.class }, returnMethodControl);
					//
					ReturnMethod returnMethodgetContentInsetLeft = new ReturnMethod();
					returnMethodgetContentInsetLeft.setVarianName("getContentInsetLeft");
					uiBuilder.runFuntion("this", "findValuelParam", null, null, returnMethodgetContentInsetLeft);

					ReturnMethod returnMethodgetContentInsetRight = new ReturnMethod();
					returnMethodgetContentInsetRight.setVarianName("getContentInsetRight");

					uiBuilder.runFuntion("toolbar", "getContentInsetRight", null, null,
							returnMethodgetContentInsetRight);

					uiBuilder.runFuntion("toolbar", "setContentInsetsAbsolute",
							new Object[] { returnMethodgetContentInsetLeft, returnMethodgetContentInsetRight },
							new Class[] { int.class, int.class }, null);

					// toolbar.setContentInsetsAbsolute(objLeft,toolbar.getContentInsetRight());
					//
					// ;
					mapReturn.put("data", uiBuilder.getScript());

					RequestClient.sendRequest("resshare", "key1", FireBaseReference.draft_get_resshare_user_id,
							mapReturn);

					// ProxyDemo<IResponse> pr = new ProxyDemo<IResponse>();
					// IResponse iResponse = pr.create(IResponse.class);
					// iResponse.viewOject(mapReturn);

				} catch (Exception e) {
					e.printStackTrace();
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
		return ResFirebaseReference.getInputPathReference(FireBaseReference.get_layout_script_contentInsetLeft);
	}
}
