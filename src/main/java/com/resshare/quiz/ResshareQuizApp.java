package com.resshare.quiz;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.github.alexdlaird.ngrok.NgrokClient;
import com.github.alexdlaird.ngrok.protocol.CreateTunnel;
import com.github.alexdlaird.ngrok.protocol.Tunnel;
import com.google.firebase.FirebaseApp;
import com.resshare.AppConfig;
import com.resshare.clienst.FileUploaderClient;
import com.resshare.framework.core.service.RequestClient;
import com.resshare.springboot.StartServiceListenerCore;

@SpringBootApplication(scanBasePackages = { "com.resshare" }) // same as @Configuration
																// @EnableAutoConfiguration @ComponentScan
																// combined
public class ResshareQuizApp {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ResshareQuizApp.class, args);

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

	@Autowired
	private ApplicationContext ctx;

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {

				AppConfig appcfg = (AppConfig) ctx.getBean("appConfig");

				System.out.println(appcfg.getDatabase());
				System.out.println(appcfg.getBackend_key());
				System.out.println(appcfg.getApp_name());

				// LocalDatasource localDatasource = ctx.getBean(LocalDatasource.class);
				// System.out.println(localDatasource);

				if ((FirebaseApp.getApps() == null) || (FirebaseApp.getApps().size() == 0)) {
					try {

					 
						StartServiceListenerCore.setAppConfig(appcfg);
						StartServiceListenerCore.startFirebaseApp();

//						String backend_address = properties.getProperty("backend_address");
//						String app_name = properties.getProperty("app_name");
//						String backend_key = properties.getProperty("backend_key");
//						String ngrok = properties.getProperty("ngrok");
						 String backend_address = appcfg.getBackend_address();
						 String app_name = appcfg.getApp_name();
						 String backend_key = appcfg.getBackend_key();
						 String ngrok = appcfg.getNgrok();
						
						if ("true".equals(ngrok))
							backend_address = runNgok();

						Properties offsensiveProperties = StartServiceListenerCore.getConfig("offsensive.properties");
						offsensive = offsensiveProperties.getProperty("offsensive");

						FileUploaderClient.buildUIScript();
						RequestClient.registerApp(app_name, backend_key, backend_address);

						StartServiceListenerCore.startListener();
						ServiceListenerQuizStart.startListener();

					} catch (Exception e) {
						System.out.println("ERROR: invalid service account credentials. See README.");
						System.out.println(e.getMessage());

						System.exit(1);
					}
				}

			}

		};
	}

	private String runNgok() {
		String backend_address;
		//String ngrokPathconfig = "D:\\sunshiner\\Book\\20180318\\bookMap\\resshare-book\\ngrokconfig.properties";
		String ngrokPathconfig = "ngrokconfig.properties";
		try {

			final NgrokClient ngrokClient = new NgrokClient.Builder().build();
			final int port = com.resshare.springboot.StartServiceListenerCore.getPort();

			final CreateTunnel createTunnel = new CreateTunnel.Builder().withAddr(port).build();
			final Tunnel tunnel = ngrokClient.connect(createTunnel);

			System.out.println(tunnel.getPublicUrl());
			backend_address = tunnel.getPublicUrl().replaceFirst("http://", "");
			Properties propconfigNgrok = StartServiceListenerCore.getConfig(ngrokPathconfig);

			propconfigNgrok.setProperty("public_url", backend_address);
			try {
				OutputStream output = new FileOutputStream(ngrokPathconfig);

				propconfigNgrok.store(output, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			Properties propconfigNgrok = StartServiceListenerCore.getConfig(ngrokPathconfig);
			backend_address = propconfigNgrok.getProperty("public_url");

			System.out.println("ERROR: NgrokClient.");
			System.out.println(e.getMessage());

		}
		return backend_address;
	};

}
