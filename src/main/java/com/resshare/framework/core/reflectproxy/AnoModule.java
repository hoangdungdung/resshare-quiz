package com.resshare.framework.core.reflectproxy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnoModule {

 

	public String value();
}

 
