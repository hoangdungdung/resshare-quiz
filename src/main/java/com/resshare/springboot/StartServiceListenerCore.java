package com.resshare.springboot;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.resshare.AppConfig;
import com.resshare.framework.core.service.CacheConfigurationListener;
import com.resshare.framework.core.service.CalculateListener;
import com.resshare.framework.core.service.CreateApptListener;
import com.resshare.framework.core.service.CreateFlowchartListener;
import com.resshare.framework.core.service.CreateMenuFuntionListener;
import com.resshare.framework.core.service.CreateScreenListener;
import com.resshare.framework.core.service.DashboardGridviewLayoutTempleCreateListener;
import com.resshare.framework.core.service.DashboardGridviewLayoutTempleCreateListener2;
import com.resshare.framework.core.service.DashboardGridviewLayoutTempleCreateListener3;
import com.resshare.framework.core.service.FlowchartDemo;
import com.resshare.framework.core.service.FlowchartListenerExecute;
import com.resshare.framework.core.service.GetDataListener;
import com.resshare.framework.core.service.GetLayoutFormDataListener;
import com.resshare.framework.core.service.GetLayoutMethodScriptContentInsetLeftListener;
import com.resshare.framework.core.service.GetLayoutMethodScriptLayoutToRightOfListener;
import com.resshare.framework.core.service.GetMainDashboardListener;
import com.resshare.framework.core.service.LoadFormRunFlowchartListener;
import com.resshare.framework.model.Output;

@SpringBootApplication // (scanBasePackages = { "com.websystique.springboot" }) // same as
// @Configuration
// @EnableAutoConfiguration @ComponentScan
// combined
public class StartServiceListenerCore {

	public static void main(String[] args) {
		SpringApplication.run(StartServiceListenerCore.class, args);
	}

	public static String DATABASE_URL = "https://quattet-11188.firebaseio.com/";
	public static String GATEWAY_URI;
	public static String http = "http";
	public static String gateway_type = "";
	public static String x_api_key = "";

	public static final Logger log = LoggerFactory.getLogger(StartServiceListenerCore.class);

	public static final String MENU_APP = "system_settings/menu_config/data";
	public static final String RESPONSES = "responses";
	public static final String RESPONSES_HIS = "responses_his";
	public static final String MENU_APP_HIS = "system_settings/menu_config/his/data";
	public static final String DATA = "data";
	public static final String CONFIGURATION = "configuration";
	public static boolean DEBUG = false;
	public static String UPLOAD_FILE_URI;

	public static String USER_ID = "USER_ID";
	public static String REST_SERVICE_URI = "http://localhost:8080/api";
	public static String RESSHARE_REST_SERVICE_URI = "http://localhost:8088/api";
	public static String APPLICATION_NAME = "quattet";
	public static String ENV = "DEV";
	public static String CLUSTER = "";
	public static String INPUT = "input_data";

	public static String KEY = "123";

	private static void postOutput(Output output) {
		System.out.println("Testing postOutput Output API----------");
		RestTemplate restTemplate = new RestTemplate();

		URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/output/", output, Output.class);
		System.out.println("Location : " + uri.toASCIIString());
	}

	public static void startListener() {

		// UserRecenlyAddListener userRecenlyAddListener = new UserRecenlyAddListener();
		// userRecenlyAddListener.onStart();

		// GetHomeLayoutListener getHomeLayoutListener = new GetHomeLayoutListener();
		// getHomeLayoutListener.onStart();

		GetMainDashboardListener getMainDashboardListener = new GetMainDashboardListener();
		getMainDashboardListener.onStart();

		CalculateListener calculateListener = new CalculateListener();
		calculateListener.onStart();
		GetDataListener getDataListener = new GetDataListener();
		getDataListener.onStart();

		GetLayoutFormDataListener getLayoutDataListener = new GetLayoutFormDataListener();
		getLayoutDataListener.onStart();
		GetLayoutMethodScriptContentInsetLeftListener getLayoutMethodScriptContentInsetLeftListener = new GetLayoutMethodScriptContentInsetLeftListener();
		getLayoutMethodScriptContentInsetLeftListener.onStart();

		GetLayoutMethodScriptLayoutToRightOfListener getLayoutMethodScriptLayoutToRightOfListener = new GetLayoutMethodScriptLayoutToRightOfListener();
		getLayoutMethodScriptLayoutToRightOfListener.onStart();

		FlowchartDemo demo = new FlowchartDemo();
		demo.onStart();

		CreateMenuFuntionListener createMenuFuntionListener = new CreateMenuFuntionListener();
		createMenuFuntionListener.onStart();

		CreateFlowchartListener createFlowchartListener = new CreateFlowchartListener();
		createFlowchartListener.onStart();

		CreateScreenListener createScreenListener = new CreateScreenListener();
		createScreenListener.onStart();

		LoadFormRunFlowchartListener loadFormRunFlowchartListener = new LoadFormRunFlowchartListener();
		loadFormRunFlowchartListener.onStart();

		FlowchartListenerExecute flowchartExecute = new FlowchartListenerExecute();
		flowchartExecute.onStart();

		DashboardGridviewLayoutTempleCreateListener dashboardGridviewLayoutTempleCreateListener = new DashboardGridviewLayoutTempleCreateListener();
		dashboardGridviewLayoutTempleCreateListener.onStart();

		DashboardGridviewLayoutTempleCreateListener2 dashboardGridviewLayoutTempleCreateListener2 = new DashboardGridviewLayoutTempleCreateListener2();
		dashboardGridviewLayoutTempleCreateListener2.onStart();
		DashboardGridviewLayoutTempleCreateListener3 dashboardGridviewLayoutTempleCreateListener3 = new DashboardGridviewLayoutTempleCreateListener3();
		dashboardGridviewLayoutTempleCreateListener3.onStart();

		CreateApptListener createApptListener = new CreateApptListener();
		createApptListener.onStart();

		CacheConfigurationListener cacheConfigurationListener = new CacheConfigurationListener();
		cacheConfigurationListener.onStart();

	}

	// @Bean
	// public EmbeddedServletContainerCustomizer containerCustomizer() {
	// return new EmbeddedServletContainerCustomizer() {
	// @Override
	// public void customize(ConfigurableEmbeddedServletContainer container) {
	// try {
	//
	// Properties prop = new Properties();
	// InputStream input = null;
	//
	// try {
	//
	// input = new FileInputStream("config.properties");
	//
	// // load a properties file
	// prop.load(input);
	//
	// // get the property value and print it out
	// DATABASE_URL = prop.getProperty("database");
	// REST_SERVICE_URI = prop.getProperty("rest_service_uri");
	// RESSHARE_REST_SERVICE_URI = prop.getProperty("resshare_rest_service_uri");
	// APPLICATION_NAME = prop.getProperty("application_name");
	// ENV = prop.getProperty("ent");
	// CLUSTER = prop.getProperty("cluster");
	//
	//
	//
	// KEY = prop.getProperty("key");
	//
	// } catch (IOException ex) {
	// ex.printStackTrace();
	// } finally {
	// if (input != null) {
	// try {
	// input.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	//
	// FileInputStream serviceAccount = new FileInputStream("service-account.json");
	// FirebaseOptions options;
	// try {
	// options = new FirebaseOptions.Builder()
	// .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
	// .setDatabaseUrl(DATABASE_URL).build();
	// FirebaseApp.initializeApp(options);
	// System.out.println("success ");
	//
	// startListener();
	//
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// } catch (IOException e) {
	// System.out.println("ERROR: invalid service account credentials. See
	// README.");
	// System.out.println(e.getMessage());
	//
	// System.exit(1);
	// }
	//
	// }
	//
	// };
	// }
	public static Properties prop = null;

	public static Properties getConfig(String config) {

		Properties propconfig = new Properties();

		{
			try {

				try {

					// input = new FileInputStream(config);
					// Properties props = new Properties();
					// URL resource = getClass().getClassLoader().getResource("data.properties");
					// props.load(new InputStreamReader(resource.openStream(), "UTF8"));
					//
					//// load a properties file
					// propconfig.load(input,"UTF8");
					propconfig.load(new InputStreamReader(new FileInputStream(config), "UTF8"));

				} catch (IOException ex) {
					ex.printStackTrace();
				} finally {
				}

			} catch (Exception e) {
				System.out.println("ERROR: invalid service account credentials. See README.");
				System.out.println(e.getMessage());

				System.exit(1);
			}
		}
		return propconfig;

	}

	public static Properties getConfig() {
		if (prop != null)
			return prop;
		prop = getConfig("config.properties");
		// get the property value and print it out
		DATABASE_URL = prop.getProperty("database");
		GATEWAY_URI = prop.getProperty("gateway_uri");
		http = prop.getProperty("http");
		x_api_key = prop.getProperty("x_api_key");

		gateway_type = prop.getProperty("gateway_type");

		APPLICATION_NAME = prop.getProperty("app_name");
		UPLOAD_FILE_URI = prop.getProperty("upload_file_uri");
		ENV = prop.getProperty("ent");
		CLUSTER = prop.getProperty("cluster");
		USER_ID = prop.getProperty("user_id");
		KEY = prop.getProperty("key");
		String sDEBUG = prop.getProperty("debug");
		if (sDEBUG != null)
			DEBUG = Boolean.valueOf(sDEBUG);

		if ((FirebaseApp.getApps() == null) || (FirebaseApp.getApps().size() == 0))
			try {
				FileInputStream serviceAccount = new FileInputStream("service-account.json");
				FirebaseOptions options;
				options = new FirebaseOptions.Builder()
						.setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
						.setDatabaseUrl(StartServiceListenerCore.DATABASE_URL).build();
				FirebaseApp.initializeApp(options);
				System.out.println("success ");

				// loadHostInstance();
				// FirebaseDatabase.getInstance().getReference("draft").setValue(null);

			} catch (IOException e) {
				e.printStackTrace();
			}
		return prop;
	}

	public static int getPort() {
		Properties propPort = getConfig("application.properties");
		String iPort = propPort.getProperty("server.port");
		return Integer.parseInt(iPort);
	}
	public static void startFirebaseApp() {
		if ((FirebaseApp.getApps() == null) || (FirebaseApp.getApps().size() == 0))
			try {
				FileInputStream serviceAccount = new FileInputStream("service-account.json");
				FirebaseOptions options;
				options = new FirebaseOptions.Builder()
						.setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
						.setDatabaseUrl(StartServiceListenerCore.DATABASE_URL).build();
				FirebaseApp.initializeApp(options);
				System.out.println("success ");

				// loadHostInstance();
				// FirebaseDatabase.getInstance().getReference("draft").setValue(null);

			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public static void setAppConfig(AppConfig appcfg) {
		DATABASE_URL = appcfg.getDatabase();
		GATEWAY_URI = appcfg.getGateway_uri();
		http = appcfg.getHttp();
		x_api_key =  appcfg.getX_api_key();     

		gateway_type = appcfg.getGateway_type();   

		APPLICATION_NAME = appcfg.getApp_name();
		UPLOAD_FILE_URI = appcfg.getUpload_file_uri(); 
				 
		ENV = "";
		CLUSTER = appcfg.getCluster();
		USER_ID =  appcfg.getUser_id();
				 
		KEY = appcfg.getBackend_key();
		String sDEBUG = appcfg.getDebug();
		if (sDEBUG != null)
			DEBUG = Boolean.valueOf(sDEBUG);

	}
}
