package com.ptit.security.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptit.Entity.User;
import com.ptit.config.AES;
import com.ptit.getConnection.GetConnection;
import com.ptit.service.UserService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	UserService userService; 
	
	@GetMapping("/home")
	public String getHome() {
		return "home"; 
	}
	
	
	@GetMapping("/signin")
	public String getSignin() {
		
		
		return "signin"; 
	}
	
	
//	@PostMapping("/signin")
//	public String postSignin(@RequestParam String username, @RequestParam String password,ModelMap map) {
//		
//		List<User> list = userService.signIn(username,password); 
//		
//		if(list==null || list.size()>1) {
//			map.addAttribute("fail", true); 
//			map.addAttribute("list", list);
//			return "signin";
//		}
//		
//		if(list.size()==1) {
//			if(list.get(0).getPassword().equals(password))
//			return "redirect:/admin"; 
//		}
//		
//		
//		return "signin";
//	}
	
	@GetMapping("/checkSignin")
	public String postSignIn(@RequestParam boolean fail, ModelMap map) {
		
		
		map.addAttribute("fail", fail);
		return "signin";
		
		
	}
	
	@GetMapping("/signup")
	public String getSignup() {
		return "signup"; 
	}
	
	@PostMapping("/signup")
	public String postSignup(@RequestParam String username, @RequestParam String password,ModelMap map) {
		boolean checkExist = userService.signUp(username, password); 
		if(checkExist) {
			map.addAttribute("exist", checkExist);
			return "signup";
		}
		return "redirect:/signin"; 
		
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "admin"; 
	}
}
