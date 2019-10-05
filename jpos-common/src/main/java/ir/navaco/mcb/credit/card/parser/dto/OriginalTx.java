package ir.navaco.mcb.credit.card.parser.dto;

import ir.navaco.mcb.credit.card.parser.enums.MessageType;
import ir.navaco.mcb.credit.card.parser.exception.ISOFieldOutOfSizeException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalAmountException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import java.text.ParseException;
import java.util.Date;

/**
 * in return type transactions there is a dto contains original transaction data
 * both pooya and shetab have same values and some differences
 *
 * we will use this interface to manage original transaction data in both shetab and pooya transactions
 *
 * @author sa.gholizadeh <sa.gholizadeh@yahoo.com>
 */
public interface OriginalTx {

    public void packMessageInto(ISOMsg isoMsg) throws IllegalAmountException, ISOException, IllegalCurrencyException, ParseException, ISOFieldOutOfSizeException;

    public void packMessageInto() throws IllegalAmountException, ISOException, IllegalCurrencyException, ParseException, ISOFieldOutOfSizeException;

    public MessageType getOriginalTxMTI();
    public Long getOriginalTxId();
    public Date getOriginalTxDateTime();
}
