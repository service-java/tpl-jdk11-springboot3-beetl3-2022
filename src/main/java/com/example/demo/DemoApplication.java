package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		var h = """
				select * from hello
				""";
		SpringApplication.run(DemoApplication.class, args);
	}

}
