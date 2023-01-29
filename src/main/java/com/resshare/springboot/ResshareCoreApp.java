package com.resshare.springboot;

import com.google.protobuf.ByteString.Output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@SpringBootApplication(scanBasePackages = { "com.resshare" }) // same as @Configuration
																// @EnableAutoConfiguration @ComponentScan
																// combined
public class ResshareCoreApp {

	public static void main(String[] args) {
		SpringApplication.run(ResshareCoreApp.class, args);
	}

	public static String DATABASE_URL = "https://quattet-11188.firebaseio.com/";
	public static final Logger log = LoggerFactory.getLogger(ResshareCoreApp.class);

	public static final String MENU_APP = "system_settings/menu_config/data";
	public static final String RESPONSES = "responses";
	public static final String RESPONSES_HIS = "responses_his";
	public static final String MENU_APP_HIS = "system_settings/menu_config/his/data";
	protected static final String REST_SERVICE_URI_CORE = "http://localhost:8088/config";
	public static String REST_SERVICE_URI = "http://localhost:8080/api";
	public static String RESSHARE_REST_SERVICE_URI_DRIVER = "http://localhost:8086/api";
	public static String APPLICATION_NAME = "quattet";
	public static String KEY = "123";

	private static void postOutput(Output output) {
		System.out.println("Testing postOutput Output API----------");
		RestTemplate restTemplate = new RestTemplate();

		URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/output/", output, Output.class);
		System.out.println("Location : " + uri.toASCIIString());
	}

//	@Bean
//	public EmbeddedServletContainerCustomizer containerCustomizer() {
//		return new EmbeddedServletContainerCustomizer() {
//			@Override
//			public void customize(ConfigurableEmbeddedServletContainer container) {
//				if ((FirebaseApp.getApps() == null) || (FirebaseApp.getApps().size() == 0)) {
//					try {
//
//						Properties prop = new Properties();
//						InputStream input = null;
//
//						try {
//
//							input = new FileInputStream("config.properties");
//
//							// load a properties file
//							prop.load(input);
//
//							// get the property value and print it out
//							DATABASE_URL = prop.getProperty("database");
//
//							APPLICATION_NAME = prop.getProperty("application_name");
//							KEY = prop.getProperty("key");
//
//						} catch (IOException ex) {
//							ex.printStackTrace();
//						} finally {
//							if (input != null) {
//								try {
//									input.close();
//								} catch (IOException e) {
//									e.printStackTrace();
//								}
//							}
//						}
//
//						FileInputStream serviceAccount = new FileInputStream("service-account.json");
//						FirebaseOptions options;
//						try {
//							options = new FirebaseOptions.Builder()
//									.setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
//									.setDatabaseUrl(DATABASE_URL).build();
//							FirebaseApp.initializeApp(options);
//							System.out.println("success ");
//
//							// loadHostInstance();
//							FirebaseDatabase.getInstance().getReference("draft").setValue(null);
//
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//					} catch (IOException e) {
//						System.out.println("ERROR: invalid service account credentials. See README.");
//						System.out.println(e.getMessage());
//
//						System.exit(1);
//					}
//				}
//			}
//
//		};
//	}
}
