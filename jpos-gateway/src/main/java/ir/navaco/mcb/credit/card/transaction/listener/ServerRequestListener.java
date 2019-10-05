package ir.navaco.mcb.credit.card.transaction.listener;

import ir.navaco.mcb.credit.card.transaction.config.ContextConstant;
import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.*;
import org.jpos.space.Space;
import org.jpos.space.SpaceFactory;
import org.jpos.transaction.Context;

/**
 * Iso server listener class
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class ServerRequestListener implements ISORequestListener,Configurable{

    private Configuration configuration;

    @Override
    public void setConfiguration(Configuration configuration) throws ConfigurationException {
        this.configuration = configuration;
    }

    @Override
    /**
     * we register request message, response message, and isoSource to the Context class
     * and we throw the Context class to Space
     */
    public boolean process(ISOSource isoSource, ISOMsg isoMsg) {
        /**
         * Basically the space in JPOS is like big room where you can throw object to those room, (wrote in linda language)
         * but to make sure you can pick up your object later you need give signature (key,value process like map) to those object
         */
        String spaceN = configuration.get("space");
        Long timeout = configuration.getLong("spaceTimeout");
        String queueN = configuration.get("queue");
        Context context = new Context();
        Space<String,Context> space = SpaceFactory.getSpace(spaceN);

        //can persist also (if configured to do so, using the persistent-space property) and send persist = true.
        context.put(ContextConstant.REQUEST_KEY,isoMsg);
        context.put(ContextConstant.SOURCE_KEY,isoSource);

        space.out(queueN,context,timeout);
        return false;
    }
}
