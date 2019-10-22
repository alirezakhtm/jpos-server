package ir.navaco.mcb.credit.card.space;

import ir.navaco.mcb.credit.card.http.HttpParser;
import ir.navaco.mcb.credit.card.parser.dto.IResponseMessage;
import ir.navaco.mcb.credit.card.parser.enums.MessageType;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessStatusType;
import ir.navaco.mcb.credit.card.parser.transformer.MessageConverter;
import ir.navaco.mcb.credit.card.transaction.config.ContextConstant;
import org.jpos.transaction.Context;


/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class JPOSSpaceHandler {

    public static  <RQP, RQT, RST, RSP> void putResponseToSpace(
            RQP requestMessage_PooyaObject,
            Class<RQT> requestTransformerClass,
            Class<RST> responseTransformerClass,
            Class<RSP> responsePooyaClass,
            String url,
            MessageType inputMessageType,
            MessageType outputMessageType,
            Context context) throws Exception {
        MessageConverter messageConverter = new MessageConverter();
        HttpParser httpParser = new HttpParser();
        RQT requestTransformerObject = messageConverter.convert(requestMessage_PooyaObject, requestTransformerClass, inputMessageType);
        RST responseTransformerObject = httpParser.parse(requestTransformerObject, url, responseTransformerClass);
        RSP responsePooyaObject = messageConverter.convert(responseTransformerObject, responsePooyaClass, outputMessageType);
        IResponseMessage responseMessage = (IResponseMessage) responsePooyaObject;
        responseMessage.setTXResponseCode(TxProcessStatusType.TX_SUCCESSFUL);
        responseMessage.packMessageInto();
        context.put(ContextConstant.RESPONSE_KEY, responseMessage);
    }

}
