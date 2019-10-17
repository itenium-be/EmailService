package be.itenium.EmailService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConvertJsonToJava
{
    @Test
    public void testConvertJsonFileToJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Email email = mapper.readValue(new File("src/test/testFiles/email.json"),Email.class);

        assertEquals("Number of to's not correct",3,email.getTo().size());
        assertEquals("Number of cc's not correct",3,email.getCc().size());
        assertEquals("Number of bcc's not correct",3,email.getBcc().size());

        assertEquals("Subject is not correct","Itenium test mail",email.getSubject());
    }

    @Test
    public void testConvertJsonStringToJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Email emailObject = mapper.readValue(new File("src/test/testFiles/email.json"),Email.class);
        String jsonString = mapper.writeValueAsString(emailObject);
        System.out.println(jsonString);

        Email email  = mapper.readValue(jsonString,Email.class);

        assertEquals("Number of to's not correct",3,email.getTo().size());
        assertEquals("Number of cc's not correct",3,email.getCc().size());
        assertEquals("Number of bcc's not correct",3,email.getBcc().size());

        assertEquals("Subject is not correct","Itenium test mail",email.getSubject());
    }

}
