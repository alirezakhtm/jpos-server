package ir.navaco.mcb.credit.card.parser;

import ir.navaco.mcb.credit.card.parser.dto.IMessage;
import ir.navaco.mcb.credit.card.parser.exception.ISOFieldOutOfSizeException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import ir.navaco.mcb.credit.card.parser.packer.ISO93APooyaPackager;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

/**
 * Pack an Iso message by an IMessage dto object.
 * call makeISOMessage() with and standard iso dto.
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class PackISOMessage {

    /**
     * To pack pos message just call this function. it get an IMessage and make related message
     * to load related DTO and return it back.
     * @param message String (standard ISO 8583 message without header)
     * @throws ISOException on parsing message via jPos
     * @throws IllegalCurrencyException on parsing amount (getting currency code) via helper
     * @throws ISOFieldOutOfSizeException on fixing String message size according to iso doc
     */
    public static String makeISOMessage(IMessage message) throws Exception {
        try {
            message.packMessageInto();

            ISOMsg isoMsg = message.getIsoMsg();
            ISO93APooyaPackager packager = new ISO93APooyaPackager();
            isoMsg.setPackager(packager);

            byte[] result = isoMsg.pack();
            return new String(result);

        } catch (ISOException e) {
            throw new Exception(e);
        } catch (IllegalCurrencyException e) {
            throw new Exception(e);
        } catch (ISOFieldOutOfSizeException e) {
            throw new Exception(e);
        }
    }
}