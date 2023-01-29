package com.resshare.widget;

import java.util.Map;

import com.resshare.framework.model.Script;

import android.widget.ListAdapter;

public interface GridViewAdapter extends ListAdapter {

	void setData(Object grid_view_data);

	Object getItemData();

	void setScript(Script script);

	void setLayout(Object grid_view_layout);
	public Object getSelectField( String fieldName);
	 public void setScriptItemClick(Script scriptItemClick);
	 
 

	void addData(Object row_data);

}
