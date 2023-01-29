package com.resshare.framework.model;

import java.io.Serializable;

public class ViewOnClickListenerMetadata implements Serializable {
	/**
	 * 
	 */
	public ViewOnClickListenerMetadata() {
		this.type = "ViewOnClickListenerMetadata";
	}

	private static final long serialVersionUID = 1L;
	private String controlName;
	private String methodName;
	private Script scriptFuntion;
	private String viewOnClickListenerInstanceClassName;

	// Getter Methods

	public String getControlName() {
		return controlName;
	}

	public String getMethodName() {
		return methodName;
	}

	public Script getScriptFuntion() {
		return scriptFuntion;
	}

	public String getViewOnClickListenerInstanceClassName() {
		return viewOnClickListenerInstanceClassName;
	}

	// Setter Methods

	public void setControlName(String controlName) {
		this.controlName = controlName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void setScriptFuntion(Script scriptFuntion) {
		this.scriptFuntion = scriptFuntion;
	}

	public void setViewOnClickListenerInstanceClassName(String viewOnClickListenerInstanceClassName) {
		this.viewOnClickListenerInstanceClassName = viewOnClickListenerInstanceClassName;
	}

	private String type;
//	private String hashCodeValue;

	public void setType(String type) {
		this.type = type;

	}

	public String getType() {
		return this.type;

	}
	 
//	public void setHashCodeValue(String hashCodeValue) {
//		this.hashCodeValue=hashCodeValue;
//		
//	}
//	public String getHashCodeValue() {
//		return this.hashCodeValue;
//		
//	}
}
