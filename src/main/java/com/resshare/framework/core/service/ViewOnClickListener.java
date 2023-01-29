package com.resshare.framework.core.service;

import android.view.View;

public abstract  class  ViewOnClickListener implements android.view.View.OnClickListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6189943742961771817L;
	/**
	 * 
	 */
	 
	private String name;

	@Override
	public abstract void onClick(View v) ;

	public void setName(String name) {
		this.name = name;

	}

	public String getName() {
		return name;

	}
}