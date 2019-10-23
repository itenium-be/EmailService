package be.itenium.EmailService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendJsonWithPost {
    @Test
    public void testjsonPostToUrl() throws IOException {
        URL url = new URL("http://localhost:8080/sendgrid/test");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","application/json; utf-8");
        connection.setRequestProperty("Accept","application/json");
        connection.setDoOutput(true);
        try(OutputStream os = connection.getOutputStream())
        {
            byte[] input = Files.readAllBytes(Paths.get("src/test/testFiles/email.json"));
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }
}
