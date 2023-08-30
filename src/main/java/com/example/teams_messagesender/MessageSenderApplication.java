package com.example.teams_messagesender;

import com.example.teams_messagesender.teamsWebhook.TeamsWebhookService;
import com.example.teams_messagesender.teamsWebhook.model.TeamsMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class MessageSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageSenderApplication.class, args);


		 //---------------------------1. Example usage of sending a simple email
		/*ConfigurableApplicationContext context = SpringApplication.run(MessageSenderApplication.class, args);
		EmailService emailService = context.getBean(EmailService.class);


		BasicEmail newEmail = new BasicEmail();
		newEmail.setTo(new String[]{"selina.gramadova@egt-digital.com"});
		newEmail.setSubject("IMPORTANT BUG!!!111");
		newEmail.setText("FIX ASAP >:(((  - BIG MONEY CEO");

		try {
			emailService.sendEmail(newEmail);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		context.close();*/

		//-----------------------2. Example usage of sending a message to a webhook in a teams channel

		/*ConfigurableApplicationContext context = SpringApplication.run(MessageSenderApplication.class, args);
		TeamsWebhookService webhookService = context.getBean(TeamsWebhookService.class);

		final String apiUrl = "https://casinosolutioninteractive.webhook.office.com/webhookb2/828ae674-f70a-4992-baaa-787ed533b464@440eae1c-3369-4397-a12b-1fd4e9b627f9/IncomingWebhook/059d23e5b71640eb94b5311905ba123d/62058810-8a08-459e-a39b-78d828eda230";

		TeamsMessage simpleMessage = new TeamsMessage();
		simpleMessage.setTitle("Paypal");
		simpleMessage.setText("Paypal me 50000$ for illegal activities.");
		System.out.println( simpleMessage );
		System.out.println(  webhookService.sendToWebhook(apiUrl, simpleMessage) );

		context.close();*/
	}

}
