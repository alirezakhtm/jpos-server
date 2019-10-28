package ir.navaco.mcb.credit.card.transaction.participant;

import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import ir.navaco.mcb.credit.card.parser.UnpackISOMessage;
import ir.navaco.mcb.credit.card.parser.dto.IResponseMessage;
import ir.navaco.mcb.credit.card.parser.dto.IResponseMessageFinAuthRev;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessStatusType;
import ir.navaco.mcb.credit.card.transaction.config.ContextConstant;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOSource;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;

import java.io.Serializable;


/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class SendResponseAbortedRequest implements AbortParticipant {

    private static final String TAG = "SendResponseAbortedRequest";
    private JPOSLogger logger = new JPOSLogger(TAG);

    @Override
    public int prepare(long id, Serializable context) {
        return 0;
    }

    @Override
    public int prepareForAbort(long id, Serializable serializable) {
        Context context = (Context) serializable;
        ISOMsg isoMsg = (ISOMsg) context.get(ContextConstant.REQUEST_KEY);
        ISOMsg isoResponseMsg = (ISOMsg) isoMsg.clone();
        try {
            IResponseMessageFinAuthRev respMsg =
                    (IResponseMessageFinAuthRev) UnpackISOMessage.parseISOMessage(isoResponseMsg);
            respMsg.setTXApprovalCode("000000");
            respMsg.setTXResponseCode(TxProcessStatusType.INVALID_MESSAGE);
            respMsg.packMessageInto();
            context.put(ContextConstant.RESPONSE_KEY, respMsg);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return ABORTED;
    }

    @Override
    public void commit(long id, Serializable context) {
        sendMessage((Context)context);
    }

    @Override
    public void abort(long id, Serializable context) {
        sendMessage((Context)context);
    }

    private void sendMessage(Context context){
        ISOSource source = (ISOSource)context.get(ContextConstant.SOURCE_KEY);
        IResponseMessage isoMsgResp = (IResponseMessage)context.get(ContextConstant.RESPONSE_KEY);
        try {
            ISOMsg msgResp = isoMsgResp.getIsoMsg();
            source.send(msgResp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
