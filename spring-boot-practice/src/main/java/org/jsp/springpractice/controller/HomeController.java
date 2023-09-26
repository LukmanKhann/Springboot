package org.jsp.springpractice.controller;

import org.jsp.springpractice.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	

	@GetMapping(value = "/home")
//	@ResponseBody
	public String home() {
		return "Hello World";
	}
	
//	@PostMapping(value = "/sum")
//	@GetMapping("/sum")
//	@ResponseBody
	public String sum(@RequestParam int num1,@RequestParam int num2) {
		return "the sum is :"+(num1+num2);
	}
	
	@GetMapping("/users")
	public User getUser(User u) {
		return new User(1,"lukman",7974964690l,"abc123");
	}
	@GetMapping("/get/{n}")
	public String getTable(@PathVariable int n) {
		String table = "";
		for (int i = 1;i<=10;i++) {
			table = table +n +"+"+i+"="+(n*i)+"\n";
			
		}
		return table;
		
	}
	
	@PostMapping("/users")
	public String printUser(@RequestBody User u) {
		System.out.println("Id :"+u.getId());
		System.out.println("Name :"+u.getName());
		System.out.println("Phone :"+u.getPhone());
		System.out.println("Password :"+u.getPassword());
		return "Data is printed";
	}
}
