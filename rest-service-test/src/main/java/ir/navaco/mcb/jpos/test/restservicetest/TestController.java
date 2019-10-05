package ir.navaco.mcb.jpos.test.restservicetest;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.navaco.mcb.credit.card.parser.transformer.dto.Message1100;
import ir.navaco.mcb.credit.card.parser.transformer.dto.Message1110;
import org.jpos.iso.ISOMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {

    private static final String TAG = "TestController";
    private Logger logger = LoggerFactory.getLogger(TAG);

    @RequestMapping(method = RequestMethod.GET, value = "/echouser")
    public User echoUser(@RequestBody User user) {
        logger.info("Echo user function called.");
        user.setFirstName(user.getFirstName() + " - edited");
        user.setLastName(user.getLastName() + " - edited");
        return user;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getusersample")
    public User getUserSample(){
        logger.info("sample-user function called.");
        User user = new User();
        user.setFirstName("alireza");
        user.setLastName("khatami doost");
        return user;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/echouser-post")
    public User echoUserPost(@RequestBody User user) {
        logger.info("Echo user [POST] function called.");
        logger.info("[fname: " + user.getFirstName() + ", lname: " + user.getLastName() + "]");
        user.setFirstName(user.getFirstName() + " - edited");
        user.setLastName(user.getLastName() + " - edited");
        return user;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/message1100")
    public Message1110 getResponseToMessage1100(@RequestBody Message1100 message1100) throws Exception {
        logger.info("Message1100 received.");
//        ISOMsg isoMsg = message1100.getIsoMsg();
        Message1110 rsp = new Message1110();

        rsp.setPrimaryBinaryDesign(message1100.getPrimaryBinaryDesign());
        rsp.setSecondaryBinaryDesign(message1100.getSecondaryBinaryDesign());
        rsp.setSentDataToShetabDt(message1100.getSentDataToShetabDt());
        rsp.setTXId(message1100.getTXId());
        rsp.setTXDateTime(message1100.getTXDateTime());
        rsp.setMac(message1100.getMac());

        rsp.setAccountNo(message1100.getAccountNo());
        rsp.setTXProcessCode(message1100.getTXProcessCode());
        rsp.setRawTXProcessCode(message1100.getRawTXProcessCode());
//        rsp.setTXSettlementDate(message1100.getTXSettlementDate());
        rsp.setAcquireInstituteCode(message1100.getAcquireInstituteCode());
        rsp.setSenderInstituteCode(message1100.getSenderInstituteCode());
        rsp.setTXRefRecoverNo(message1100.getTXRefRecoverNo());
//        rsp.setTXApprovalCode(message1100.getTXApprovalCode());
//        rsp.setTXResponseCode(message1100.getTXResponseCode());
        rsp.setTXAcquirePosNumber(message1100.getTXAcquirePosNumber());
        rsp.setCardAcquireNumber(message1100.getCardAcquireNumber());
//        rsp.setResponseExtraData(message1100.getResponseExtraData());
//        rsp.setExtraAmount(message1100.getExtraAmount());
        rsp.setTXCoding(message1100.getTXCoding());
        rsp.setReceiverInstituteCode(message1100.getReceiverInstituteCode());



        return rsp;
    }

    private String jsonTest = "{\n" +
            "  \"primaryBinaryDesign\" : \"E234C50188E18000\",\n" +
            "  \"secondaryBinaryDesign\" : \"0000000004000000\",\n" +
            "  \"sentDataToShetabDt\" : 1568587992000,\n" +
            "  \"mac\" : null,\n" +
            "  \"accountNo\" : 1234567897456321,\n" +
            "  \"posInfo\" : \"210101213144\",\n" +
            "  \"functionCode\" : \"REMAIN_REQUEST\",\n" +
            "  \"acquireBusinessType\" : null,\n" +
            "  \"acquireInstituteCode\" : 603799,\n" +
            "  \"senderInstituteCode\" : 628023,\n" +
            "  \"cardAcquireNumber\" : \"   777777777600\",\n" +
            "  \"cardAcquireNameLocation\" : \"                             ????? ?????\",\n" +
            "  \"specialExtraData\" : null,\n" +
            "  \"receiverInstituteCode\" : null,\n" +
            "  \"mti\" : \"MTI_1100\",\n" +
            "  \"txprocessCode\" : \"PURCHASE\",\n" +
            "  \"txcoding\" : null,\n" +
            "  \"txrefRecoverNo\" : \"000000182869\",\n" +
            "  \"txacquirePosNumber\" : \"67777777\",\n" +
            "  \"txreceiveDateTime\" : 1568575800000,\n" +
            "  \"rawTXProcessCode\" : \"000000\",\n" +
            "  \"txdateTime\" : 1568587992000,\n" +
            "  \"txid\" : 808526\n" +
            "}";

    @RequestMapping(method = RequestMethod.POST, value = "/convert-json")
    public String jsonParser() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Message1110 message1110 = mapper.readValue(jsonTest, Message1110.class);
        logger.info("Convert Done Successfully.");
        return "OK";
    }
}
