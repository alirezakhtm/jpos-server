package ir.navaco.mcb.credit.card.transaction.participant.temporary.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class HttpParser {

    private Gson gson = new GsonBuilder().create();
    private ObjectMapper jsonMapper = new ObjectMapper();
    private static final String TAG = "HttpParser";
    private JPOSLogger logger = new JPOSLogger(TAG);

    public <T, P> P parse(T messageInput, String url, Class<P> pClass) throws IOException {
//        String jsonString = gson.toJson(messageInput, messageInput.getClass());

        String jsonString = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(messageInput);
        logger.info("Message converted to the json format.");
        logger.info("Message is ::: \n" + jsonString);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        logger.info("HTTP client has been created for connection.");
        HttpPost httpPost = new HttpPost(url);
        HttpEntity stringEntity = new StringEntity(jsonString, ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);
        logger.info("Message as POST method ready to send to the server :: " + url);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        Header[] headersResponse = response.getAllHeaders();
        Header[] headersRequest = httpPost.getAllHeaders();
        Arrays.stream(headersRequest).forEach(header -> logger.info("Header of Request ::: " + header.toString()));
        logger.info("======================================");
        Arrays.stream(headersResponse).forEach(header -> logger.info("Header of Response ::: " + header.toString()));
        logger.info("Message has been sent successfully to server.");
        InputStream inputStream = response.getEntity().getContent();
        String responseBody = IOUtils.toString(inputStream, "UTF-8");
        logger.info("Response from server has been received.");
//        P responseObject = gson.fromJson(responseBody, pClass);
        P responseObject = jsonMapper.readValue(responseBody, pClass);
        logger.info("Response ::: " + responseBody);
        return responseObject;
    }
}
