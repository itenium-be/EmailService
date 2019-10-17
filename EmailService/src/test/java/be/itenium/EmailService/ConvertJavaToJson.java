package be.itenium.EmailService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConvertJavaToJson
{
    @Test
    public void testConvertJavaObjectToJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> toMap = new HashMap<>();
        Map<String,String> ccMap = new HashMap<>();
        Map<String,String> bccMap = new HashMap<>();

        toMap.put("Thomas De Brauwer(GMAIL)", "thomasdebrauwer96@gmail.com");
        toMap.put("Thomas De Brauwer(MSN)", "thomasdebrauwer@msn.com");
        toMap.put("Thomas De Brauwer(ITENIUM)", "thomas.de.brauwer@itenium.be");

        ccMap.put("Thomas De Brauwer(GMAIL)", "thomasdebrauwer96@gmail.com");
        ccMap.put("Thomas De Brauwer(MSN)", "thomasdebrauwer@msn.com");
        ccMap.put("Thomas De Brauwer(ITENIUM)", "thomas.de.brauwer@itenium.be");

        bccMap.put("Thomas De Brauwer(GMAIL)", "thomasdebrauwer96@gmail.com");
        bccMap.put("Thomas De Brauwer(MSN)", "thomasdebrauwer@msn.com");
        bccMap.put("Thomas De Brauwer(ITENIUM)", "thomas.de.brauwer@itenium.be");

        File pdf = new File("");
        List<File> files = new ArrayList<>();
        files.add(pdf);


        Email email = new Email();
        email.setTo(toMap);
        email.setCc(ccMap);
        email.setBcc(bccMap);
        email.setSubject("Test");
        email.setHtml("");
        email.setAttachments(files);

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(email);
        System.out.println(json);
    }
}
