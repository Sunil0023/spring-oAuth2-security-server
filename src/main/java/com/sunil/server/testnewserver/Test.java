package com.sunil.server.testnewserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

	@GetMapping("/testnewserver")
	public String hellotest() {
		System.out.println("new Server get Mapping");
		System.out.println("For second test from APP to Local Git and Finally Github");
		return "new Test server";
	}
	
	
	GetMapping("/testnewmethod")
	public String hellotest() {
		System.out.println("New method created manually");
		System.out.println("To check from GitHub to Local Copy");
		return "Test New method";
	}
}
