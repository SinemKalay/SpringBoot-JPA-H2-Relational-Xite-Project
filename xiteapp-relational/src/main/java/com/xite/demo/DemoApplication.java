package com.xite.demo;

import com.xite.demo.repository.MusicVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class DemoApplication {

	@Autowired
	private MusicVideoRepository musicVideoRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
