package ir.navaco.mcb.credit.card.transaction.participant.authorisation;

import ir.navaco.mcb.credit.card.config.HttpConfiguration;
import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import ir.navaco.mcb.credit.card.parser.dto.IMessage;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1604;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1614;
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
public class AuthorisationParticipant2 implements TransactionParticipant {

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
                    new Message1604(iMessage.getIsoMsg()),
                    ir.navaco.mcb.credit.card.parser.transformer.dto.Message1604.class,
                    ir.navaco.mcb.credit.card.parser.transformer.dto.Message1614.class,
                    Message1614.class,
                    httpConfiguration.getHttpCallUrlM1604(),
                    MessageType.MTI_1604,
                    MessageType.MTI_1614,
                    context);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return PREPARED;
    }
}
