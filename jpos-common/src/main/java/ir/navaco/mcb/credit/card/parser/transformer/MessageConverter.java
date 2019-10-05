package ir.navaco.mcb.credit.card.parser.transformer;

import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1100;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1200;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1220;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1420;
import ir.navaco.mcb.credit.card.parser.enums.MessageType;
import ir.navaco.mcb.credit.card.parser.transformer.dto.Message1110;
import ir.navaco.mcb.credit.card.parser.transformer.dto.Message1210;
import ir.navaco.mcb.credit.card.parser.transformer.dto.Message1230;
import ir.navaco.mcb.credit.card.parser.transformer.dto.Message1430;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import java.util.Date;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class MessageConverter {
    public <T, P> P convert(T messageInput, Class<P> pClass, MessageType messageType) throws ISOException {
        switch (messageType) {
            case MTI_1100:
                if (pClass.equals(ir.navaco.mcb.credit.card.parser.transformer.dto.Message1100.class)) {
                    Message1100 message1100 = (Message1100) messageInput;
                    ir.navaco.mcb.credit.card.parser.transformer.dto.Message1100 message1100_target =
                            new ir.navaco.mcb.credit.card.parser.transformer.dto.Message1100();
                    message1100_target.setAccountNo(message1100.getAccountNo());
                    message1100_target.setAcquireBusinessType(message1100.getAcquireBusinessType());
                    message1100_target.setAcquireInstituteCode(message1100.getAcquireInstituteCode());
                    message1100_target.setCardAcquireNameLocation(message1100.getCardAcquireNameLocation());
                    message1100_target.setCardAcquireNumber(message1100.getCardAcquireNumber());
                    message1100_target.setFunctionCode(message1100.getFunctionCode());
                    message1100_target.setPosInfo(message1100.getPosInfo());
                    message1100_target.setRawTXProcessCode(message1100.getRawTXProcessCode());
                    message1100_target.setReceiverInstituteCode(message1100.getReceiverInstituteCode());
                    message1100_target.setSenderInstituteCode(message1100.getSenderInstituteCode());
                    message1100_target.setSpecialExtraData(message1100.getSpecialExtraData());
                    message1100_target.setTXAcquirePosNumber(message1100.getTXAcquirePosNumber());
                    message1100_target.setTXCoding(message1100.getTXCoding());
                    message1100_target.setTXProcessCode(message1100.getTXProcessCode());
                    message1100_target.setTXReceiveDateTime(message1100.getTXReceiveDateTime());
                    message1100_target.setTXRefRecoverNo(message1100.getTXRefRecoverNo());
                    message1100_target.setIsoMsgPack(message1100.getIsoMsg().pack());
                    return (P) message1100_target;
                } else return null;
            case MTI_1200:
                if (pClass.equals(ir.navaco.mcb.credit.card.parser.transformer.dto.Message1200.class)) {
                    Message1200 message1200 = (Message1200) messageInput;
                    ir.navaco.mcb.credit.card.parser.transformer.dto.Message1200 message1200_target =
                            new ir.navaco.mcb.credit.card.parser.transformer.dto.Message1200();

                    message1200_target.setPrimaryBinaryDesign(message1200.getPrimaryBinaryDesign());
                    message1200_target.setSecondaryBinaryDesign(message1200.getSecondaryBinaryDesign());
                    message1200_target.setSentDataToShetabDt(message1200.getSentDataToShetabDt());
                    message1200_target.setTXId(message1200.getTXId());
                    message1200_target.setTXDateTime(message1200.getTXDateTime());
                    message1200_target.setMac(message1200.getMac());
                    message1200_target.setIsoMsgPack(message1200.getIsoMsg().pack());

                    message1200_target.setAccountNo(message1200.getAccountNo());
                    message1200_target.setRawTXProcessCode(message1200.getRawTXProcessCode());
                    message1200_target.setTXProcessCode(message1200.getTXProcessCode());
                    message1200_target.setTXAmountAcquire(message1200.getTXAmountAcquire());
                    message1200_target.setDateExpiration(message1200.getDateExpiration());
                    message1200_target.setTXReceiveDateTime(message1200.getTXReceiveDateTime());
                    message1200_target.setMerchantType(message1200.getMerchantType());
                    message1200_target.setPosInfo(message1200.getPosInfo());
                    message1200_target.setFunctionCode(message1200.getFunctionCode());
                    message1200_target.setAcquireInstituteCode(message1200.getAcquireInstituteCode());
                    message1200_target.setSenderInstituteCode(message1200.getSenderInstituteCode());
                    message1200_target.setTrack2Data(message1200.getTrack2Data());
                    message1200_target.setTXRefRecoverNo(message1200.getTXRefRecoverNo());
                    message1200_target.setTXAcquirePosNumber(message1200.getTXAcquirePosNumber());
                    message1200_target.setCardAcquireNumber(message1200.getCardAcquireNumber());
                    message1200_target.setCardAcquireNameLocation(message1200.getCardAcquireNameLocation());
                    message1200_target.setAdditionalData(message1200.getAdditionalData());
                    message1200_target.setTXCurrency(message1200.getTXCurrency());
                    message1200_target.setTXCoding(message1200.getTXCoding());
                    message1200_target.setDataRecord(message1200.getDataRecord());
                    message1200_target.setAccountIdentification(message1200.getAccountIdentification());
                    message1200_target.setPooyaTxReserved(message1200.getPooyaTxReserved());
                    return (P) message1200_target;
                } else return null;
            case MTI_1220:
                if (pClass.equals(ir.navaco.mcb.credit.card.parser.transformer.dto.Message1220.class)) {
                    Message1220 message1220 = (Message1220) messageInput;

                    ir.navaco.mcb.credit.card.parser.transformer.dto.Message1220 message1220_target =
                            new ir.navaco.mcb.credit.card.parser.transformer.dto.Message1220();

                    message1220_target.setPrimaryBinaryDesign(message1220.getPrimaryBinaryDesign());
                    message1220_target.setSecondaryBinaryDesign(message1220.getSecondaryBinaryDesign());
                    message1220_target.setSentDataToShetabDt(message1220.getSentDataToShetabDt());
                    message1220_target.setTXId(message1220.getTXId());
                    message1220_target.setTXDateTime(message1220.getTXDateTime());
                    message1220_target.setMac(message1220.getMac());
                    message1220_target.setIsoMsgPack(message1220.getIsoMsg().pack());

                    message1220_target.setAccountNo(message1220.getAccountNo());
                    message1220_target.setTXProcessCode(message1220.getTXProcessCode());
                    message1220_target.setRawTXProcessCode(message1220.getRawTXProcessCode());
                    message1220_target.setTXAmountAcquire(message1220.getTXAmountAcquire());
                    message1220_target.setTXReceiveDateTime(message1220.getTXReceiveDateTime());
                    message1220_target.setPosInfo(message1220.getPosInfo());
                    message1220_target.setFunctionCode(message1220.getFunctionCode());
                    message1220_target.setAcquireInstituteCode(message1220.getAcquireInstituteCode());
                    message1220_target.setSenderInstituteCode(message1220.getSenderInstituteCode());
                    message1220_target.setTXRefRecoverNo(message1220.getTXRefRecoverNo());
                    message1220_target.setTXAcquirePosNumber(message1220.getTXAcquirePosNumber());
                    message1220_target.setCardAcquireNumber(message1220.getCardAcquireNumber());
                    message1220_target.setAdditionalData(message1220.getAdditionalData());
                    message1220_target.setTXCurrency(message1220.getTXCurrency());
                    message1220_target.setOriginalTxData(message1220.getOriginalTxData());
                    message1220_target.setTXCoding(message1220.getTXCoding());
                    message1220_target.setAccountIdentification(message1220.getAccountIdentification());

                    return (P) message1220_target;

                } else return null;
            case MTI_1420:
                if (pClass.equals(ir.navaco.mcb.credit.card.parser.transformer.dto.Message1420.class)) {
                    Message1420 message1420 = (Message1420) messageInput;

                    ir.navaco.mcb.credit.card.parser.transformer.dto.Message1420 message1420_target =
                            new ir.navaco.mcb.credit.card.parser.transformer.dto.Message1420();

                    message1420_target.setPrimaryBinaryDesign(message1420.getPrimaryBinaryDesign());
                    message1420_target.setSecondaryBinaryDesign(message1420.getSecondaryBinaryDesign());
                    message1420_target.setSentDataToShetabDt(message1420.getSentDataToShetabDt());
                    message1420_target.setTXId(message1420.getTXId());
                    message1420_target.setTXDateTime(message1420.getTXDateTime());
                    message1420_target.setMac(message1420.getMac());
                    message1420_target.setIsoMsgPack(message1420.getIsoMsg().pack());

                    message1420_target.setAccountNo(message1420.getAccountNo());
                    message1420_target.setTXProcessCode(message1420.getTXProcessCode());
                    message1420_target.setRawTXProcessCode(message1420.getRawTXProcessCode());
                    message1420_target.setTXAmountAcquire(message1420.getTXAmountAcquire());
                    message1420_target.setDateExpiration(message1420.getDateExpiration());
                    message1420_target.setTXReceiveDateTime(message1420.getTXReceiveDateTime());
                    message1420_target.setMerchantType(message1420.getMerchantType());
                    message1420_target.setPosInfo(message1420.getPosInfo());
                    message1420_target.setFunctionCode(message1420.getFunctionCode());
                    message1420_target.setReasonCode(message1420.getReasonCode());
                    message1420_target.setAcquireInstituteCode(message1420.getAcquireInstituteCode());
                    message1420_target.setSenderInstituteCode(message1420.getSenderInstituteCode());
                    message1420_target.setTrack2Data(message1420.getTrack2Data());
                    message1420_target.setTXRefRecoverNo(message1420.getTXRefRecoverNo());
                    message1420_target.setTXApprovalCode(message1420.getTXApprovalCode());
                    message1420_target.setTXAcquirePosNumber(message1420.getTXAcquirePosNumber());
                    message1420_target.setCardAcquireNumber(message1420.getCardAcquireNumber());
                    message1420_target.setCardAcquireNameLocation(message1420.getCardAcquireNameLocation());
                    message1420_target.setTXCurrency(message1420.getTXCurrency());
                    message1420_target.setOriginalTxData(message1420.getOriginalTxData());
                    message1420_target.setTXCoding(message1420.getTXCoding());
                    message1420_target.setAccountIdentification(message1420.getAccountIdentification());

                    return (P) message1420_target;
                } else return null;
                // convert all transformer dto to pooya dto
            case MTI_1110:
                if (pClass.equals(ir.navaco.mcb.credit.card.parser.dto.pooya.Message1110.class)) {
                    Message1110 message1110_trasformer = (Message1110) messageInput;

                    ir.navaco.mcb.credit.card.parser.dto.pooya.Message1110 message1110_pooya =
                            new ir.navaco.mcb.credit.card.parser.dto.pooya.Message1110();

                    message1110_pooya.setPrimaryBinaryDesign(message1110_trasformer.getPrimaryBinaryDesign());
                    message1110_pooya.setSecondaryBinaryDesign(message1110_trasformer.getSecondaryBinaryDesign());
                    message1110_pooya.setSentDataToShetabDt(message1110_trasformer.getSentDataToShetabDt());
                    message1110_pooya.setTXId(message1110_trasformer.getTXId());
                    message1110_pooya.setTXDateTime(message1110_trasformer.getTXDateTime());
                    message1110_pooya.setMac(message1110_trasformer.getMac());

                    message1110_pooya.setAccountNo(message1110_trasformer.getAccountNo());
                    message1110_pooya.setTXProcessCode(message1110_trasformer.getTXProcessCode());
                    message1110_pooya.setRawTXProcessCode(message1110_trasformer.getRawTXProcessCode());
                    message1110_pooya.setTXSettlementDate(message1110_trasformer.getTXSettlementDate());
                    message1110_pooya.setAcquireInstituteCode(message1110_trasformer.getAcquireInstituteCode());
                    message1110_pooya.setSenderInstituteCode(message1110_trasformer.getSenderInstituteCode());
                    message1110_pooya.setTXRefRecoverNo(message1110_trasformer.getTXRefRecoverNo());
                    message1110_pooya.setTXApprovalCode(message1110_trasformer.getTXApprovalCode());
                    message1110_pooya.setTXResponseCode(message1110_trasformer.getTXResponseCode());
                    message1110_pooya.setTXAcquirePosNumber(message1110_trasformer.getTXAcquirePosNumber());
                    message1110_pooya.setCardAcquireNumber(message1110_trasformer.getCardAcquireNumber());
                    message1110_pooya.setResponseExtraData(message1110_trasformer.getResponseExtraData());
                    message1110_pooya.setExtraAmount(message1110_trasformer.getExtraAmount());
                    message1110_pooya.setTXCoding(message1110_trasformer.getTXCoding());
                    message1110_pooya.setReceiverInstituteCode(message1110_trasformer.getReceiverInstituteCode());

                    return (P) message1110_pooya;

                } else return null;
            case MTI_1210:
                if (pClass.equals(ir.navaco.mcb.credit.card.parser.dto.pooya.Message1210.class)) {
                    Message1210 message1210_transformer = (Message1210) messageInput;

                    ir.navaco.mcb.credit.card.parser.dto.pooya.Message1210 message1210_pooya =
                            new ir.navaco.mcb.credit.card.parser.dto.pooya.Message1210();

                    message1210_pooya.setPrimaryBinaryDesign(message1210_transformer.getPrimaryBinaryDesign());
                    message1210_pooya.setSecondaryBinaryDesign(message1210_transformer.getSecondaryBinaryDesign());
                    message1210_pooya.setSentDataToShetabDt(message1210_transformer.getSentDataToShetabDt());
                    message1210_pooya.setTXId(message1210_transformer.getTXId());
                    message1210_pooya.setTXDateTime(message1210_transformer.getTXDateTime());
                    message1210_pooya.setMac(message1210_transformer.getMac());

                    message1210_pooya.setAccountNo(message1210_transformer.getAccountNo());
                    message1210_pooya.setTXProcessCode(message1210_transformer.getTXProcessCode());
                    message1210_pooya.setRawTXProcessCode(message1210_transformer.getRawTXProcessCode());
                    message1210_pooya.setTXAmountAcquire(message1210_transformer.getTXAmountAcquire());
                    message1210_pooya.setDateExpiration(message1210_transformer.getDateExpiration());
                    message1210_pooya.setTXSettlementDate(message1210_transformer.getTXSettlementDate());
                    message1210_pooya.setTXReceiveDateTime(message1210_transformer.getTXReceiveDateTime());
                    message1210_pooya.setMerchantType(message1210_transformer.getMerchantType());
                    message1210_pooya.setPosInfo(message1210_transformer.getPosInfo());
                    message1210_pooya.setFunctionCode(message1210_transformer.getFunctionCode());
                    message1210_pooya.setAcquireInstituteCode(message1210_transformer.getAcquireInstituteCode());
                    message1210_pooya.setSenderInstituteCode(message1210_transformer.getSenderInstituteCode());
                    message1210_pooya.setTrack2Data(message1210_transformer.getTrack2Data());
                    message1210_pooya.setTXRefRecoverNo(message1210_transformer.getTXRefRecoverNo());
                    message1210_pooya.setTXApprovalCode(message1210_transformer.getTXApprovalCode());
                    message1210_pooya.setTXResponseCode(message1210_transformer.getTXResponseCode());
                    message1210_pooya.setTXAcquirePosNumber(message1210_transformer.getTXAcquirePosNumber());
                    message1210_pooya.setCardAcquireNumber(message1210_transformer.getCardAcquireNumber());
                    message1210_pooya.setCardAcquireNameLocation(message1210_transformer.getCardAcquireNameLocation());
                    message1210_pooya.setResponseExtraData(message1210_transformer.getResponseExtraData());
                    message1210_pooya.setAccountIdentification(message1210_transformer.getAccountIdentification());
                    message1210_pooya.setAdditionalData(message1210_transformer.getAdditionalData());
                    message1210_pooya.setTXCurrency(message1210_transformer.getTXCurrency());
                    message1210_pooya.setExtraAmount(message1210_transformer.getExtraAmount());
                    message1210_pooya.setTXCoding(message1210_transformer.getTXCoding());
                    message1210_pooya.setReceiverInstituteCode(message1210_transformer.getReceiverInstituteCode());
                    return (P) message1210_pooya;
                } else return null;
            case MTI_1230:
                if (pClass.equals(ir.navaco.mcb.credit.card.parser.dto.pooya.Message1230.class)) {
                    Message1230 message1230_transformer = (Message1230) messageInput;

                    ir.navaco.mcb.credit.card.parser.dto.pooya.Message1230 message1230_pooya =
                            new ir.navaco.mcb.credit.card.parser.dto.pooya.Message1230();

                    message1230_pooya.setPrimaryBinaryDesign(message1230_transformer.getPrimaryBinaryDesign());
                    message1230_pooya.setSecondaryBinaryDesign(message1230_transformer.getSecondaryBinaryDesign());
                    message1230_pooya.setSentDataToShetabDt(message1230_transformer.getSentDataToShetabDt());
                    message1230_pooya.setTXId(message1230_transformer.getTXId());
                    message1230_pooya.setTXDateTime(message1230_transformer.getTXDateTime());
                    message1230_pooya.setMac(message1230_transformer.getMac());

                    message1230_pooya.setAccountNo(message1230_transformer.getAccountNo());
                    message1230_pooya.setTXProcessCode(message1230_transformer.getTXProcessCode());
                    message1230_pooya.setRawTXProcessCode(message1230_transformer.getRawTXProcessCode());
                    message1230_pooya.setTXAmountAcquire(message1230_transformer.getTXAmountAcquire());
                    message1230_pooya.setTXSettlementDate(message1230_transformer.getTXSettlementDate());
                    message1230_pooya.setTXReceiveDateTime(message1230_transformer.getTXReceiveDateTime());
                    message1230_pooya.setPosInfo(message1230_transformer.getPosInfo());
                    message1230_pooya.setFunctionCode(message1230_transformer.getFunctionCode());
                    message1230_pooya.setAcquireInstituteCode(message1230_transformer.getAcquireInstituteCode());
                    message1230_pooya.setSenderInstituteCode(message1230_transformer.getSenderInstituteCode());
                    message1230_pooya.setTXRefRecoverNo(message1230_transformer.getTXRefRecoverNo());
                    message1230_pooya.setTXApprovalCode(message1230_transformer.getTXApprovalCode());
                    message1230_pooya.setTXResponseCode(message1230_transformer.getTXResponseCode());
                    message1230_pooya.setTXAcquirePosNumber(message1230_transformer.getTXAcquirePosNumber());
                    message1230_pooya.setCardAcquireNumber(message1230_transformer.getCardAcquireNumber());
                    message1230_pooya.setAdditionalData(message1230_transformer.getAdditionalData());
                    message1230_pooya.setTXCurrency(message1230_transformer.getTXCurrency());
                    message1230_pooya.setExtraAmount(message1230_transformer.getExtraAmount());
                    message1230_pooya.setOriginalTxData(message1230_transformer.getOriginalTxData());
                    message1230_pooya.setTXCoding(message1230_transformer.getTXCoding());
                    message1230_pooya.setReceiverInstituteCode(message1230_transformer.getReceiverInstituteCode());
                    message1230_pooya.setAccountIdentification(message1230_transformer.getAccountIdentification());


                    return (P) message1230_pooya;
                } else return null;
            case MTI_1430:
                if (pClass.equals(ir.navaco.mcb.credit.card.parser.dto.pooya.Message1430.class)) {
                    Message1430 message1430_transformer = (Message1430) messageInput;

                    ir.navaco.mcb.credit.card.parser.dto.pooya.Message1430 message1430_pooya =
                            new ir.navaco.mcb.credit.card.parser.dto.pooya.Message1430();

                    message1430_pooya.setPrimaryBinaryDesign(message1430_transformer.getPrimaryBinaryDesign());
                    message1430_pooya.setSecondaryBinaryDesign(message1430_transformer.getSecondaryBinaryDesign());
                    message1430_pooya.setSentDataToShetabDt(message1430_transformer.getSentDataToShetabDt());
                    message1430_pooya.setTXId(message1430_transformer.getTXId());
                    message1430_pooya.setTXDateTime(message1430_transformer.getTXDateTime());
                    message1430_pooya.setMac(message1430_transformer.getMac());

                    message1430_pooya.setAccountNo(message1430_transformer.getAccountNo());
                    message1430_pooya.setOriginalTxData(message1430_transformer.getOriginalTxData());
                    message1430_pooya.setTXProcessCode(message1430_transformer.getTXProcessCode());
                    message1430_pooya.setTXAmountAcquire(message1430_transformer.getTXAmountAcquire());
                    message1430_pooya.setTXSettlementDate(message1430_transformer.getTXSettlementDate());
                    message1430_pooya.setMerchantType(message1430_transformer.getMerchantType());
                    message1430_pooya.setFunctionCode(message1430_transformer.getFunctionCode());
                    message1430_pooya.setReasonCode(message1430_transformer.getReasonCode());
                    message1430_pooya.setAcquireInstituteCode(message1430_transformer.getAcquireInstituteCode());
                    message1430_pooya.setSenderInstituteCode(message1430_transformer.getSenderInstituteCode());
                    message1430_pooya.setTXResponseCode(message1430_transformer.getTXResponseCode());
                    message1430_pooya.setRawTXProcessCode(message1430_transformer.getRawTXProcessCode());
                    message1430_pooya.setDateExpiration(message1430_transformer.getDateExpiration());
                    message1430_pooya.setPosInfo(message1430_transformer.getPosInfo());
                    message1430_pooya.setTrack2Data(message1430_transformer.getTrack2Data());
                    message1430_pooya.setTXRefRecoverNo(message1430_transformer.getTXRefRecoverNo());
                    message1430_pooya.setTXApprovalCode(message1430_transformer.getTXApprovalCode());
                    message1430_pooya.setTXAcquirePosNumber(message1430_transformer.getTXAcquirePosNumber());
                    message1430_pooya.setCardAcquireNumber(message1430_transformer.getCardAcquireNumber());
                    message1430_pooya.setCardAcquireNameLocation(message1430_transformer.getCardAcquireNameLocation());
                    message1430_pooya.setTXCurrency(message1430_transformer.getTXCurrency());
                    message1430_pooya.setTXCoding(message1430_transformer.getTXCoding());
                    message1430_pooya.setReceiverInstituteCode(message1430_transformer.getReceiverInstituteCode());
                    message1430_pooya.setAccountIdentification(message1430_transformer.getAccountIdentification());
                    return (P) message1430_pooya;
                } else return null;
            default:
                return null;
        }
    }
}
