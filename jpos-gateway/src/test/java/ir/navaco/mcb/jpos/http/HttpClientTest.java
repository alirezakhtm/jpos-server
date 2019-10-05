package ir.navaco.mcb.jpos.http;

import com.google.gson.GsonBuilder;
import ir.navaco.mcb.credit.card.transaction.participant.temporary.http.HttpParser;
import ir.navaco.mcb.jpos.camel.User;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

public class HttpClientTest {
    public static void main(String[] args) throws IOException {

        User user = new User();
        user.setFirstName("John");
        user.setLastName("Wood");
        String jsonUser = new GsonBuilder().create().toJson(user, User.class);

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://localhost:9090/echouser-post");
        HttpEntity stringEntity = new StringEntity(jsonUser, ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);

        InputStream inputStream = response.getEntity().getContent();
        String responseBody = IOUtils.toString(inputStream, "UTF-8");
        System.out.println(responseBody);

        User userResponse = new GsonBuilder().create().fromJson(responseBody, User.class);
        System.out.println(String.format("[fname: %s, lname: %s]", userResponse.getFirstName(), userResponse.getLastName()));

        // ---------------------------------------

        HttpParser httpParser = new HttpParser();
        user.setFirstName("Tom");
        user.setLastName("Yummi");
        User user2 = httpParser.parse(user, "http://localhost:9090/echouser-post", User.class);
        System.out.println(String.format("[fname: %s, lname: %s]", user2.getFirstName(), user2.getLastName()));

    }
}
