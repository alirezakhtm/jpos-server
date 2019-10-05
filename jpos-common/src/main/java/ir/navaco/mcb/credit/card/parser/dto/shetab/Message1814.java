package ir.navaco.mcb.credit.card.parser.dto.shetab;

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
 * 1814 Shetab Standard 8583 message DTO
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class Message1814 extends MessageAbstract implements IResponseMessage {

    private FunctionCodeType functionCode; //field 24
    private TxProcessStatusType TXResponseCode; //field 39
    private Long TXDestinationInstituteCode; //field 93
    private Long TXSenderInstituteCode; //field 94

    public Message1814() {}

    public Message1814(ISOMsg isoMsg) throws Exception{
        super(isoMsg);

        functionCode = parse(ISOParseHelper::parseFunctionCode,24);
        TXResponseCode = parse(ISOParseHelper::parseResponseCode,39);
        TXDestinationInstituteCode = parse(ISOParseHelper::parseLong,93);
        TXSenderInstituteCode = parse(ISOParseHelper::parseLong,94);
    }

    public void packMessageInto() throws ISOException, IllegalCurrencyException, ISOFieldOutOfSizeException, IllegalAmountException, ParseException {
        super.packMessageInto();

        fill(s->s.toString(),24, functionCode);
        fill(ISOParseHelper::resCodeToString,39, TXResponseCode, 3);
        fill(s->s.toString(),93, TXDestinationInstituteCode);
        fill(s->s.toString(),94, TXSenderInstituteCode);

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

    @Override
    public TxProcessStatusType getTXResponseCode() {
        return TXResponseCode;
    }

    @Override
    public void setTXResponseCode(TxProcessStatusType TXResponseCode) {
        this.TXResponseCode = TXResponseCode;
    }

    public Long getTXDestinationInstituteCode() {
        return TXDestinationInstituteCode;
    }

    public void setTXDestinationInstituteCode(Long TXDestinationInstituteCode) {
        this.TXDestinationInstituteCode = TXDestinationInstituteCode;
    }

    public Long getTXSenderInstituteCode() {
        return TXSenderInstituteCode;
    }

    public void setTXSenderInstituteCode(Long TXSenderInstituteCode) {
        this.TXSenderInstituteCode = TXSenderInstituteCode;
    }
}
