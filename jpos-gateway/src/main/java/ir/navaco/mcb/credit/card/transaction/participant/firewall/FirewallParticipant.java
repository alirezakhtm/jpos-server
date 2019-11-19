package ir.navaco.mcb.credit.card.transaction.participant.firewall;

import ir.navaco.mcb.credit.card.database.HandleDB;
import ir.navaco.mcb.credit.card.database.dto.MessagePolicy;
import ir.navaco.mcb.credit.card.general.CommonFunction;
import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessCodeType;
import org.jpos.transaction.TransactionParticipant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        Map<Integer, MessagePolicy> mapPolicies = handleDB.getAllPolicy();
        this.strValidProcessCode = mapPolicies.keySet().contains(MTI) ?
                mapPolicies.get(MTI).getProcessCode() : null;
        //if (lstValidityProcessCode == null) {
            logger = new JPOSLogger(TAG);
            if(strValidProcessCode != null)
                lstValidityProcessCode = Arrays.asList(strValidProcessCode);
            else
                lstValidityProcessCode = new ArrayList<>();
        //}
    }

    @Override
    public int prepare(long id, Serializable serializable) {
        this.init();
        if (!CommonFunction.filterMessage(processCodeType, lstValidityProcessCode)) {
            logger.info("This request ABORTED because process code " + processCodeType.getCode() + " is not allowed");
            return ABORTED;
        }
        logger.info("This request with process code "
                + processCodeType.getCode() + " allowed according to policies for MTI " + this.MTI);
        return PREPARED | NO_JOIN;
    }
}
