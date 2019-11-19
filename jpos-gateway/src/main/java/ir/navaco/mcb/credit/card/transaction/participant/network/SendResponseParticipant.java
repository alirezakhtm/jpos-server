package ir.navaco.mcb.credit.card.transaction.participant.network;

import ir.navaco.mcb.credit.card.parser.UnpackISOMessage;
import ir.navaco.mcb.credit.card.parser.dto.IResponseMessage;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessStatusType;
import ir.navaco.mcb.credit.card.transaction.config.ContextConstant;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOSource;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;

import java.io.Serializable;

/**
 * This class is used to send responses to a given source.
 *
 * ITS A TEMP CLASS to response 1804 requests and send back a success response
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class SendResponseParticipant implements TransactionParticipant {

    @Override
    public int prepare(long l, Serializable serializable) {
        /*Context ctx = (Context)serializable;
        ISOMsg isoMsg = (ISOMsg)ctx.get(ContextConstant.REQUEST_KEY);
        ISOMsg isoRespMsg = (ISOMsg) isoMsg.clone();
        try {
            isoRespMsg.setMTI("1814");
            IResponseMessage respMsg = (IResponseMessage) UnpackISOMessage.parseISOMessage(isoRespMsg);
            respMsg.setTXResponseCode(TxProcessStatusType.TX_SUCCESSFUL);
            respMsg.packMessageInto();
            ctx.put(ContextConstant.RESPONSE_KEY, respMsg);
            return PREPARED;
        } catch (Exception e) {
            e.printStackTrace();
            return ABORTED;
        }*/
        return PREPARED;
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

    @Override
    public void commit(long l, Serializable serializable) {
        sendMessage((Context)serializable);
    }

    @Override
    public void abort(long l, Serializable serializable) { }
}