package ir.navaco.mcb.credit.card.transaction.participant.firewall;

import ir.navaco.mcb.credit.card.database.HandleDB;
import ir.navaco.mcb.credit.card.general.CommonFunction;
import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessCodeType;
import org.jpos.transaction.TransactionParticipant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public abstract class FirewallParticipant implements TransactionParticipant {

    /**
     * Initial parameters thar must be set before logic started.
     */
    protected String TAG;
    protected JPOSLogger logger;

    protected int MTI;

    protected static List<String> lstValidityProcessCode = null;
    protected String[] strValidProcessCode = null;

    protected HandleDB handleDB = new HandleDB();

    /**
     * this parameter required for checking policies, this parameter must be set in child prepare method.
     */
    protected TxProcessCodeType processCodeType = null;

    /**
     * Init() method must be called in child's constructor
     * */
    protected void init() {
        this.strValidProcessCode = handleDB.getAllPolicy().keySet().contains(MTI) ?
                handleDB.getAllPolicy().get(MTI).getProcessCode() : null;
        if (lstValidityProcessCode == null) {
            logger = new JPOSLogger(TAG);
            if(strValidProcessCode != null)
                lstValidityProcessCode = Arrays.asList(strValidProcessCode);
            else
                lstValidityProcessCode = new ArrayList<>();
        }
    }

    @Override
    public int prepare(long id, Serializable serializable) {
        if (!CommonFunction.filterMessage(processCodeType, lstValidityProcessCode)) {
            return ABORTED;
        }
        return PREPARED | NO_JOIN;
    }
}
