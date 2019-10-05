package ir.navaco.mcb.credit.card.parser.dto.pooya;

import ir.navaco.mcb.credit.card.parser.dto.IResponseMessage;
import ir.navaco.mcb.credit.card.parser.dto.MessageAbstract;
import ir.navaco.mcb.credit.card.parser.enums.FunctionCodeType;
import ir.navaco.mcb.credit.card.parser.enums.MessageType;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessStatusType;
import ir.navaco.mcb.credit.card.parser.exception.ISOFieldOutOfSizeException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalAmountException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import ir.navaco.mcb.credit.card.parser.helper.ISOParseHelper;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import java.text.ParseException;

/**
 * 1814 Pooya 8583 message DTO
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class Message1814 extends MessageAbstract implements IResponseMessage {

    private FunctionCodeType functionCode; //field 24 (NOTinPooya)
    private String TXRefRecoverNo; //field 37 (Pooya Transactions)
    private TxProcessStatusType TXResponseCode; //field 39
    private Short CountryCode;//field 70 (Pooya Transactions)

    public Message1814() {}

    public Message1814(ISOMsg isoMsg) throws Exception{
        super(isoMsg);

        functionCode = parse(ISOParseHelper::parseFunctionCode,24);
        TXRefRecoverNo = parse(s->s,37);
        TXResponseCode = parse(ISOParseHelper::parseResponseCode,39);
        CountryCode = parse(ISOParseHelper::parseShort,70);
    }

    public void packMessageInto() throws ISOException, IllegalCurrencyException, ISOFieldOutOfSizeException, IllegalAmountException, ParseException {
        super.packMessageInto();

        fill(s->s.toString(),24, functionCode);
        fill(ISOParseHelper::addSpaces, 37, TXRefRecoverNo, 12); //f2 is field length
        fill(ISOParseHelper::resCodeToString,39, TXResponseCode, 3);
        fill(s->s.toString(),70, CountryCode);

        generateBitSets();
    }

    public MessageType getMTI() { return MessageType.MTI_1814; }

    public void generateMac(){}

    public FunctionCodeType getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(FunctionCodeType functionCode) {
        this.functionCode = functionCode;
    }

    public String getTXRefRecoverNo() {
        return TXRefRecoverNo;
    }

    public void setTXRefRecoverNo(String TXRefRecoverNo) {
        this.TXRefRecoverNo = TXRefRecoverNo;
    }

    @Override
    public TxProcessStatusType getTXResponseCode() {
        return TXResponseCode;
    }

    @Override
    public void setTXResponseCode(TxProcessStatusType TXResponseCode) {
        this.TXResponseCode = TXResponseCode;
    }

    public Short getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(Short countryCode) {
        CountryCode = countryCode;
    }
}
