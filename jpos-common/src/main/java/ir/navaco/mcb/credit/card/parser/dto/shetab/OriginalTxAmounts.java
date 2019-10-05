package ir.navaco.mcb.credit.card.parser.dto.shetab;

import ir.navaco.mcb.credit.card.parser.dto.IMessageParser;
import ir.navaco.mcb.credit.card.parser.exception.ISOFieldOutOfSizeException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalAmountException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import ir.navaco.mcb.credit.card.parser.helper.ISOParseHelper;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import java.math.BigDecimal;
import java.text.ParseException;

/**
 * this class is to get original transaction amounts
 * will use in transactions have two amounts (original and settlement)
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class OriginalTxAmounts implements IMessageParser {
    /**
     * it would keep address of isoMsg to set and get field from it through IMessageParser
     */
    private ISOMsg isoMsg;
    private String TXCurrency; //field 49

    private String rawOriginalAmounts; //field 30
    private BigDecimal TXOriginAmount; //field 30.0
    private BigDecimal TXSettlementAmount; //field 30.1

    public OriginalTxAmounts(ISOMsg isoMsg, String txCurrency) throws Exception{
        this.isoMsg = isoMsg;
        this.TXCurrency = txCurrency;

        rawOriginalAmounts = parse(s->s,30);
        if(TXCurrency != null) {
            TXOriginAmount = parse(ISOParseHelper::parseAmount,"30.0", TXCurrency);
            TXSettlementAmount = parse(ISOParseHelper::parseAmount,"30.1", TXCurrency);
        }
    }

    public void packMessageInto(ISOMsg isoMsg) throws IllegalAmountException, ISOException, IllegalCurrencyException, ParseException, ISOFieldOutOfSizeException {
        this.isoMsg = isoMsg;
        packMessageInto();
    }

    public void packMessageInto() throws IllegalAmountException, ISOException, IllegalCurrencyException, ParseException, ISOFieldOutOfSizeException {
        if(TXCurrency != null && TXOriginAmount instanceof BigDecimal && TXSettlementAmount instanceof BigDecimal) {
            fill(ISOParseHelper::amountToString, "30.0", TXOriginAmount, TXCurrency);
            fill(ISOParseHelper::amountToString, "30.1", TXSettlementAmount, TXCurrency);
        }else if(rawOriginalAmounts instanceof String){
            fill(s->s,30, rawOriginalAmounts);
        }
    }

    public BigDecimal getTXOriginAmount() {
        return TXOriginAmount;
    }

    public void setTXOriginAmount(BigDecimal TXOriginAmount) {
        this.TXOriginAmount = TXOriginAmount;
    }

    public BigDecimal getTXSettlementAmount() {
        return TXSettlementAmount;
    }

    public void setTXSettlementAmount(BigDecimal TXSettlementAmount) {
        this.TXSettlementAmount = TXSettlementAmount;
    }

    public String getRawOriginalAmounts() {
        return rawOriginalAmounts;
    }

    public void setRawOriginalAmounts(String rawOriginalAmounts) {
        this.rawOriginalAmounts = rawOriginalAmounts;
    }

    @Override
    public ISOMsg getIsoMsg() {
        return isoMsg;
    }
}
