package com.jsp.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/emp")
public class EmployeesController {
	
	@GetMapping("/prodlogin")
	public String prodlogin() {
		return "prodlogin.html";
	}
	
	@PostMapping("/prodlogin")
	public String prodadmin(@RequestParam String username,@RequestParam String password,HttpSession session,ModelMap map) {
		if(username.equals("prod")) {
			if(password.equals("prod")) {
				session.setAttribute("prod", "prod");
				map.put("pass", "Login succes");
				return "redirect:/super-home";
			}else {
				map.put("fail", "Login failed");
				return "prodlogin.html";
			}}
			else {
				map.put("fail", "Enter proper Email");
				return "prodlogin.html";
			}
		}
	
	@PostMapping("/mixlogin")
	public String mixadmin(@RequestParam String username,@RequestParam String password,HttpSession session,ModelMap map) {
		if(username.equals("mix")) {
			if(password.equals("mix")) {
				session.setAttribute("mix", "mix");
				map.put("pass", "Login succes");
				return "redirect:/production";
			}else {
				map.put("fail", "Login failed");
				return "mixing.html";
			}}
			else {
				map.put("fail", "Enter proper Email");
				return "mixing.html";
			}
		}
	
	@GetMapping("/prodashboard")
	public String proddash() {
		return "prod_department.html";
	}
	
}
