package com.resshare.framework.core.service;

import java.util.HashMap;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class FlowchartDemo extends ValueEventListenerBase {

	@Override
	public String getReferenceName() {
		// TODO Auto-generated method stub
		//return "configuration/resshare_configuration/flowchart/demo/diagram/mxGraphModel/root";
		return "configuration/resshare_configuration/flowchart/demo/diagram/mxGraphModel/root/diagram/mxGraphModel/root";
	}

	@Override
	public void onCancelled(DatabaseError arg0) {
		// TODO Auto-generated method stub

	}

	static DataSnapshot getOrthogonalEdgeStyle(Iterable<DataSnapshot> iterableDataSnapshot) {
		return null;

	}

	@Override
	public void onDataChange(DataSnapshot arg0) {
//		if (arg0.exists()) {
//			Iterable<DataSnapshot> data = arg0.getChildren();
//
//			FlowchartInstance flowchartInstance = new FlowchartInstance();
//			flowchartInstance.setData(data);
//			HashMap hm=new HashMap<>();
//			hm.put("a", 11);
//			hm.put("b", 10);
//			
//			//flowchartInstance.setInput(hm);
//			//flowchartInstance.executeMain();
//			
//
//		}
	}

}
