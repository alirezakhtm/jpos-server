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
 * In order to simplify the TransactionManager configuration, we’ve added a GroupSelector:
 * This class is responsible to switch the participant base on MTI
 * The commit and abort methods have default implementations so they don’t
 * have to be called in situations where prepare returns the NO_JOIN modifier
 * The TransactionManager implementation drives the transaction by calling all of its participants' prepare
 * method and will call all of the participants' (commit|abort|prepare) method according to prepare return.
 * under certain recovery situations the TransactionManager may still call its commit or abort method,
 * so the participant developer should be prepared to receive a commit or abort call for an unknown transaction.
 * The code should check the long id and / or Serializable context in order to figure out what to do.
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class ParticipantSelector implements GroupSelector,Configurable{
    private Configuration configuration;
    @Override
    public void setConfiguration(Configuration configuration) throws ConfigurationException {
        this.configuration = configuration;
    }

    /**
     * method responsible to change the participant base on message MTI, on the select method
     * we get the request message from context and check the MTI and using those MTI to change the participant
     * @param l
     * @param serializable
     * @return
     */
    @Override
    public String select(long l, Serializable serializable) {
        Context ctx = (Context)serializable;
        IMessage txIsoDto = (IMessage)ctx.get(ContextConstant.REQUEST_DTO_KEY);
        switch (txIsoDto.getMTI()){
            case MTI_1100:
            case MTI_1110:
                return configuration.get("auth", "");
            case MTI_1200:
            case MTI_1210:
                return configuration.get("finreq", "");
            case MTI_1220:
            case MTI_1230:
                return configuration.get("finadv", "");
            case MTI_1420:
            case MTI_1430:
                return configuration.get("rev", "");
            case MTI_1804:
            case MTI_1814:
                return configuration.get("net", "");
        }
        return null;
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