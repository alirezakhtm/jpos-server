package ir.navaco.mcb.credit.card.transaction.participant.reversal;

import ir.navaco.mcb.credit.card.parser.dto.IMessage;
import ir.navaco.mcb.credit.card.parser.dto.pooya.Message1420;
import ir.navaco.mcb.credit.card.transaction.config.ContextConstant;
import ir.navaco.mcb.credit.card.transaction.participant.firewall.FirewallParticipant;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;

import java.io.Serializable;

/**
 * The participant to validate 14XX messages type
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class ValidationParticipant extends FirewallParticipant {

    public ValidationParticipant(){
        this.TAG = "ValidationParticipant - 1420";
        this.MTI = 1420;
        this.init();
    }

    @Override
    public int prepare(long id, Serializable serializable) {
        Context context = (Context) serializable;
        IMessage iMessage = (IMessage) context.get(ContextConstant.REQUEST_DTO_KEY);

        try{
            Message1420 message1420 = new Message1420(iMessage.getIsoMsg());
            this.processCodeType = message1420.getTXProcessCode();
        }catch (Exception e){
            this.logger.error(e.getMessage());
        }

        return super.prepare(id, serializable);
    }
}