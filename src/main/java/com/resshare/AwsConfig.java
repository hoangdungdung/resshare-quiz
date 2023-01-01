package com.resshare;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("aws")
@EnableAutoConfiguration
@PropertySource("classpath:aws_config.properties")

public class AwsConfig extends AppConfig {

}
