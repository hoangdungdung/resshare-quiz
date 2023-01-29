package com.resshare.framework.core.reflectproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyDemo<T> {

	public static void main(String[] args) {

		// Gson gs = new Gson();
		//
		// HashMap<String,String> htb=new HashMap<String,String>();
		// htb.put("pusher_app_id", "gggg");
		// JsonObject s = gs.toJsonTree(htb).getAsJsonObject();
		//
		// String jsonText = s.toString();

		// ProxyDemo<IDriverProfile> pr = new ProxyDemo<IDriverProfile>();
		// IDriverProfile iDriverProfile = pr.create(IDriverProfile.class);
		// HashMap<String, Object> map=new HashMap<>();
		//// String driver_id1 = (String) map.get("driver_id");
		//// float distance = (float) map.get("distance");
		//// String vehicle_type = (String) map.get("vehicle_type");
		//// String user_request_id = (String) map.get("user_request_id");
		//
		//
		// map.put("driver_id", "useid_kkkkkkkk");
		// map.put("distance", 1000.0);
		// map.put("vehicle_type", "all");
		// map.put("user_request_id", "SX3yNJSna4QTnBZ9yDsMkwVrJbc2");
		//
		//
		//
		//
		//
		// iDriverProfile.billing(map);
 

	}

	public static void main1(String[] args) throws IllegalArgumentException {
		InvocationHandler handler = new SampleInvocationHandler();
		SampleInterface proxy = (SampleInterface) Proxy.newProxyInstance(SampleInterface.class.getClassLoader(),
				new Class[] { SampleInterface.class }, handler);
		Class invocationHandler = Proxy.getInvocationHandler(proxy).getClass();

		System.out.println(invocationHandler.getName());
		proxy.showMessage();
	}

	public T create(Class cl) throws IllegalArgumentException {
		InvocationHandler handler = new SampleInvocationHandler();
		T proxy = (T) Proxy.newProxyInstance(cl.getClassLoader(), new Class[] { cl }, handler);

		return (T) proxy;

	}
}
