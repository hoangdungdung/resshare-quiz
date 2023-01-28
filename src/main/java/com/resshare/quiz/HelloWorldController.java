package com.resshare.quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/helloworld")
public class HelloWorldController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

	@GetMapping
	public ResponseEntity<String> ping() {
		final String LOG_HEADER = "[HelloWorld]: ";
		LOGGER.info("{} HelloWorld ", LOG_HEADER);
		return ResponseEntity.status(HttpStatus.OK).body("API  HelloWorld is running ...");

	}

}
