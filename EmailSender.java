import java.util.Properties;

import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;


public class EmailSender {
	public static void main(String[] args) {
		String host = "smtp.gmail.com";
		int port  = 587;
		String username = "jkiran989@gmail.com";
		String pwd = "Nariknhoj989@";
		String from = "";
		String to = "";
		String subject ="Hello";
		String text = "jskfh";
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(host);
		mailSender.setPort(port);

		mailSender.setUsername(username);
		mailSender.setPassword(pwd);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", pwd);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", true);
		
		Boolean isTls = false;
		if(isTls!=null && isTls == true) { 
			props.put("mail.smtp.starttls.enable", isTls);
			// Use the following if you need SSL
			props.put("mail.smtp.socketFactory.port", port);
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");
		}
		
		Boolean result = Boolean.FALSE;
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			//  message.setContent(text, "text/html; charset=utf-8");
			helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text, true);
			mailSender.send(message);
			result = Boolean.TRUE;
		} catch (SendFailedException e) {
			System.err.println(e);
		} catch (MessagingException e) {
			System.err.println(e);
		} catch(Exception e) {
			System.err.println(e);
		}

	}
}