package ir.navaco.mcb.credit.card.config;

import ir.navaco.mcb.credit.card.logger.JPOSLogger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class CamelConfiguration {

    private static final String TAG = "CamelConfiguration";
    private JPOSLogger logger = new JPOSLogger(TAG);

    private static String DIRECTORY_INPUT_REQUEST = null;

    public CamelConfiguration() throws IOException {
        if(DIRECTORY_INPUT_REQUEST == null){
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("camel-configuration.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            logger.info("Fetching data for setting configuration of apache camel started.");
            DIRECTORY_INPUT_REQUEST = properties.getProperty("camel.directory.input.request");
        }
    }

    public String getDirectoryInputRequest(){
        return DIRECTORY_INPUT_REQUEST;
    }
}
