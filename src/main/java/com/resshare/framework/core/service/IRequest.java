package com.resshare.framework.core.service;

import com.resshare.framework.core.reflectproxy.AnoMethod;
import com.resshare.framework.core.reflectproxy.AnoModule;
import com.resshare.framework.model.Input;

@AnoModule("request")
public interface IRequest {
	// RoutingLocation routingLocation
	@AnoMethod("requestdatacollection")
	String requestdatacollection(Input input);

	@AnoMethod("input")
	String input(Input input);
}
