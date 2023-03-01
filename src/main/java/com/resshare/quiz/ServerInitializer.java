package com.resshare.quiz;

import com.github.alexdlaird.ngrok.NgrokClient;
import com.github.alexdlaird.ngrok.protocol.CreateTunnel;
import com.github.alexdlaird.ngrok.protocol.Tunnel;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.resshare.AppConfig;
import com.resshare.clienst.FileUploaderClient;
import com.resshare.framework.core.service.RequestClient;
import com.resshare.framework.core.service.ResFirebaseReference;
import com.resshare.springboot.StartServiceListenerCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

@Component
public class ServerInitializer implements ApplicationRunner {
    @Autowired
    private ApplicationContext ctx;
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        {

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

                    String install = ResFirebaseReference.getInputPathReference("../install");

                    StartServiceListenerCore.INSTALL_NAME  = FirebaseDatabase.getInstance().getReference(install).push().getKey();

                    

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
                    ResshareQuizApp.offsensive = offsensiveProperties.getProperty("offsensive");



                    String type_run_app= "appConnectRS";



                    switch (type_run_app ) {
                        case  "registerDeveloper":
                            RequestClient.registerDeveloper("sacmauhoagiay@gmail.com");
                            break;
                        case  "createApplication":
                            RequestClient.createApplication( "hoangdung1008@gmail.com","-NP5bm1ZzHNMJzzX3N-c","test_CreateApplication");
                            break;
                        default:
                            FileUploaderClient.buildUIScript();
                            RequestClient.appConnectRS(app_name, backend_key, backend_address);

                            StartServiceListenerCore.startListener();
                            ServiceListenerQuizStart.startListener();
                    }










                } catch (Exception e) {
                    System.out.println("ERROR: invalid service account credentials. See README.");
                    System.out.println(e.getMessage());

                    System.exit(1);
                }
            }

        }

    }




    private String runNgok() {
        String backend_address;
        //String ngrokPathconfig = "D:\\sunshiner\\Book\\20180318\\bookMap\\resshare-book\\ngrokconfig.properties";
        String ngrokPathconfig = "ngrokconfig.properties";
        try {

            final NgrokClient ngrokClient = new NgrokClient.Builder().build();
            final int port = StartServiceListenerCore.getPort();

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
