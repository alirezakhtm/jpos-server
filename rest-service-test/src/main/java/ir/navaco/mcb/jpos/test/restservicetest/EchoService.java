package ir.navaco.mcb.jpos.test.restservicetest;

import ir.navaco.mcb.credit.card.parser.enums.TxProcessStatusType;
import ir.navaco.mcb.credit.card.parser.transformer.dto.*;
import org.springframework.stereotype.Service;

@Service
public class EchoService implements EchoServiceAPI{

    @Override
    public Message1110 echoResponse1100(Message1100 message1100) {
        Message1110 message1110 = new Message1110();
        message1110.setPrimaryBinaryDesign(message1100.getPrimaryBinaryDesign());
        message1110.setSecondaryBinaryDesign(message1100.getSecondaryBinaryDesign());
        message1110.setSentDataToShetabDt(message1100.getSentDataToShetabDt());
        message1110.setTXId(message1100.getTXId());
        message1110.setTXDateTime(message1100.getTXDateTime());
        message1110.setMac(message1100.getMac());

        message1110.setAccountNo(message1100.getAccountNo());
        message1110.setTXProcessCode(message1100.getTXProcessCode());
        message1110.setRawTXProcessCode(message1100.getRawTXProcessCode());
        //message1110.setTXSettlementDate(message1100.getTXSettlementDate()); //bit 15 not exist in pooya at all which is mandatory according to shetab docs
        message1110.setAcquireInstituteCode(message1100.getAcquireInstituteCode());
        message1110.setSenderInstituteCode(message1100.getSenderInstituteCode());
        message1110.setTXRefRecoverNo(message1100.getTXRefRecoverNo());
        message1110.setTXApprovalCode("000000");
        message1110.setTXResponseCode(TxProcessStatusType.TX_SUCCESSFUL);
        message1110.setTXAcquirePosNumber(message1100.getTXAcquirePosNumber());
        message1110.setCardAcquireNumber(message1100.getCardAcquireNumber());
//        message1110.setResponseExtraData(message1100.getResponseExtraData());
        message1110.setExtraAmount("0005364C0000011000000009364C000001100000");
        message1110.setTXCoding(message1100.getTXCoding());
        message1110.setReceiverInstituteCode(message1100.getReceiverInstituteCode());
        return message1110;
    }

    @Override
    public Message1210 echoResponse1200(Message1200 message1200){
        Message1210 message1210 = new Message1210();

        message1210.setPrimaryBinaryDesign(message1200.getPrimaryBinaryDesign());
        message1210.setSecondaryBinaryDesign(message1200.getSecondaryBinaryDesign());
        message1210.setSentDataToShetabDt(message1200.getSentDataToShetabDt());
        message1210.setTXId(message1200.getTXId());
        message1210.setTXDateTime(message1200.getTXDateTime());
        message1210.setMac(message1200.getMac());

        message1210.setAccountNo(message1200.getAccountNo());
        message1210.setTXProcessCode(message1200.getTXProcessCode());
        message1210.setRawTXProcessCode(message1200.getRawTXProcessCode());
        message1210.setTXAmountAcquire(message1200.getTXAmountAcquire());
        message1210.setDateExpiration(message1200.getDateExpiration());
        //message1210.setTXSettlementDate(message1200.getTXSettlementDate()); bit 15
        message1210.setTXReceiveDateTime(message1200.getTXReceiveDateTime());
        message1210.setMerchantType(message1200.getMerchantType());
        message1210.setPosInfo(message1200.getPosInfo());
        message1210.setFunctionCode(message1200.getFunctionCode());
        message1210.setAcquireInstituteCode(message1200.getAcquireInstituteCode());
        message1210.setSenderInstituteCode(message1200.getSenderInstituteCode());
        message1210.setTrack2Data(message1200.getTrack2Data());
        message1210.setTXRefRecoverNo(message1200.getTXRefRecoverNo());
        message1210.setTXApprovalCode("000000");
        message1210.setTXResponseCode(TxProcessStatusType.TX_SUCCESSFUL);
        message1210.setTXAcquirePosNumber(message1200.getTXAcquirePosNumber());
        message1210.setCardAcquireNumber(message1200.getCardAcquireNumber());
        message1210.setCardAcquireNameLocation(message1200.getCardAcquireNameLocation());
        //message1210.setResponseExtraData(message1200.getResponseExtraData());
        message1210.setAccountIdentification(message1200.getAccountIdentification());
//        message1210.setAdditionalData(message1200.getAdditionalData());
        message1210.setTXCurrency(message1200.getTXCurrency());
        message1210.setExtraAmount("0005364C0000011000000009364C000001100000");
        message1210.setTXCoding(message1200.getTXCoding());
       //message1210.setReceiverInstituteCode(message1200.getReceiverInstituteCode()); //not exist in pooya

        return message1210;
    }

    @Override
    public Message1230 echoResponse1220(Message1220 message1220) {
        Message1230 message1230 = new Message1230();
        message1230.setPrimaryBinaryDesign(message1220.getPrimaryBinaryDesign());
        message1230.setSecondaryBinaryDesign(message1220.getSecondaryBinaryDesign());
        message1230.setSentDataToShetabDt(message1220.getSentDataToShetabDt());
        message1230.setTXId(message1220.getTXId());
        message1230.setTXDateTime(message1220.getTXDateTime());
        message1230.setMac(message1220.getMac());

        message1230.setAccountNo(message1220.getAccountNo());
        message1230.setTXProcessCode(message1220.getTXProcessCode());
        message1230.setRawTXProcessCode(message1220.getRawTXProcessCode());
        message1230.setTXAmountAcquire(message1220.getTXAmountAcquire());
        //message1230.setTXSettlementDate(message1220.getTXSettlementDate()); bit 15
        message1230.setTXReceiveDateTime(message1220.getTXReceiveDateTime());
        message1230.setPosInfo(message1220.getPosInfo());
        message1230.setFunctionCode(message1220.getFunctionCode());
        message1230.setAcquireInstituteCode(message1220.getAcquireInstituteCode());
        message1230.setSenderInstituteCode(message1220.getSenderInstituteCode());
        message1230.setTXRefRecoverNo(message1220.getTXRefRecoverNo());
        message1230.setTXApprovalCode("000000");
        message1230.setTXResponseCode(TxProcessStatusType.TX_SUCCESSFUL);
        message1230.setTXAcquirePosNumber(message1220.getTXAcquirePosNumber());
        message1230.setCardAcquireNumber(message1220.getCardAcquireNumber());
//        message1230.setAdditionalData(message1220.getAdditionalData());
        message1230.setTXCurrency(message1220.getTXCurrency());
        message1230.setExtraAmount("0005364C0000011000000009364C000001100000");
        message1230.setOriginalTxData(message1220.getOriginalTxData());
        message1230.setTXCoding(message1220.getTXCoding());
        //message1230.setReceiverInstituteCode(message1220.getReceiverInstituteCode());
        message1230.setAccountIdentification(message1220.getAccountIdentification());
        return message1230;
    }

    @Override
    public Message1430 echoResponse1420(Message1420 message1420) {
        Message1430 message1430 = new Message1430();
        message1430.setPrimaryBinaryDesign(message1420.getPrimaryBinaryDesign());
        message1430.setSecondaryBinaryDesign(message1420.getSecondaryBinaryDesign());
        message1430.setSentDataToShetabDt(message1420.getSentDataToShetabDt());
        message1430.setTXId(message1420.getTXId());
        message1430.setTXDateTime(message1420.getTXDateTime());
        message1430.setMac(message1420.getMac());
                  
        message1430.setAccountNo(message1420.getAccountNo());
        message1430.setOriginalTxData(message1420.getOriginalTxData());
        message1430.setTXProcessCode(message1420.getTXProcessCode());
        message1430.setTXAmountAcquire(message1420.getTXAmountAcquire());
        //message1430.setTXSettlementDate(message1420.getTXSettlementDate()); bit 15
        message1430.setMerchantType(message1420.getMerchantType());
        message1430.setFunctionCode(message1420.getFunctionCode());
        message1430.setReasonCode(message1420.getReasonCode());
        message1430.setAcquireInstituteCode(message1420.getAcquireInstituteCode());
        message1430.setSenderInstituteCode(message1420.getSenderInstituteCode());
        message1430.setTXResponseCode(TxProcessStatusType.TX_SUCCESSFUL);
        message1430.setRawTXProcessCode(message1420.getRawTXProcessCode());
        message1430.setDateExpiration(message1420.getDateExpiration());
        message1430.setPosInfo(message1420.getPosInfo());
        message1430.setTrack2Data(message1420.getTrack2Data());
        message1430.setTXRefRecoverNo(message1420.getTXRefRecoverNo());
        message1430.setTXApprovalCode(message1420.getTXApprovalCode());
        message1430.setTXAcquirePosNumber(message1420.getTXAcquirePosNumber());
        message1430.setCardAcquireNumber(message1420.getCardAcquireNumber());
        message1430.setCardAcquireNameLocation(message1420.getCardAcquireNameLocation());
        message1430.setTXCurrency(message1420.getTXCurrency());
        message1430.setTXCoding(message1420.getTXCoding());
//        message1430.setReceiverInstituteCode(message1420.getReceiverInstituteCode());
        message1430.setAccountIdentification(message1420.getAccountIdentification());
        return message1430;
    }

    @Override
    public Message1614 echoResponse1604(Message1604 message1604) {
        Message1614 message1614 = new Message1614();
        message1614.setPrimaryBinaryDesign(message1604.getPrimaryBinaryDesign());
        message1614.setSecondaryBinaryDesign(message1604.getSecondaryBinaryDesign());
        message1614.setSentDataToShetabDt(message1604.getSentDataToShetabDt());
        message1614.setTXId(message1604.getTXId());
        message1614.setTXDateTime(message1604.getTXDateTime());
        message1614.setMac(message1604.getMac());

        message1614.setAccountNo(message1604.getAccountNo());
        message1614.setTXProcessCode(message1604.getTXProcessCode());
        message1614.setRawTXProcessCode(message1604.getRawTXProcessCode());
        //message1614.setTXSettlementDate(message1604.getTXSettlementDate()); bit 15
        message1614.setAcquireInstituteCode(message1604.getAcquireInstituteCode());
        message1614.setSenderInstituteCode(message1604.getSenderInstituteCode());
        message1614.setTXRefRecoverNo(message1604.getTXRefRecoverNo());
        message1614.setTXApprovalCode("000000");
        message1614.setTXResponseCode(TxProcessStatusType.TX_SUCCESSFUL);
        message1614.setTXAcquirePosNumber(message1604.getTXAcquirePosNumber());
        message1614.setCardAcquireNumber(message1604.getCardAcquireNumber());
        //message1614.setResponseExtraData(message1604.getResponseExtraData());
        message1614.setExtraAmount("0005364C0000011000000009364C000001100000");
        message1614.setTXCoding(message1604.getTXCoding());
        message1614.setReceiverInstituteCode(message1604.getReceiverInstituteCode());
        return message1614;
    }

}
