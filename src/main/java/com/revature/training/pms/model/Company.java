package com.revature.training.pms.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties("company")
@Component
public class Company {

	private String companyname;
	private String companylocation;
	private String companyaddress;
	
}
