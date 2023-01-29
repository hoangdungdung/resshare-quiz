package com.resshare.framework.core.service;

import java.util.ArrayList;

import com.resshare.framework.model.MapObject;
import com.resshare.framework.model.Maper;
import com.resshare.framework.model.ReturnMethod;
import com.resshare.framework.model.Script;

public abstract class UIBuilderGeneric {

	public abstract Object getScriptShadowParam(String paramName);

	public abstract <T> T createShadow(Class<T> instanceClass, String name);

	public abstract <T> T convert(Class<T> classss, Object value);

	public abstract String getIdentify();

	public abstract <T> T createShadowParam(Class<T> instanceClass, String controlName);

	public abstract <T> void createShadowObject(Class<T> class1, T boiling_point_klis, String string);

	public abstract <T extends ViewOnClickListener> void createShadowOnClickListener(T boiling_point_klis,
			String controlName);

	public abstract Maper creatMaping(String nameMaper);

	public abstract <T> T createShadow1(String string);

	public abstract Script getScriptSerializable();

	public abstract Script getScript();

	public abstract void post(MapObject objMap, String collection);

	public abstract void openForm(String jsonPathForm, String jsonPathModule);

	public abstract void openForm(String jsonPathForm);

	public abstract void openFormFlowchart(String jsonPathForm, String jsonPathFlowchart);

	public abstract Object getParamRefer(String jsonPathForm, Object valuePram);

	public abstract void closeForm();

	public abstract void setDataRecyclerView(String recycler_view, ArrayList contacts);

	public abstract Object createShadowParam(String paramName);

	public abstract void createInstance(String instanceClassName, Object[] paramValue, Class[] paramType,
			ReturnMethod returnMethod);

	public abstract void runFuntion(String instanceName, String funtionName, Object[] paramValue, Class[] paramType,
			ReturnMethod returnMethod);

	public abstract void createRelativeLayout(Object[] paramValue, Class[] paramType, ReturnMethod returnMethod);

	public abstract void runStaticFuntion(String className, String funtionName, Object[] paramValue, Class[] parmaType,
			ReturnMethod returnMethod);

	public abstract void showImageView(String iconName, String stringUrl);

	public abstract <T> T createMapObjectShadow(Class<MapObject> instanceClass, String name);

	public abstract <T> T createListFieldNameValueShadow(Class<MapObject> instanceClass, String name);

	public abstract void postData(MapObject objMap, Object collection);

	public abstract void openFormFlowchartFragment(String jsonPathForm, String jsonPathFlowchart, String str_activity);

	public abstract void openDialContactPhone(Object supplier_phone_number);

	public abstract void dashboardRemoveCurrentMessage();

	public abstract void setListFieldNameValue(Object data_param);

	public abstract void openActivity(String jsonPathForm, String jsonPathFlowchart, String str_Activity,
			Object str_param_loadForm);
	// TODO Auto-generated method stub

	public abstract void postListFieldValue(String collection);
	public abstract void applyProperty(String control_name, String property_name, String property_value);

	 
}
