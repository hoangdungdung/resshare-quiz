
package com.resshare.core.screen;

import com.resshare.framework.model.MapObject;

public interface DirectionDynamicActivity {

	void close();

	MapObject getListFieldNameValue();

	void showAlertDialog(Object string);

	void pickFile(String string);

	Object getUserName();

	void pickImage(String string);

	void uploadImage();

	Object getImageUrl();

	Object getImageStoragePath();

	void onBackPressed();

	void viewAddress();

	void addControlViewTextAddress(String control_name);

	void addControlViewLocationAddress(String control_name);

	void addPolyline(Object array_list_polyline);

	void drawVehicle(String sVehicleType, String position, String user_id);

	void setCollectionLocationOnStop(String collectionLocationOnStop);

	void setCollectionLocationChanged(String collectionLocationChanged);
}
