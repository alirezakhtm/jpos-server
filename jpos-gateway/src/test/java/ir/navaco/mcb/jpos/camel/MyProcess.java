package ir.navaco.mcb.jpos.camel;

import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class MyProcess implements Processor {

    private static final String TAG = "MyProcess";
    private JPOSLogger logger = new JPOSLogger(TAG);
    private String arbitraryName;

    public MyProcess(String arbitraryTag){
        this.arbitraryName = arbitraryTag;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info(arbitraryName + " :::: " + exchange.getIn().getBody(String.class));
    }
}
