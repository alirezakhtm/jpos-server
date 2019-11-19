package ir.navaco.mcb.jpos.test.restservicetest;

import ir.navaco.mcb.credit.card.parser.transformer.dto.*;

public interface EchoServiceAPI {
    Message1110 echoResponse1100(Message1100 message1100);
    Message1210 echoResponse1200(Message1200 message1200);
    Message1230 echoResponse1220(Message1220 message1220);
    Message1430 echoResponse1420(Message1420 message1420);
    Message1614 echoResponse1604(Message1604 message1604);
}
