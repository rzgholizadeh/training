package com.mrghz.springboot.demo.testapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on the server is " + LocalDateTime.now();
	}

}
