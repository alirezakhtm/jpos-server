package ir.navaco.mcb.credit.card.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class Q2ServerConfiguration {

    private static String DEPLOY_DIRECTORY = null;

    public Q2ServerConfiguration() throws IOException {
        if(DEPLOY_DIRECTORY == null){
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("q2server-configuration.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            DEPLOY_DIRECTORY = properties.getProperty("q2.server.deploy.directory");
            DEPLOY_DIRECTORY = new File(getClass().getClassLoader().getResource("META-INF/transactionConfig").getFile()).getPath();
        }
    }

    public String getDeployDirectory() {
        return DEPLOY_DIRECTORY;
    }
}
