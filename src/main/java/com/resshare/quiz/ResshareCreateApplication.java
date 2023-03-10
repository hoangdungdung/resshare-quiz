package com.resshare.quiz;

import com.resshare.framework.core.service.RequestClient;
import com.resshare.springboot.StartServiceListenerCore;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication(scanBasePackages = { "com.resshare" }) // same as @Configuration
																// @EnableAutoConfiguration @ComponentScan
																// combined
public class ResshareCreateApplication {

	public static void main(String[] args) {
		Properties pro = StartServiceListenerCore.getConfig("config.properties");
		StartServiceListenerCore.setContext(pro);
		RequestClient.createApplication( "hoangdung1008@gmail.com","-NP5bm1ZzHNMJzzX3N-c1","test_CreateApplication");

	}



	public static String offsensive;

	public static String DATABASE_URL;
	// public static final Logger log =
	// LoggerFactory.getLogger(ResshareGoibinhOxyApp.class);
	//
	// public static final String MENU_APP = "system_settings/menu_config/data";
	// public static final String RESPONSES = "responses";
	// public static final String RESPONSES_HIS = "responses_his";
	// public static final String MENU_APP_HIS =
	// "system_settings/menu_config/his/data";
	// protected static final String REST_SERVICE_URI_CORE =
	// "http://localhost:8088/config";
	// public static String REST_SERVICE_URI = "http://localhost:8080/api";
	// public static String RESSHARE_REST_SERVICE_URI_DRIVER =
	// "http://localhost:8086/api";
	public static String APPLICATION_NAME;
	public static String KEY;

	// private static void postOutput(Output output) {
	// System.out.println("Testing postOutput Output API----------");
	// RestTemplate restTemplate = new RestTemplate();
	//
	// URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/output/", output,
	// Output.class);
	// System.out.println("Location : " + uri.toASCIIString());
	// }


}
