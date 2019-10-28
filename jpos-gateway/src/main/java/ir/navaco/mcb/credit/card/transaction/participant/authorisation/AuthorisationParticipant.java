package ir.navaco.mcb.credit.card.transaction.participant.authorisation;

import ir.navaco.mcb.credit.card.config.HttpConfiguration;
import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import ir.navaco.mcb.credit.card.parser.dto.IMessage;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1100;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1110;
import ir.navaco.mcb.credit.card.parser.enums.MessageType;
import ir.navaco.mcb.credit.card.space.JPOSSpaceHandler;
import ir.navaco.mcb.credit.card.transaction.config.ContextConstant;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class AuthorisationParticipant implements TransactionParticipant {

    private static final String TAG = "AuthorisationParticipant";
    private JPOSLogger logger = new JPOSLogger(TAG);
    private HttpConfiguration httpConfiguration;

    @Override
    public int prepare(long id, Serializable serializable) {
        Context context = (Context)serializable;
        IMessage iMessage= (IMessage) context.get(ContextConstant.REQUEST_DTO_KEY);
        MessageType messageType = iMessage.getMTI();
        try {
            httpConfiguration = new HttpConfiguration();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        try {
            JPOSSpaceHandler.putResponseToSpace(
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
        return PREPARED;
    }
}
