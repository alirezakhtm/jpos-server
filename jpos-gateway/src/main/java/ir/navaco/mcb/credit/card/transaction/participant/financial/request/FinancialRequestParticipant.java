package ir.navaco.mcb.credit.card.transaction.participant.financial.request;


import ir.navaco.mcb.credit.card.config.HttpConfiguration;
import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import ir.navaco.mcb.credit.card.parser.dto.IMessage;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1100;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1110;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1200;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1210;
import ir.navaco.mcb.credit.card.parser.enums.MessageType;
import ir.navaco.mcb.credit.card.space.JPOSSpaceHandler;
import ir.navaco.mcb.credit.card.transaction.config.ContextConstant;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class FinancialRequestParticipant implements TransactionParticipant {

    private static final String TAG = "FinancialRequestPartici";
    private JPOSLogger logger = new JPOSLogger(TAG);
    private HttpConfiguration httpConfiguration;

    @Override
    public int prepare(long id, Serializable serializable) {
        Context context = (Context) serializable;
        IMessage iMessage = (IMessage) context.get(ContextConstant.REQUEST_DTO_KEY);
        MessageType messageType = iMessage.getMTI();
        try {
            httpConfiguration = new HttpConfiguration();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        try {
            JPOSSpaceHandler.putResponseToSpace(
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
        return PREPARED | NO_JOIN;
    }
}
