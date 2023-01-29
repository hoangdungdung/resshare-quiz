package com.resshare.framework.core.service;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
 
import java.util.Hashtable;

import com.resshare.framework.model.MapObject;
import com.resshare.framework.model.Maper;
import com.resshare.framework.model.MethodMetadata;
import com.resshare.framework.model.ReturnMethod;
import com.resshare.framework.model.Script;
import com.resshare.framework.model.ViewOnClickListenerMetadata;

import android.view.View;

public class UIBuilder2 {
	Script script = new Script();

	public UIBuilder2() {

	}

	private Hashtable<Integer, String> hasName = new Hashtable<>();

	public <T> T createShadow(Class<T> instanceClass, String name) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setType("MethodMetadata");
		mtMetadata.setMethodName("findControl");
		mtMetadata.setInstanceClassName("this");

		ArrayList<Serializable> methodParam = new ArrayList<>();
		methodParam.add(name);
		mtMetadata.setMethodParam(methodParam.toArray());
		mtMetadata.setMethodParamType(new Class[] { String.class });
		mtMetadata.setInstanceName(name);

		script.addCommand(mtMetadata);

		InvocationHandler handler = new EncodeSampleInvocationHandler(name, script);
		T proxy = (T) Proxy.newProxyInstance(instanceClass.getClassLoader(), new Class[] { instanceClass }, handler);

		return (T) proxy;

	}

	public <T> T convert(Class<T> classss, Object value) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setType("MethodMetadata");
		mtMetadata.setMethodName("convert");
		mtMetadata.setInstanceClassName("this");

		ArrayList<Serializable> methodParam = new ArrayList<>();
		methodParam.add(classss);
		Object value1 = script.getVarian(value);
		if (value1 != null) {
			methodParam.add((Serializable) value1);
		} else {
			methodParam.add((Serializable) value);
		}

		mtMetadata.setMethodParam(methodParam.toArray());
		mtMetadata.setMethodParamType(new Class[] { classss.getClass(), value.getClass() });

		mtMetadata.setInstanceName("this");

		script.addCommand(mtMetadata);

		Object objetClassss = null;
		try {

			Object className = classss.getName();
			if (("java.lang.CharSequence".equals(className)) || ("java.lang.String".equals(className))) {
				 
				objetClassss = getIdentify();

			} else

			{

				objetClassss = classss.getConstructor().newInstance(new Object[] {});
			}

			script.addVarian(objetClassss, value);
			return (T) objetClassss;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	static long lIdentify=Long.MIN_VALUE;
public static String getIdentify()
{ 
	if(lIdentify< Long.MAX_VALUE)
	lIdentify=lIdentify+1;
	else 
		 lIdentify=Long.MIN_VALUE;
	return "UI"+lIdentify;
	}

	public <T> T createShadowParam(Class<T> instanceClass, String controlName) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setType("MethodMetadata");
		mtMetadata.setMethodName("findControlParam");
		mtMetadata.setInstanceClassName("this");
		mtMetadata.setInstanceName(controlName);
		ArrayList<Serializable> methodParam = new ArrayList<>();

		mtMetadata.setMethodParam(methodParam.toArray());

		script.addCommand(mtMetadata);

		InvocationHandler handler = new EncodeSampleInvocationHandler(controlName, script);
		T proxy = (T) Proxy.newProxyInstance(instanceClass.getClassLoader(), new Class[] { instanceClass }, handler);

		return (T) proxy;

	}

	public <T> void createShadowObject(Class<T> class1, T boiling_point_klis, String string) {
		// TODO Auto-generated method stub

	}

	public <T extends ViewOnClickListener> void createShadowOnClickListener(T boiling_point_klis, String controlName) {
		View v = null;
		boiling_point_klis.setName(controlName);
		ViewOnClickListenerMetadata viewOnClickListenerMetadata = new ViewOnClickListenerMetadata();
		viewOnClickListenerMetadata.setType("ViewOnClickListenerMetadata");

		viewOnClickListenerMetadata.setMethodName("createViewOnClickListener");
		viewOnClickListenerMetadata.setViewOnClickListenerInstanceClassName("this");
		viewOnClickListenerMetadata.setControlName(controlName);
		// viewOnClickListenerMetadata.setHashCodeValue(String.valueOf(boiling_point_klis.hashCode()));

		Script scriptFuntion = new Script();
		viewOnClickListenerMetadata.setScriptFuntion(scriptFuntion);
		hasName.put(boiling_point_klis.hashCode(), controlName);

		script.addCommand(viewOnClickListenerMetadata);

		script.addOpenFuntion(scriptFuntion);
		boiling_point_klis.onClick(v);
		script.addcloseFuntion();

	}

	public Maper creatMaping(String nameMaper) {
		String command = "create Maper,name=" + nameMaper;
		script.addCommand(command);
		return new Maper(script, nameMaper);
		// TODO Auto-generated method stub

	}

	public <T> T createShadow1(String string) {
		return null;
		// TODO Auto-generated method stub

	}

	public Script getScriptSerializable() {
		script.clearVarian();
		return script;

	}

	public Script getScript() {
		return script;

	}

	public void post(MapObject objMap, String collection) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setMethodName("post");
		mtMetadata.setInstanceClassName("this");

		ArrayList methodParam = new ArrayList<>();
		methodParam.add(objMap);
		methodParam.add(collection);
		mtMetadata.setMethodParam(methodParam.toArray());

		script.addCommand(mtMetadata);

	}

	public void openForm(String jsonPathForm, String jsonPathModule) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setMethodName("openForm");
		mtMetadata.setInstanceClassName("this");

		ArrayList methodParam = new ArrayList<>();
		methodParam.add(jsonPathForm);
		methodParam.add(jsonPathModule);
		mtMetadata.setMethodParam(methodParam.toArray());

		script.addCommand(mtMetadata);

	}

	public void openForm(String jsonPathForm) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setMethodName("openForm");
		mtMetadata.setInstanceClassName("this");

		ArrayList methodParam = new ArrayList<>();

		Object valuePram = jsonPathForm;

		valuePram = getParamRefer(jsonPathForm, valuePram);

		methodParam.add(valuePram);

		mtMetadata.setMethodParam(methodParam.toArray());

		script.addCommand(mtMetadata);

	}

	public void openFormFlowchart(String jsonPathForm, String jsonPathFlowchart) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setMethodName("openFormFlowchart");
		mtMetadata.setInstanceClassName("this");

		ArrayList methodParam = new ArrayList<>();

		Object valuePram = jsonPathForm;

		valuePram = getParamRefer(jsonPathForm, valuePram);

		Object valueFlowchart = jsonPathFlowchart;

		valueFlowchart = getParamRefer(jsonPathFlowchart, valueFlowchart);

		methodParam.add(valuePram);
		methodParam.add(valueFlowchart);

		mtMetadata.setMethodParam(methodParam.toArray());

		script.addCommand(mtMetadata);

	}

	private Object getParamRefer(String jsonPathForm, Object valuePram) {
		Object value = script.getVarian(jsonPathForm);
		if (value != null) {
			while (true) {

				if (value instanceof ReturnMethod) {
					break;

				}
				Object value1 = script.getVarian(value);
				if (value1 == null) {
					break;
				} else {

					value = value1;

				}

			}

			valuePram = value;

		}
		return valuePram;
	}

	public void closeForm() {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setMethodName("close");
		mtMetadata.setInstanceClassName("this");

		script.addCommand(mtMetadata);

	}

	public void setDataRecyclerView(String recycler_view, ArrayList contacts) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setMethodName("setDataRecyclerView");
		mtMetadata.setInstanceClassName("this");
		ArrayList<Serializable> methodParam = new ArrayList<Serializable>();
		methodParam.add(recycler_view);
		methodParam.add(contacts);
		mtMetadata.setMethodParam(methodParam.toArray());
		script.addCommand(mtMetadata);

	}

	public Object createShadowParam(String paramName) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setType("MethodMetadata");
		mtMetadata.setMethodName("findValuelParam");
		mtMetadata.setInstanceClassName("this");

		ArrayList<Serializable> methodParam = new ArrayList<>();

		mtMetadata.setMethodParam(methodParam.toArray());
		mtMetadata.setInstanceName(paramName);

		ReturnMethod returnMethod = new ReturnMethod();
		returnMethod.setVarianName("return_" + paramName);
		mtMetadata.setReturnMethod(returnMethod);

		script.addCommand(mtMetadata);

		script.addReturn(returnMethod);

		return returnMethod;

		// InvocationHandler handler = new
		// EncodeSampleInvocationHandler(paramName,script);
		// Object proxy = Proxy.newProxyInstance(instanceClass.getClassLoader(), new
		// Class[] { instanceClass }, handler);

	}

	void createInstance(String instanceClassName, Object[] paramValue, Class[] paramType, ReturnMethod returnMethod) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setType("MethodMetadata");
		mtMetadata.setInstanceName("this");
		mtMetadata.setMethodName("createInstance");
		mtMetadata.setMethodParam(paramValue);
		mtMetadata.setMethodParamType(paramType);
		mtMetadata.setInstanceClassName(instanceClassName);

		mtMetadata.setReturnMethod(returnMethod);

		script.addCommand(mtMetadata);

		script.addReturn(returnMethod);

	}

	void runFuntion(String instanceName, String funtionName, Object[] paramValue, Class[] paramType,
			ReturnMethod returnMethod) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setType("MethodMetadata");
		mtMetadata.setInstanceName(instanceName);
		mtMetadata.setMethodName(funtionName);
		mtMetadata.setMethodParam(paramValue);
		mtMetadata.setMethodParamType(paramType);

		mtMetadata.setReturnMethod(returnMethod);

		script.addCommand(mtMetadata);

		script.addReturn(returnMethod);

	}

	void createRelativeLayout(Object[] paramValue, Class[] paramType, ReturnMethod returnMethod) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setType("MethodMetadata");
		mtMetadata.setInstanceName("this");
		mtMetadata.setMethodName("createRelativeLayout");
		mtMetadata.setMethodParam(paramValue);
		mtMetadata.setMethodParamType(paramType);

		mtMetadata.setReturnMethod(returnMethod);

		script.addCommand(mtMetadata);

		script.addReturn(returnMethod);

	}

	public void runStaticFuntion(String className, String funtionName, Object[] paramValue, Class[] parmaType,
			ReturnMethod returnMethod) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setType("MethodMetadata");

		mtMetadata.setInstanceClassName(className);
		mtMetadata.setMethodName(funtionName);
		mtMetadata.setMethodParam(paramValue);
		mtMetadata.setMethodParamType(parmaType);

		mtMetadata.setReturnMethod(returnMethod);

		script.addCommand(mtMetadata);

		script.addReturn(returnMethod);

		// TODO Auto-generated method stub

	}

	public void showImageView(String iconName, String stringUrl) {
		Object valuePram = stringUrl;

		valuePram = getParamRefer(stringUrl, valuePram);
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setMethodName("showImageView");
		mtMetadata.setInstanceClassName("this");
		ArrayList methodParam = new ArrayList<Serializable>();
		methodParam.add(iconName);
		methodParam.add(valuePram);

		mtMetadata.setMethodParam(methodParam.toArray());
		script.addCommand(mtMetadata);

	}

	public <T> T createMapObjectShadow(Class<MapObject> instanceClass, String name) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setMethodName("createMapObject");
		mtMetadata.setInstanceClassName("this");

		ArrayList<Serializable> methodParam = new ArrayList<>();

		methodParam.add(name);
		mtMetadata.setMethodParam(methodParam.toArray());

		mtMetadata.setInstanceName(name);

		script.addCommand(mtMetadata);

		InvocationHandler handler = new EncodeSampleInvocationHandler(name, script);
		T proxy = (T) Proxy.newProxyInstance(instanceClass.getClassLoader(), new Class[] { instanceClass }, handler);

		return (T) proxy;
	}

	public <T> T createListFieldNameValueShadow(Class<MapObject> instanceClass, String name) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setMethodName("createListFieldNameValueShadow");
		mtMetadata.setInstanceClassName("this");

		ArrayList<Serializable> methodParam = new ArrayList<>();

		methodParam.add(name);
		mtMetadata.setMethodParam(methodParam.toArray());

		mtMetadata.setInstanceName(name);

		script.addCommand(mtMetadata);

		InvocationHandler handler = new EncodeSampleInvocationHandler(name, script);
		T proxy = (T) Proxy.newProxyInstance(instanceClass.getClassLoader(), new Class[] { instanceClass }, handler);

		return (T) proxy;
	}

	public void postData(MapObject objMap, String collection) {
		MethodMetadata mtMetadata = new MethodMetadata();
		mtMetadata.setMethodName("postData");
		mtMetadata.setInstanceClassName("this");

		ArrayList methodParam = new ArrayList<>();
		methodParam.add(objMap);
		methodParam.add(collection);
		mtMetadata.setMethodParam(methodParam.toArray());

		script.addCommand(mtMetadata);

	}

}
