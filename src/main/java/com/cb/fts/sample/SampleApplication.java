package com.cb.fts.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class SampleApplication {

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SampleApplication.class, args);
	}

}
