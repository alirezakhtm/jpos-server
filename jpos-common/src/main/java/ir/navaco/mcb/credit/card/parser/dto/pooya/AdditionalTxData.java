package ir.navaco.mcb.credit.card.parser.dto.pooya;

import ir.navaco.mcb.credit.card.parser.dto.IMessageParser;
import ir.navaco.mcb.credit.card.parser.dto.ITLVParser;
import ir.navaco.mcb.credit.card.parser.exception.ISOFieldOutOfSizeException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalAmountException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import ir.navaco.mcb.credit.card.parser.helper.ISOParseHelper;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.tlv.GenericTagSequence;

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
public class AdditionalTxData implements IMessageParser, ITLVParser {
    /**
     * it would keep address of isoMsg to set and get field from it through IMessageParser
     */
    private ISOMsg isoMsg;
    private GenericTagSequence tagValueSequence;

    private String rawAdditionalTxData; //field 56
    private Long txStandOrder;
    private Long billingId;
    private Long paymentId;
    private Date txDate;

    public AdditionalTxData(ISOMsg isoMsg) throws Exception{
        this.isoMsg = isoMsg;
        tagValueSequence = new GenericTagSequence();
        tagValueSequence.readFrom((ISOMsg) isoMsg.getComponent(48));

        rawAdditionalTxData = new String((isoMsg.getComponent(48)).pack());
        txStandOrder = parse(ISOParseHelper::parseLong,"P13");
        billingId = parse(ISOParseHelper::parseLong,"BBI");
        paymentId = parse(ISOParseHelper::parseLong,"BPI");
        txDate = parse(ISOParseHelper::parseDate, "D01", "yyyyMMddhhmmss");
    }

    public void packMessageInto(ISOMsg isoMsg) throws IllegalAmountException, ISOException, IllegalCurrencyException, ParseException, ISOFieldOutOfSizeException {
        this.isoMsg = isoMsg;
        packMessageInto();
    }

    public void packMessageInto() throws IllegalAmountException, ISOException, IllegalCurrencyException, ParseException, ISOFieldOutOfSizeException {
        fill(s->s,48, rawAdditionalTxData);
    }

    public String getRawAdditionalTxData() {
        return rawAdditionalTxData;
    }

    public void setRawAdditionalTxData(String rawAdditionalTxData) {
        this.rawAdditionalTxData = rawAdditionalTxData;
    }

    public Long getTxStandOrder() {
        return txStandOrder;
    }

    public void setTxStandOrder(Long txStandOrder) {
        this.txStandOrder = txStandOrder;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    @Override
    public ISOMsg getIsoMsg() {
        return isoMsg;
    }

    @Override
    public GenericTagSequence getTagValueSequence() {
        return tagValueSequence;
    }
}
