package ir.navaco.mcb.jpos.test.restservicetest;

import ir.navaco.mcb.credit.card.parser.transformer.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final String TAG = "TestController";
    private Logger logger = LoggerFactory.getLogger(TAG);

    @Autowired
    private EchoService echoService;

    @RequestMapping(method = RequestMethod.POST, value = "/message1100")
    public Message1110 getResponseToMessage1100(@RequestBody Message1100 message1100) {
        logger.info("Message1100 received.");
        return echoService.echoResponse1100(message1100);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/message1200")
    public Message1210 getResponseToMessage1200(@RequestBody Message1200 message1200) {
        logger.info("Message1210 received.");
        return echoService.echoResponse1200(message1200);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/message1220")
    public Message1230 getResponseToMessage1220(@RequestBody Message1220 message1220) {
        logger.info("Message1220 received.");
        return echoService.echoResponse1220(message1220);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/message1420")
    public Message1430 getResponseToMessage(@RequestBody Message1420 message1420) {
        logger.info("Message1420 received.");
        return echoService.echoResponse1420(message1420);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/message1604")
    public Message1614 getResponseToMessage1604(@RequestBody Message1604 message1604) {
        logger.info("Message1604 received.");
        return echoService.echoResponse1604(message1604);
    }

}
