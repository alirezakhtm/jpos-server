package ir.navaco.mcb.credit.card.parser.dto.shetab;

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
 * 1804 Shetab Standard 8583 message DTO
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class Message1804 extends MessageAbstract implements IRequestMessage {

    //filed 15
    private FunctionCodeType functionCode; //field 24
    //field 53
    //field 60
    private Long TXDestinationInstituteCode; //field 93
    private Long TXSenderInstituteCode; //field 94
    //field 96

    public Message1804() {}

    public Message1804(ISOMsg isoMsg) throws Exception{
        super(isoMsg);

        functionCode = parse(ISOParseHelper::parseFunctionCode,24);
        TXDestinationInstituteCode = parse(ISOParseHelper::parseLong,93);
        TXSenderInstituteCode = parse(ISOParseHelper::parseLong,94);
    }

    public void packMessageInto() throws ISOException, IllegalCurrencyException, ISOFieldOutOfSizeException, IllegalAmountException, ParseException {
        super.packMessageInto();

        fill(s->s.toString(),24, functionCode);
        fill(s->s.toString(),93, TXDestinationInstituteCode);
        fill(s->s.toString(),94, TXSenderInstituteCode);

        generateBitSets();
    }

    public MessageType getMTI() { return MessageType.MTI_1804; }

    public void generateMac(){}

    public void setFunctionCode(FunctionCodeType functionCode) {
        this.functionCode = functionCode;
    }

    public FunctionCodeType getFunctionCode() {
        return functionCode;
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
