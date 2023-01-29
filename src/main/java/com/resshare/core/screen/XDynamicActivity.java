
package com.resshare.core.screen;

import com.resshare.framework.model.MapObject;

public interface XDynamicActivity {

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
 
 

}
