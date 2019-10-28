package ir.navaco.mcb.credit.card.transaction.participant;

import ir.navaco.mcb.credit.card.parser.dto.IMessage;
import ir.navaco.mcb.credit.card.transaction.config.ContextConstant;
import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.transaction.Context;
import org.jpos.transaction.GroupSelector;

import java.io.Serializable;


/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class ParticipantDispatcher implements GroupSelector,Configurable {

    private Configuration configuration;

    @Override
    public void setConfiguration(Configuration cfg) throws ConfigurationException {
        this.configuration = cfg;
    }

    @Override
    public String select(long id, Serializable serializable) {
        Context context = (Context) serializable;
        IMessage iMessage = context.get(ContextConstant.REQUEST_DTO_KEY);
        switch (iMessage.getMTI()){
            case MTI_1100:
                return configuration.get("auth", "");
            case MTI_1200:
                return configuration.get("finreq", "");
            case MTI_1220:
                return configuration.get("finadv", "");
            case MTI_1420:
                return configuration.get("rev", "");
            case MTI_1804:
                return configuration.get("net", "");
        }
        return null;
    }

    @Override
    public int prepare(long id, Serializable context) {
        return PREPARED;
    }
}
