package ir.navaco.mcb.credit.card.parser.dto.pooya;

import ir.navaco.mcb.credit.card.parser.dto.IMessageParser;
import ir.navaco.mcb.credit.card.parser.dto.OriginalTx;
import ir.navaco.mcb.credit.card.parser.enums.MessageType;
import ir.navaco.mcb.credit.card.parser.exception.ISOFieldOutOfSizeException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalAmountException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import ir.navaco.mcb.credit.card.parser.helper.ISOParseHelper;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import java.text.ParseException;
import java.util.Date;

/**
 * this class is to get original transaction data
 * will use in return transactions and have aggregation with 1220 and 1420 series
 * @note customized pooya Bit56
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class OriginalTxData implements OriginalTx, IMessageParser {
    /**
     * it would keep address of isoMsg to set and get field from it through IMessageParser
     */
    private ISOMsg isoMsg;

    private String rawOriginalTxData; //field 56
    private MessageType originalTxMTI; //field 56.0
    private Long originalTxId; //field 56.1
    protected Date originalTxDateTime; //field 56.2
    //field 56.3 ... extra data ignored

    public OriginalTxData(ISOMsg isoMsg) throws Exception{
        this.isoMsg = isoMsg;

        rawOriginalTxData = parse(s->s,56);
        String mti = parse(s->s,"56.0");
        originalTxMTI = mti instanceof String ? MessageType.findByCode(Integer.parseInt(mti)) : null;
        originalTxId = parse(ISOParseHelper::parseLong,"56.1");
        originalTxDateTime = parse(ISOParseHelper::parseDate,"56.2", "yyMMddhhmmss");
    }

    public void packMessageInto(ISOMsg isoMsg) throws IllegalAmountException, ISOException, IllegalCurrencyException, ParseException, ISOFieldOutOfSizeException {
        this.isoMsg = isoMsg;
        packMessageInto();
    }

    public void packMessageInto() throws IllegalAmountException, ISOException, IllegalCurrencyException, ParseException, ISOFieldOutOfSizeException {
        fill(s->s,56, rawOriginalTxData);
    }

    public String getRawOriginalTxData() {
        return rawOriginalTxData;
    }

    public void setRawOriginalTxData(String rawOriginalTxData) {
        this.rawOriginalTxData = rawOriginalTxData;
    }

    public MessageType getOriginalTxMTI() {
        return originalTxMTI;
    }

    public void setOriginalTxMTI(MessageType originalTxMTI) {
        this.originalTxMTI = originalTxMTI;
    }

    public Long getOriginalTxId() {
        return originalTxId;
    }

    public void setOriginalTxId(Long originalTxId) {
        this.originalTxId = originalTxId;
    }

    public Date getOriginalTxDateTime() {
        return originalTxDateTime;
    }

    public void setOriginalTxDateTime(Date originalTxDateTime) {
        this.originalTxDateTime = originalTxDateTime;
    }

    @Override
    public ISOMsg getIsoMsg() {
        return isoMsg;
    }
}
