package com.starse.kintai.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starse.kintai.model.EmployeeInfo.Role;
import com.starse.kintai.repo.EmployeeInfoRepo;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private EmployeeInfoRepo repo;
	
	@GetMapping()
	public String index(HttpServletRequest req) {
		
	/*	String loginId = req.getRemoteUser();
		
		Optional<EmployeeInfo> employeeInfo = repo.findOneByMail(loginId);
		
		return employeeInfo.map(a -> {
			req.getSession(true).setAttribute("LoginUser", a);
			return a.getRole() == Role.Admin ? "/admin/home" : "/employee/home";
		}).orElseThrow(() -> new UsernameNotFoundException("Illegal User"));*/
		
		return repo.findOneByMail(req.getRemoteUser()).map(a -> {
			req.getSession(true).setAttribute("LoginUser", a);
			return a.getRole() == Role.Admin ? "redirect:/admin/adminHome" : "redirect:/employee/employeeHome";
		}).orElseThrow(() -> new UsernameNotFoundException("Illegal User"));
	}
		
}
