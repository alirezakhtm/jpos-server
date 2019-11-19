package ir.navaco.mcb.credit.card.parser.dto.pooya;

import ir.navaco.mcb.credit.card.parser.dto.IRequestMessageFinAuthRev;
import ir.navaco.mcb.credit.card.parser.dto.MessageAbstract;
import ir.navaco.mcb.credit.card.parser.enums.FunctionCodeType;
import ir.navaco.mcb.credit.card.parser.enums.MessageType;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessCodeType;
import ir.navaco.mcb.credit.card.parser.exception.ISOFieldOutOfSizeException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalAmountException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import ir.navaco.mcb.credit.card.parser.helper.ISOParseHelper;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import java.text.ParseException;
import java.util.Date;

/**
 * 1604 Pooya 8583 message DTO
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class Message1604 extends MessageAbstract implements IRequestMessageFinAuthRev {

    private Long accountNo; //field 2
    private TxProcessCodeType TXProcessCode; //field 3
    private String RawTXProcessCode;
    private Date TXReceiveDateTime; //field 17
    private String posInfo; //field 22
    private FunctionCodeType functionCode; //field 24
    private Short acquireBusinessType; //field 26
    private Long acquireInstituteCode; //field 32
    private Long senderInstituteCode; //field 33
    private String TXRefRecoverNo; //field 37
    private String TXAcquirePosNumber; //field 41
    private String cardAcquireNumber; //field 42
    private String cardAcquireNameLocation; //field 43
    private String specialExtraData; //field 48
    private String TXCoding; //field 62
    private String receiverInstituteCode; //field 100

    public Message1604() {}

    public Message1604(ISOMsg isoMsg) throws Exception{
        super(isoMsg);

        accountNo = parse(ISOParseHelper::parseLong,2);
        TXProcessCode = parse(ISOParseHelper::parseProcessCode,3);
        RawTXProcessCode = parse(s->s,3);
        TXReceiveDateTime = parse(ISOParseHelper::parseDate,17, "MMdd");
        posInfo = parse(s->s,22);
        functionCode = parse(ISOParseHelper::parseFunctionCode,24);
        acquireBusinessType = parse(ISOParseHelper::parseShort,26);
        acquireInstituteCode = parse(ISOParseHelper::parseLong,32);
        senderInstituteCode = parse(ISOParseHelper::parseLong,33);
        TXRefRecoverNo = parse(s->s,37);
        TXAcquirePosNumber = parse(s->s,41);
        cardAcquireNumber = parse(s->s,42);
        cardAcquireNameLocation = parse(s->s,43);
        specialExtraData = parse(s->s,48);
        TXCoding = parse(s->s,62);
        receiverInstituteCode = parse(s->s,100);
    }

    public void packMessageInto() throws ISOException, IllegalCurrencyException, ISOFieldOutOfSizeException, IllegalAmountException, ParseException {
        super.packMessageInto();
        fill(s->s.toString(),2, accountNo);
        fill(s->s,3, RawTXProcessCode);
        fill(ISOParseHelper::dateToString, 17, TXReceiveDateTime, "MMdd");
        fill(s->s,22, posInfo);
        fill(s->s.toString(),24, functionCode);
        fill(s->s.toString(),26, acquireBusinessType);
        fill(s->s.toString(),32, acquireInstituteCode);
        fill(s->s.toString(),33, senderInstituteCode);
        fill(ISOParseHelper::addSpaces, 37, TXRefRecoverNo, 12); //f2 is field length
        fill(s->s,41, TXAcquirePosNumber);
        fill(s->s,42, cardAcquireNumber);
        fill(s->s,43, cardAcquireNameLocation);
        fill(s->s,48, specialExtraData);
        fill(s->s,62, TXCoding);
        fill(s->s,100, receiverInstituteCode);

        generateBitSets();
    }

    public MessageType getMTI() { return MessageType.MTI_1100; }

    public void generateMac(){}

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public void setTXProcessCode(TxProcessCodeType TXProcessCode) {
        this.TXProcessCode = TXProcessCode;
    }

    public void setTXReceiveDateTime(Date TXReceiveDateTime) {
        this.TXReceiveDateTime = TXReceiveDateTime;
    }

    public void setPosInfo(String posInfo) {
        this.posInfo = posInfo;
    }

    public void setFunctionCode(FunctionCodeType functionCode) {
        this.functionCode = functionCode;
    }

    public void setAcquireBusinessType(Short acquireBusinessType) {
        this.acquireBusinessType = acquireBusinessType;
    }

    public void setAcquireInstituteCode(Long acquireInstituteCode) { this.acquireInstituteCode = acquireInstituteCode; }

    public void setSenderInstituteCode(Long senderInstituteCode) {
        this.senderInstituteCode = senderInstituteCode;
    }

    public void setTXRefRecoverNo(String TXRefRecoverNo) {
        this.TXRefRecoverNo = TXRefRecoverNo;
    }

    public void setTXAcquirePosNumber(String TXAcquirePosNumber) {
        this.TXAcquirePosNumber = TXAcquirePosNumber;
    }

    public void setCardAcquireNumber(String cardAcquireNumber) {
        this.cardAcquireNumber = cardAcquireNumber;
    }

    public void setCardAcquireNameLocation(String cardAcquireNameLocation) { this.cardAcquireNameLocation = cardAcquireNameLocation; }

    public void setSpecialExtraData(String specialExtraData) {
        this.specialExtraData = specialExtraData;
    }

    public void setTXCoding(String TXCoding) {
        this.TXCoding = TXCoding;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public TxProcessCodeType getTXProcessCode() {
        return TXProcessCode;
    }

    public Date getTXReceiveDateTime() {
        return TXReceiveDateTime;
    }

    public String getPosInfo() {
        return posInfo;
    }

    public FunctionCodeType getFunctionCode() {
        return functionCode;
    }

    public Short getAcquireBusinessType() {
        return acquireBusinessType;
    }

    public Long getAcquireInstituteCode() {
        return acquireInstituteCode;
    }

    public Long getSenderInstituteCode() {
        return senderInstituteCode;
    }

    public String getTXRefRecoverNo() {
        return TXRefRecoverNo;
    }

    public String getTXAcquirePosNumber() {
        return TXAcquirePosNumber;
    }

    public String getCardAcquireNumber() {
        return cardAcquireNumber;
    }

    public String getCardAcquireNameLocation() {
        return cardAcquireNameLocation;
    }

    public String getSpecialExtraData() {
        return specialExtraData;
    }

    public String getTXCoding() {
        return TXCoding;
    }

    public String getReceiverInstituteCode() {
        return receiverInstituteCode;
    }

    public void setReceiverInstituteCode(String receiverInstituteCode) {
        this.receiverInstituteCode = receiverInstituteCode;
    }

    public String getRawTXProcessCode() {
        return RawTXProcessCode;
    }

    public void setRawTXProcessCode(String rawTXProcessCode) {
        RawTXProcessCode = rawTXProcessCode;
    }
}
