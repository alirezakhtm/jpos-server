package ir.navaco.mcb.credit.card.parser;

import ir.navaco.mcb.credit.card.parser.dto.IMessage;
import ir.navaco.mcb.credit.card.parser.dto.pooya.*;
import ir.navaco.mcb.credit.card.parser.enums.MessageType;
import ir.navaco.mcb.credit.card.parser.exception.IllegalAmountException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import ir.navaco.mcb.credit.card.parser.exception.UnSupportedMessageException;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import java.text.ParseException;

/**
 * Unpack factory Class get a pos message and return an IMessage dto back.
 * call parseISOMessage() with and standard message.
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class UnpackISOMessage {

    /**
     * To unpack pos message just call this function. it will parse the message and call instantiate() factory method
     * to load related DTO and return it back.
     * @param isoMsg ISOMsg (standard jpos IsoMsg)
     * @return IMessage (a message impl dto according to MTI)
     * @throws ISOException on parsing message via jPos
     * @throws ParseException on parsing string, number, date via helper
     * @throws NumberFormatException on parsing int, double, long via helper
     * @throws IllegalCurrencyException on parsing amount (getting currency code) via helper
     * @throws IllegalAmountException on parsing amount (amount length problem)
     * @throws UnSupportedMessageException on unsupported iso messages (no dto to map)
     */
    public static IMessage parseISOMessage(ISOMsg isoMsg) throws Exception {
        try {

            IMessage messageDto = instantiate(isoMsg);

            return messageDto;
        } catch (ISOException e) {
            throw new Exception(e);
        } catch (ParseException e){
            throw new Exception(e);
        } catch (NumberFormatException e){
            throw new Exception(e);
        } catch (IllegalCurrencyException e) {
            throw new Exception(e);
        } catch (IllegalAmountException e){
            throw new Exception(e);
        } catch (UnSupportedMessageException e) {
            throw new Exception(e);
        }
    }

    /**
     * factory method to load related message according to MTI
     * will be called by parseISOMessage method
     *
     * @param isoMsg ISOMsg
     * @return IMessage object
     */
    private static IMessage instantiate(ISOMsg isoMsg) throws Exception {
        MessageType msgt = MessageType.findByCode(Integer.parseInt(isoMsg.getMTI()));
        switch (msgt){
            case MTI_1100: return new Message1100(isoMsg);
            case MTI_1110: return new Message1110(isoMsg);
            case MTI_1200: return new Message1200(isoMsg);
            case MTI_1210: return new Message1210(isoMsg);
            case MTI_1220: return new Message1220(isoMsg);
            case MTI_1230: return new Message1230(isoMsg);
            case MTI_1420: return new Message1420(isoMsg);
            case MTI_1430: return new Message1430(isoMsg);
            case MTI_1804: return new Message1804(isoMsg);
            case MTI_1814: return new Message1814(isoMsg);
            default: throw new UnSupportedMessageException("I have nothing to do with type: " + isoMsg.getMTI());
        }
    }
}