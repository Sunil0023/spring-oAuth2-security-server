package com.sunil.server.testnewserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

	@GetMapping("/testnewserver")
	public String hellotest() {
		System.out.println("new Server get Mapping");
		return "new Test server";
	}
}
