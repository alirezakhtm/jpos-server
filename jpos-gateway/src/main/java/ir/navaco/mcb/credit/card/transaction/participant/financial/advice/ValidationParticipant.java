package ir.navaco.mcb.credit.card.transaction.participant.financial.advice;

import ir.navaco.mcb.credit.card.parser.dto.IMessage;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1220;
import ir.navaco.mcb.credit.card.transaction.config.ContextConstant;
import ir.navaco.mcb.credit.card.transaction.participant.firewall.FirewallParticipant;
import org.jpos.transaction.Context;

import java.io.Serializable;

/**
 * The participant to validate 1220,1230 messages type
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class ValidationParticipant extends FirewallParticipant {

    public ValidationParticipant(){
        this.TAG = "ValidationParticipant - 1220";
        this.MTI = 1220;
        this.init();
    }

    @Override
    public int prepare(long l, Serializable serializable) {

        Context context = (Context)serializable;
        IMessage iMessage = (IMessage) context.get(ContextConstant.REQUEST_DTO_KEY);

        try {
            Message1220 message1220 = new Message1220(iMessage.getIsoMsg());
            this.processCodeType = message1220.getTXProcessCode();
        }catch (Exception e){
            this.logger.error(e.getMessage());
        }

        return super.prepare(l, serializable);
    }
}