package com.SpringEmail.Entity;

import java.io.File;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.internet.MimeMessage;

@RestController
public class springEmail {
	
	@Autowired
	 private JavaMailSender mailSender;
	
	@RequestMapping("/send-email")
	public String sendEmail() {
		try {
			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message, true);
			SimpleMailMessage mailMessage=new SimpleMailMessage();
			mailMessage.setFrom("chethangr1411@gmail.com");
			mailMessage.setTo("chinnugowda1114@gmail.com");
			mailMessage.setSubject("OTP (One-Time Password)for login");
			 Random random=new Random();
			 String otp="";
			 for(int i=0;i<6;i++)
			 {
				 otp=otp+random.nextInt(0, 9);
			 }
			 mailMessage.setText("Hi please enter the below OTP to verify your password.Its valid for next 5 minutes"+ otp);
			 mailSender.send(mailMessage);
//			helper.setFrom("chethangr1411@gmail.com");
//			helper.setTo("chinnugowda1114@gmail.com");
//			helper.setSubject("simple text email from chethan");
//			helper.setText("Hi this is chethan here,how are doing today");
//			helper.addAttachment("BMTC BUS PASS",new File("C:\\Users\\Chethan G R\\OneDrive\\Documents\\BMTC BUS PASS.pdf"));
//			mailSender.send(message);
			return  "success";
		}
		catch (Exception e)
		{
			return e.getMessage();
		}
		
	}
	

}
