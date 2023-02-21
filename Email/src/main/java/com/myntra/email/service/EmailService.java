package com.myntra.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.myntra.email.common.APIResponse;
import com.myntra.email.dao.EmailDetails;

@Service
public class EmailService {

	@Autowired private JavaMailSender javaMailSender;
	@Autowired private JdbcTemplate jdbcTemplate;
	@Autowired private APIResponse apiResponse;

	@Value("${spring.mail.username}") private String sender;

	public APIResponse sendMail(EmailDetails details)
	{
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
			String mail = details.getRecipient();
			int n = jdbcTemplate.queryForObject("select count(*) from MyntraAuthentication.user where email=?", Integer.class, new Object[]{mail});
			if(n==0) {
				apiResponse.setStatus(false);
				apiResponse.setData(null);
				apiResponse.setMessage("invalid email");
			}
			else {
				mailMessage.setTo(mail);
				mailMessage.setText("Dear Customer,\n"
						+ "\n"
						+ "We received a request to reset the password for your account. If you made this request, please click the following button:\n"
						+ "\n"
						+ "Reset Password\n"
						+ "\n"
						+ "Or\n"
						+ "\n"
						+ "Open the following link in your browser:\n"
						+ "\n"
						+ "https://secure.myntra.com/mailers/my/reset-password?key=____PTjBJOL8L6uFR_AxCG2GGflVlhZB8dvnU8V7UlMzhaDKaiggsfoKgcQJ43rNmCQJUkDs6UsgLI4ZSAveQWYT-Q5FVE1Z0DOE-6VMQV6UVkS8wLghYNDI_xd8LpuEJUF71lBfAQL7vB9a2y9zb3v2EuoNkTfNIUx6RQErw0aj7hs\n"
						+ "\n"
						+ "If you didn't raise this request, please ignore this email.\n"
						+ "\n"
						+ "Regards,\n"
						+ "Myntra Customer Support");
				//details.getMsgBody());
				mailMessage.setSubject("Your Myntra account password");//details.getSubject());
				javaMailSender.send(mailMessage);
				apiResponse.setStatus(true);
				apiResponse.setData(null);
				apiResponse.setMessage("Mail sent successfully");
			}
			}
		catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(false);
			apiResponse.setData(null);
			apiResponse.setMessage("invalid email");
		}
		return apiResponse;
	}
}
