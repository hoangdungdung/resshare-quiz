package com.resshare.framework.core.service;

import com.resshare.framework.core.reflectproxy.AnoMethod;
import com.resshare.framework.core.reflectproxy.AnoModule;
import com.resshare.framework.model.Input;
@AnoModule("core/api")
public interface ICore {
	@AnoMethod("input")
	String input( Input input);
}
