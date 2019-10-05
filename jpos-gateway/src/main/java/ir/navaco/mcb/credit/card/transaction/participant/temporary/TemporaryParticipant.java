package ir.navaco.mcb.credit.card.transaction.participant.temporary;

import ir.navaco.mcb.credit.card.config.HttpConfiguration;
import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import ir.navaco.mcb.credit.card.parser.UnpackISOMessage;
import ir.navaco.mcb.credit.card.parser.dto.IMessage;
import ir.navaco.mcb.credit.card.parser.dto.IResponseMessage;
import ir.navaco.mcb.credit.card.parser.dto.pooya.*;
import ir.navaco.mcb.credit.card.parser.enums.MessageType;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessStatusType;
import ir.navaco.mcb.credit.card.parser.packer.ISO93APooyaPackager;
import ir.navaco.mcb.credit.card.parser.transformer.MessageConverter;
import ir.navaco.mcb.credit.card.transaction.config.ContextConstant;
import ir.navaco.mcb.credit.card.transaction.participant.temporary.http.HttpParser;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOSource;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class TemporaryParticipant implements TransactionParticipant {

    private static final String TAG = "TemporaryParticipant";
    private JPOSLogger logger = new JPOSLogger(TAG);

    private HttpParser httpParser = new HttpParser();
    private HttpConfiguration httpConfiguration;

    private MessageConverter messageConverter = new MessageConverter();

    @Override
    public int prepare(long l, Serializable serializable) {
        Context context = (Context) serializable;
        IMessage iMessage = (IMessage) context.get(ContextConstant.REQUEST_DTO_KEY);
        MessageType messageType = iMessage.getMTI();
        try {
            httpConfiguration = new HttpConfiguration();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        switch (messageType.getCode()) {
            case 1100:
                try {
                    this.putResponseToSpace(
                            new Message1100(iMessage.getIsoMsg()),
                            ir.navaco.mcb.credit.card.parser.transformer.dto.Message1100.class,
                            ir.navaco.mcb.credit.card.parser.transformer.dto.Message1110.class,
                            Message1110.class,
                            httpConfiguration.getHttpCallUrlM1100(),
                            MessageType.MTI_1100,
                            MessageType.MTI_1110,
                            context);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                break;
            case 1200:
                try {
                    this.putResponseToSpace(
                            new Message1200(iMessage.getIsoMsg()),
                            ir.navaco.mcb.credit.card.parser.transformer.dto.Message1200.class,
                            ir.navaco.mcb.credit.card.parser.transformer.dto.Message1210.class,
                            Message1210.class,
                            httpConfiguration.getHttpCallUrlM1200(),
                            MessageType.MTI_1200,
                            MessageType.MTI_1210,
                            context);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                break;
            case 1220:
                try {
                    this.putResponseToSpace(
                            new Message1220(iMessage.getIsoMsg()),
                            ir.navaco.mcb.credit.card.parser.transformer.dto.Message1220.class,
                            ir.navaco.mcb.credit.card.parser.transformer.dto.Message1230.class,
                            Message1220.class,
                            httpConfiguration.getHttpCallUrlM1220(),
                            MessageType.MTI_1220,
                            MessageType.MTI_1230,
                            context);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                break;
            case 1420:
                try {
                    this.putResponseToSpace(
                            new Message1420(iMessage.getIsoMsg()),
                            ir.navaco.mcb.credit.card.parser.transformer.dto.Message1420.class,
                            ir.navaco.mcb.credit.card.parser.transformer.dto.Message1430.class,
                            Message1430.class,
                            httpConfiguration.getHttpCallUrlM1420(),
                            MessageType.MTI_1420,
                            MessageType.MTI_1430,
                            context);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                break;
            case 1804:
                try {
                    ISOMsg isoMsg = (ISOMsg) context.get(ContextConstant.REQUEST_KEY);
                    ISOMsg isoRespMsg = (ISOMsg) isoMsg.clone();
                    isoRespMsg.setMTI("1814");
                    IResponseMessage respMsg = (IResponseMessage) UnpackISOMessage.parseISOMessage(isoRespMsg);
                    respMsg.setTXResponseCode(TxProcessStatusType.TX_SUCCESSFUL);
                    respMsg.packMessageInto();
                    context.put(ContextConstant.RESPONSE_KEY, respMsg);
                } catch (Exception e) {
                    e.printStackTrace();
                    return ABORTED;
                }
                break;
        }
        return PREPARED | NO_JOIN;
    }

    private <RQP, RQT, RST, RSP> void putResponseToSpace(
            RQP requestMessage_PooyaObject,
            Class<RQT> requestTransformerClass,
            Class<RST> responseTransformerClass,
            Class<RSP> responsePooyaClass,
            String url,
            MessageType inputMessageType,
            MessageType outputMessageType,
            Context context) throws Exception {
        RQT requestTransformerObject = messageConverter.convert(requestMessage_PooyaObject, requestTransformerClass, inputMessageType);
        RST responseTransformerObject = httpParser.parse(requestTransformerObject, url, responseTransformerClass);
        RSP responsePooyaObject = messageConverter.convert(responseTransformerObject, responsePooyaClass, outputMessageType);
        IResponseMessage responseMessage = (IResponseMessage) responsePooyaObject;
        responseMessage.setTXResponseCode(TxProcessStatusType.TX_SUCCESSFUL);
        responseMessage.packMessageInto();
        context.put(ContextConstant.RESPONSE_KEY, responseMessage);
    }
}
