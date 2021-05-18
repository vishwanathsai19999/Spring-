package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
/*This RequestMapping without value and method parameter
represents that its a GET Request by default*/
public class HelloController {
	@RequestMapping(value="/basic",method=RequestMethod.GET)
	public String sayHello() {
		return"<h1>hello</h1>";
	}

	@RequestMapping("/proper")
	/*No need to mention value and method parameters here in this RequestMapping 
	since it represents by default and the above RequestMapping is for Reference*/
	public String sayproperHello() {
		return"<h1>hello there,how are you?</h1>";
	}
	
	@RequestMapping("/user_entry")
	public String userForm() {
		return " <form action=\"/greeting/user_greeting\" method=\"GET\">\r\n"
		+ "  <label for=\"firstname\">First name:</label><br>\r\n"
		+ "  <input type=\"text\" id=\"firstname\" name=\"firstname\"><br>\r\n"
		+ "  <label for=\"lastname\">Last name:</label><br>\r\n"
		+ "  <input type=\"text\" id=\"lastname\" name=\"lastname\"><br><br>\r\n"
		+ "  <input type=\"submit\" value=\"Submit\">\r\n"
		+ "</form> ";
	}
	
	@RequestMapping(value="/user_greeting", method=RequestMethod.GET)
	public String printUserGreeting(@RequestParam String firstname,@RequestParam String lastname) {
		return "Hello there,"+firstname+" "+lastname;
	}
	
	@RequestMapping(value="/orders/{id}", method=RequestMethod.GET)
	public String getOrders(@PathVariable String id) {
		return "Order ID "+id;
	}
}
