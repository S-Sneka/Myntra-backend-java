package com.myntra.email.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.email.common.APIResponse;
import com.myntra.email.dao.EmailDetails;
import com.myntra.email.service.EmailService;

@CrossOrigin
@RestController
@RequestMapping("/email")
public class EmailController {

	private EmailService emailService;

	public EmailController(EmailService emailService) {
		super();
		this.emailService = emailService;
	}
	
	@GetMapping("/test")
	public String test() {
		return "Server running";
	}
	
	@PostMapping("/sendMail")
	public APIResponse sendMail(@RequestBody EmailDetails details)
	{
		return emailService.sendMail(details);
	}
}
