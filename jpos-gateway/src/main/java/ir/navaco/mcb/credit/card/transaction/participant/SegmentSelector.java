package ir.navaco.mcb.credit.card.transaction.participant;

import ir.navaco.mcb.credit.card.parser.dto.IMessage;
import ir.navaco.mcb.credit.card.parser.enums.MessageType;
import ir.navaco.mcb.credit.card.transaction.config.ContextConstant;
import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.transaction.GroupSelector;

import java.io.Serializable;

/**
 * This class is responsible to switch the participant base on Account Type
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class SegmentSelector implements GroupSelector,Configurable{
    private Configuration configuration;
    @Override
    public void setConfiguration(Configuration configuration) throws ConfigurationException {
        this.configuration = configuration;
    }

    /**
     * method responsible to change the participant base on Account Type, on the select method
     *  ========= note: for now there is only one segment which is credit card ==========
     * @param serializable the context
     * @return participant group name
     */
    @Override
    public String select(long l, Serializable serializable) {
        Context ctx = (Context)serializable;
        IMessage txIsoDto = (IMessage)ctx.get(ContextConstant.REQUEST_DTO_KEY);
        //ISOMsg isoMsg = (ISOMsg)ctx.get(ContextConstant.REQUEST_KEY);

        //return participant group from xml configuration
        if (!txIsoDto.getMTI().equals(MessageType.MTI_1804))
            return configuration.get("creditCard", "");

        return "";
    }

    @Override
    /**
     * @return ABORTED(will call abort) | PREPARE (will call commit) | RETRY (will redo -> retry-timeout property)
     * @return PAUSE (an external thread calls resume in the transaction’s Context | Context’s Pausable interface timeout | TransactionManager’s pausetimeout property def:5min)
     * @return NO_JOIN (not required to call commit or abort) | READONLY (this participant has not modified any persistent information,  saving a snapshot of the context is not required)
     * @return FAIL (Handy constant equals to ABORTED | READONLY | NO_JOIN)
     */
    public int prepare(long l, Serializable serializable) {
        return PREPARED|ABORTED|NO_JOIN;
    }

    @Override
    public void commit(long l, Serializable serializable) {
    }

    @Override
    public void abort(long l, Serializable serializable) {
    }
}