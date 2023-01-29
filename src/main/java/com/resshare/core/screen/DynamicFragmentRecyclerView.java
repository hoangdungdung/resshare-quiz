package com.resshare.core.screen;

import java.util.List;

public interface DynamicFragmentRecyclerView extends DynamicFragment {
	void setSpinnerData(String spinner_name, List<String> list_data);
	   void setupSearchView( String search_view_name, String post_collection);
	void resetDashboard();
	void showAlertDialog(Object string);
}
