package com.training.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class StudentController {
 
	@GetMapping("/")
	public String displayHomePage()
	{
		return "index";
	}
	
	
}
