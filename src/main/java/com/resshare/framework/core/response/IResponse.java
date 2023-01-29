package com.resshare.framework.core.response;

import java.util.HashMap;
import java.util.Map;

import com.google.protobuf.ByteString.Output;
import com.resshare.framework.core.reflectproxy.AnoMethod;
import com.resshare.framework.core.reflectproxy.AnoModule;

@AnoModule("response")
public interface IResponse {
	// RoutingLocation routingLocation
	@AnoMethod("show")
	String show(Output json);

	@AnoMethod("viewUI")
	String viewUI(HashMap<String, Object> map);

	@AnoMethod("viewOject")
	String viewOject(Map map);
	
	@AnoMethod("removeResponse")
	void removeResponse(String MapMessageKey);

}
