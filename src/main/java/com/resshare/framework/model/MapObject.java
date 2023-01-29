package com.resshare.framework.model;

import java.io.Serializable;

public interface MapObject extends Serializable {

	// Getter Methods

 

	public String getName();

	public String setName(String name);

	public void setFieldValue(String string, Object a);
	public void setFieldValue(String string, Class type,Object a);
}