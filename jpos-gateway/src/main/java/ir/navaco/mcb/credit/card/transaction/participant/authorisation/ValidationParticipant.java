package ir.navaco.mcb.credit.card.transaction.participant.authorisation;

import ir.navaco.mcb.credit.card.parser.dto.IMessage;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1100;
import ir.navaco.mcb.credit.card.transaction.config.ContextConstant;
import ir.navaco.mcb.credit.card.transaction.participant.firewall.FirewallParticipant;
import org.jpos.transaction.Context;

import java.io.Serializable;

/**
 * The participant to validate 11XX messages type
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class ValidationParticipant extends FirewallParticipant {

    public ValidationParticipant(){
        this.TAG = "ValidationParticipant - 1100";
        this.MTI = 1100;
        this.init();
    }

    @Override
    public int prepare(long l, Serializable serializable) {

        Context context = (Context)serializable;
        IMessage iMessage = (IMessage) context.get(ContextConstant.REQUEST_DTO_KEY);

        try {
            Message1100 message1100 = new Message1100(iMessage.getIsoMsg());
            this.processCodeType = message1100.getTXProcessCode();
        }catch (Exception e){
            this.logger.error(e.getMessage());
        }

        return super.prepare(l, serializable);
    }
}