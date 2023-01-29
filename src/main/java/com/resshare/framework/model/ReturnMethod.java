package com.resshare.framework.model;

import java.io.Serializable;

public class ReturnMethod implements Serializable {
	/**
	 * 
	 */
	private String type;

	public void setType(String type) {
		this.type = type;

	}

	public String getType() {
		return this.type;

	}

	public ReturnMethod() {
		this.type = "ReturnMethod";
	}
	public ReturnMethod(String varianName) {
		this.varianName=varianName;
		this.type = "ReturnMethod";
	}
	private static final long serialVersionUID = 1L;

	public String getVarianName() {
		return this.varianName;
	}

	private String varianName;

	public void setVarianName(String varianName) {
		this.varianName = varianName;
	}

}
