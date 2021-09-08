package com.revature.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.training.pms.model.Company;

@RestController
public class HomeController {
	@Value("${company.companyname}")
	private String companyName;
	
	@Autowired
	Company company;
	
	@GetMapping("/cmp")
	public String getCompanyName() {
		return companyName;
	}
	
	@GetMapping("/getCompanyDetails")
	public Company getCompanyDetails() {
		return company;
	}
}

//localhost:9090/cmp
//localhost:9090/getCompanyDetails