package ir.navaco.mcb.credit.card.transaction.participant;

import ir.navaco.mcb.credit.card.parser.UnpackISOMessage;
import ir.navaco.mcb.credit.card.parser.dto.IMessage;
import ir.navaco.mcb.credit.card.transaction.config.ContextConstant;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;

import java.io.Serializable;

/**
 * This participant add a DTO mirror of IsoMsg to the context.
 * But if the message couldn't be parsed it would abort it.
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class ParserParticipant implements TransactionParticipant{
    @Override
    public int prepare(long l, Serializable serializable) {
        Context ctx = (Context)serializable;
        ISOMsg isopMsg = (ISOMsg)ctx.get(ContextConstant.REQUEST_KEY);
        try {
            IMessage isoMsgDto = UnpackISOMessage.parseISOMessage(isopMsg);
            ctx.put(ContextConstant.REQUEST_DTO_KEY,isoMsgDto);
        } catch (Exception e) {
            return ABORTED;
        }

        return PREPARED|NO_JOIN;
    }

    @Override
    public void commit(long l, Serializable serializable) {

    }

    @Override
    public void abort(long l, Serializable serializable) {

    }
}