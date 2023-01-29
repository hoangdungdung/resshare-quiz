package com.resshare.framework.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MethodMetadata implements Serializable {

	/**
	 * 
	 */
	public MethodMetadata() {
		this.type = "MethodMetadata";
	}

	private static final long serialVersionUID = 1L;

	private String instanceClassName;
	private String instanceName;
	private String methodName;
	private  Object[] methodParam;
	private ReturnMethod returnMethod;

	// Getter Methods

	public String getInstanceClassName() {
		return instanceClassName;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public String getMethodName() {
		return methodName;
	}

	public  Object[] getMethodParam() {
		return methodParam;
	}

	public ReturnMethod getReturnMethod() {
		return returnMethod;
	}

	// Setter Methods

	public void setInstanceClassName(String instanceClassName) {
		this.instanceClassName = instanceClassName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void setMethodParam( Object[] methodParam) {
		this.methodParam = methodParam;
	}

	public void setReturnMethod(ReturnMethod returnMethod) {
		this.returnMethod = returnMethod;
	}

	private String type;

	public void setType(String type) {
		this.type = type;

	}

	public String getType() {
		return this.type;

	}
	private Class<?>[] 	methodParamType;
	public void setMethodParamType(Class<?>[] methodParamType) {
		this.methodParamType=methodParamType;
		
	}
	public Class<?>[] getMethodParamType() {
	return	methodParamType;
		
	}

	/////

}
