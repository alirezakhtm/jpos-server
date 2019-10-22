package ir.navaco.mcb.credit.card.transaction.participant.firewall;

import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.transaction.GroupSelector;
import org.jpos.transaction.TransactionParticipant;

import java.io.Serializable;

public class FirewallParticipant implements GroupSelector, Configurable {
    @Override
    public void setConfiguration(Configuration cfg) throws ConfigurationException {

    }

    @Override
    public String select(long id, Serializable context) {
        return null;
    }

    @Override
    public int prepare(long id, Serializable context) {
        return 0;
    }
}
