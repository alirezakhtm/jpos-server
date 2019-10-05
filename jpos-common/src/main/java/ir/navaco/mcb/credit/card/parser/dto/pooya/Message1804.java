package ir.navaco.mcb.credit.card.parser.dto.pooya;

import ir.navaco.mcb.credit.card.parser.dto.IRequestMessage;
import ir.navaco.mcb.credit.card.parser.dto.MessageAbstract;
import ir.navaco.mcb.credit.card.parser.enums.FunctionCodeType;
import ir.navaco.mcb.credit.card.parser.enums.MessageType;
import ir.navaco.mcb.credit.card.parser.exception.ISOFieldOutOfSizeException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalAmountException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import ir.navaco.mcb.credit.card.parser.helper.ISOParseHelper;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import java.text.ParseException;

/**
 * 1804 Pooya 8583 message DTO
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class Message1804 extends MessageAbstract implements IRequestMessage {

    private FunctionCodeType functionCode; //field 24 (NOTinPooya)
    private String TXRefRecoverNo; //field 37 (Pooya Transactions)
    private Short CountryCode;//field 70 (Pooya Transactions)

    public Message1804() {}

    public Message1804(ISOMsg isoMsg) throws Exception{
        super(isoMsg);

        functionCode = parse(ISOParseHelper::parseFunctionCode,24);
        TXRefRecoverNo = parse(s->s,37);
        CountryCode = parse(ISOParseHelper::parseShort,70);
    }

    public void packMessageInto() throws ISOException, IllegalCurrencyException, ISOFieldOutOfSizeException, IllegalAmountException, ParseException {
        super.packMessageInto();

        fill(s->s.toString(),24, functionCode);
        fill(ISOParseHelper::addSpaces, 37, TXRefRecoverNo, 12); //f2 is field length
        fill(s->s.toString(),70, CountryCode);

        generateBitSets();
    }

    public MessageType getMTI() { return MessageType.MTI_1804; }

    public void generateMac(){}

    public void setFunctionCode(FunctionCodeType functionCode) {
        this.functionCode = functionCode;
    }

    public void setTXRefRecoverNo(String TXRefRecoverNo) {
        this.TXRefRecoverNo = TXRefRecoverNo;
    }

    public FunctionCodeType getFunctionCode() {
        return functionCode;
    }

    public String getTXRefRecoverNo() {
        return TXRefRecoverNo;
    }

    public Short getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(Short countryCode) {
        CountryCode = countryCode;
    }

}
