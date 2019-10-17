package be.itenium.EmailService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
		//MailController mailController = new MailController();
		//System.out.println(mailController.sendEmailWithSendGrid("Message"));
	}

}
