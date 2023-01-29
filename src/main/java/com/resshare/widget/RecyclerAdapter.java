package com.resshare.widget;

import com.resshare.framework.model.Script;

public interface RecyclerAdapter {
	public void addMessage(RecyclerMessage mMessage) ;
	public void setListData(Object list_data);
	void setScript(Script script);

	void setLayout(Object grid_view_layout);
	public void addData(Object item_data);
}
