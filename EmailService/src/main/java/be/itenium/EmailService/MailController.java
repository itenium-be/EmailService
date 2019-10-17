package be.itenium.EmailService;

import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.MailSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MailController
{
    @Autowired
    private SendGrid sendGrid;

    @Value("${templateId}")
    private String EMAIL_TEMPLATE_ID;

    @GetMapping("/sendgrid/test")
    public String sendEmailWithSendGrid(@RequestParam("msg") String message)
    {
        Email from = new Email("thomas.de.brauwer@itenium.be");
        Email to = new Email("thomasdebrauwer96@gmail.com");
        Email cc = new Email("thomasdebrauwer@msn.com");
        Email bcc = new Email("thomas.de.brauwer@itenium.be");
        Content content = new Content("text/html","content");

        Mail mail = new Mail(from, message, to,content);
        mail.setReplyTo(new Email("thomas.de.brauwer@itenium.be"));
        //mail.personalization.get(0).addSubstitution("-username-","Some blog user");
        mail.personalization.get(0).addCc(cc);
        mail.personalization.get(0).addBcc(bcc);
        mail.personalization.get(0).addDynamicTemplateData("[Sender_Name]","itenium");

        mail.setTemplateId(EMAIL_TEMPLATE_ID);
        MailSettings mailSettings = new MailSettings();
        Request request = new Request();
        Response response = null;

        try
        {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            response = sendGrid.api(request);

            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return "email was succesfully send";
    }

}
