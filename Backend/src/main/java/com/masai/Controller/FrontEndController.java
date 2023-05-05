package com.masai.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontEndController {

	@RequestMapping("/index")
	public String firstPage() {
		
		return "index.html";
	}
}
