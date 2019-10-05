package ir.navaco.mcb.jpos.camel;

import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class CreateUserProcessor implements Processor {

    private static final String TAG = "CreateUserProcessor";
    private JPOSLogger logger = new JPOSLogger(TAG);

    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info(exchange.getIn().getBody(String.class));
        User user = new User();
        user.setFirstName("alireza");
        user.setLastName("khatami doost");
        exchange.getIn().setBody(user);
    }
}
