package ir.navaco.mcb.credit.card.transaction.participant;

import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import ir.navaco.mcb.credit.card.parser.dto.IResponseMessage;
import ir.navaco.mcb.credit.card.transaction.config.ContextConstant;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOSource;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class SenderResponseParticipant implements TransactionParticipant {

    private static final String TAG = "TemporarySenderResponse";
    private JPOSLogger logger = new JPOSLogger(TAG);

    @Override
    public int prepare(long l, Serializable serializable) {
        logger.info("Fetching response from jpos space to send it.");
        Context context = (Context) serializable;
        ISOSource isoSource = context.get(ContextConstant.SOURCE_KEY);
        IResponseMessage isoMsgRes = (IResponseMessage) context.get(ContextConstant.RESPONSE_KEY);
        ISOMsg msgRsp = isoMsgRes.getIsoMsg();
        try {
            isoSource.send(msgRsp);
            logger.info("Sending message done successfully.");
        } catch (IOException | ISOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return ABORTED;
    }
}
