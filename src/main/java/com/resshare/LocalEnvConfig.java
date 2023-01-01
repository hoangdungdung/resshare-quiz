package com.resshare;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;

/**
 * Chỉ khi profiles là "local"
 * Thì Configuration dưới đây mới được khởi tạo
 */
@Configuration
@Profile("local")
public class LocalEnvConfig {

	 @Autowired
	  private LocalConfig localConfig;
 
    @Bean(name = "appConfig")
    public AppConfig appConfig() {
    	
        return localConfig;
    }
   
    
}