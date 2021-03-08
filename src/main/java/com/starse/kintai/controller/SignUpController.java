//package com.starse.kintai.controller;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.starse.kintai.model.EmployeeInfo;
//import com.starse.kintai.model.EmployeeInfo.Role;
//import com.starse.kintai.repo.EmployeeInfoRepo;
//
//
//@Controller
//@RequestMapping("/sign-up")
//public class SignUpController {
//	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//	
//	@Autowired
//	private EmployeeInfoRepo repo;
//	
//	@GetMapping
//	public String index() {
//		return "/sign-up";
//	}
//	
//	@PostMapping
//	private String signUp(
//			@RequestParam String name,
//			@RequestParam String mail, 
//			@RequestParam String password, HttpServletRequest req) {
//		
//		try {
//			EmployeeInfo empInfo = new EmployeeInfo();
//			empInfo.setName(name);
//			empInfo.setMail(mail);
//			empInfo.setPassword(passwordEncoder.encode(password));
//			empInfo.setRole(Role.Employee);
//			
//			repo.save(empInfo);
//			
//			req.login(mail, password);
//		} catch (ServletException e) {
//			e.printStackTrace();
//		}
//		
//		return "redirect:/home";
//	}
//}
