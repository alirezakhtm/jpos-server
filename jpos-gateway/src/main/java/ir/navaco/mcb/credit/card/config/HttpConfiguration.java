package ir.navaco.mcb.credit.card.config;

import ir.navaco.mcb.credit.card.logger.JPOSLogger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class HttpConfiguration {

    private static final String TAG = "HttpConfiguration";
    private JPOSLogger logger = new JPOSLogger(TAG);

    private static String HTTP_CALL_URL_M1100 = null;
    private static String HTTP_CALL_URL_M1200 = null;
    private static String HTTP_CALL_URL_M1220 = null;
    private static String HTTP_CALL_URL_M1420 = null;
    private static String HTTP_CALL_URL_M1804 = null;
    private static String HTTP_CALL_URL_M1604 = null;

    public HttpConfiguration() throws IOException {
        if (HTTP_CALL_URL_M1100 == null){
//            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("http-configuration.properties");
            InputStream inputStream = new FileInputStream("http-configuration.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            logger.info("Fetching data for setting configuration of HTTP started.");
            HTTP_CALL_URL_M1100 = properties.getProperty("http.call.url.m1100");
            HTTP_CALL_URL_M1200 = properties.getProperty("http.call.url.m1200");
            HTTP_CALL_URL_M1220 = properties.getProperty("http.call.url.m1220");
            HTTP_CALL_URL_M1420 = properties.getProperty("http.call.url.m1420");
            HTTP_CALL_URL_M1804 = properties.getProperty("http.call.url.m1804");
            HTTP_CALL_URL_M1604 = properties.getProperty("http.call.url.m1604");
            logger.info("Fetching data for setting configuration finished successfully.");
        }
    }

    public String getHttpCallUrlM1100() {
        return HTTP_CALL_URL_M1100;
    }

    public String getHttpCallUrlM1200() {
        return HTTP_CALL_URL_M1200;
    }

    public String getHttpCallUrlM1220() {
        return HTTP_CALL_URL_M1220;
    }

    public String getHttpCallUrlM1420() {
        return HTTP_CALL_URL_M1420;
    }

    public String getHttpCallUrlM1804() {
        return HTTP_CALL_URL_M1804;
    }

    public String getHttpCallUrlM1604(){
        return HTTP_CALL_URL_M1604;
    }
}
