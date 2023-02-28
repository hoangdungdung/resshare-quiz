package com.resshare.framework.core.reflectproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.resshare.springboot.StartServiceListenerCore;

public class SampleInvocationHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {

		try {
			String methodName = null;
			AnoMethod annoMethod = method.getAnnotation(AnoMethod.class);
			if (annoMethod == null)
				methodName = method.getName();
			else
				methodName = annoMethod.value();

			if ((StartServiceListenerCore.http == null) || "".equals(StartServiceListenerCore.http))
				StartServiceListenerCore.http = "http";

			String REST_SERVICE_URI = StartServiceListenerCore.http + "://" + StartServiceListenerCore.GATEWAY_URI;// +"/";
			RestTemplate restTemplate = new RestTemplate();
			Object requestJson = args[0];
			Class<?> TypeClass = method.getReturnType();
			Object result = null;
			if ("amazonaws".equals(StartServiceListenerCore.gateway_type)) {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);

				headers.set("x-api-key", StartServiceListenerCore.x_api_key);

				HttpEntity entity = new HttpEntity(requestJson, headers);
				System.out.print("REST_SERVICE_URI: " + REST_SERVICE_URI);
				result = restTemplate.postForObject(REST_SERVICE_URI, entity, TypeClass);
			} else {

				AnoModule annoModulde = method.getDeclaringClass().getAnnotation(AnoModule.class);
				System.out.println("annoModulde: " + annoModulde.value());
				System.out.println("methodName: " + methodName);

				REST_SERVICE_URI = REST_SERVICE_URI +"/"+ annoModulde.value() + "/" + methodName + "/";
				result = restTemplate.postForObject(REST_SERVICE_URI, requestJson, TypeClass);
			}
			return result;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}
}