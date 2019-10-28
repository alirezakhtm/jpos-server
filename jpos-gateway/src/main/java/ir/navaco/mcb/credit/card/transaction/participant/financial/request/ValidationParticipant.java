package ir.navaco.mcb.credit.card.transaction.participant.financial.request;

import ir.navaco.mcb.credit.card.general.CommonFunction;
import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import ir.navaco.mcb.credit.card.parser.dto.IMessage;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1100;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1200;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessCodeType;
import ir.navaco.mcb.credit.card.transaction.config.ContextConstant;
import ir.navaco.mcb.credit.card.transaction.participant.firewall.FirewallParticipant;
import org.apache.commons.io.input.BOMInputStream;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * The participant to validate 1200,1210 messages type
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class ValidationParticipant extends FirewallParticipant {

    public ValidationParticipant(){
        this.TAG = "ValidationParticipant - 1200";
        this.MTI = 1200;
        this.init();
    }

    @Override
    public int prepare(long id, Serializable serializable) {
        Context context = (Context)serializable;
        IMessage iMessage = (IMessage) context.get(ContextConstant.REQUEST_DTO_KEY);

        try {
            Message1200 message1200 = new Message1200(iMessage.getIsoMsg());
            this.processCodeType = message1200.getTXProcessCode();
        }catch (Exception e){
            this.logger.error(e.getMessage());
        }

        return super.prepare(id, serializable);
    }
}