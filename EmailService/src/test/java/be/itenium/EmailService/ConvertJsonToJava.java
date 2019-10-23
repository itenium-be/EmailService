package be.itenium.EmailService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConvertJsonToJava
{
    @Test
    public void testConvertJsonFileToJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        IteniumEmail iteniumEmail = mapper.readValue(new File("src/test/testFiles/email.json"), IteniumEmail.class);

        assertEquals("Number of to's not correct",3, iteniumEmail.getTo().size());
        assertEquals("Number of cc's not correct",3, iteniumEmail.getCc().size());
        assertEquals("Number of bcc's not correct",3, iteniumEmail.getBcc().size());

        assertEquals("Subject is not correct","Itenium test mail", iteniumEmail.getSubject());
    }

    @Test
    public void testConvertJsonStringToJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        IteniumEmail iteniumEmailObject = mapper.readValue(new File("src/test/testFiles/email.json"), IteniumEmail.class);
        String jsonString = mapper.writeValueAsString(iteniumEmailObject);
        System.out.println(jsonString);

        IteniumEmail iteniumEmail = mapper.readValue(jsonString, IteniumEmail.class);

        assertEquals("Number of to's not correct",3, iteniumEmail.getTo().size());
        assertEquals("Number of cc's not correct",3, iteniumEmail.getCc().size());
        assertEquals("Number of bcc's not correct",3, iteniumEmail.getBcc().size());

        assertEquals("Subject is not correct","Itenium test mail", iteniumEmail.getSubject());
    }

}
