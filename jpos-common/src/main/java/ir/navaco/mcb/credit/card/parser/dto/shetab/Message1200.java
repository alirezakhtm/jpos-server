package ir.navaco.mcb.credit.card.parser.dto.shetab;

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
import org.jpos.iso.ISOUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;


/**
 * 1200 Shetab Standard 8583 message DTO
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class Message1200 extends MessageAbstract implements IRequestMessageFinAuthRev {

    private Long accountNo; //field 2
    private String RawTXProcessCode;
    private TxProcessCodeType TXProcessCode; //field 3
    private BigDecimal TXAmountAcquire; //field 4
    private BigDecimal TXAmountCardHolder; //field 6
    private Double exchangeRateCardHolder; //field 10
    private String dateExpiration; //field 14 (comes in persian)
    private Date TXReceiveDateTime; //field 17
    //field 19
    private String posInfo; //field 22
    private FunctionCodeType functionCode; //field 24
    private Short acquireBusinessType; //field 26
    private OriginalTxAmounts TXAmount; //field 30
    private Long acquireInstituteCode; //field 32
    private Long senderInstituteCode; //field 33
    private String track2Data; //field 35
    private String TXRefRecoverNo; //field 37
    private String TXAcquirePosNumber; //field 41
    private String cardAcquireNumber; //field 42
    private String cardAcquireNameLocation; //field 43
    private String specialExtraData; //field 48
    private String TXCurrency; //field 49
    private String cardHolderCurrency; //field 51
    //field 52
    //field 53
    //field 55
    //field 56
    //field 59
    //field 60
    //field 61
    private String TXCoding; //field 62
    //field 100
    //field 120

    public Message1200() {}

    public Message1200(ISOMsg isoMsg) throws Exception{
        super(isoMsg);

        accountNo = parse(ISOParseHelper::parseLong,2);
        TXProcessCode = parse(ISOParseHelper::parseProcessCode,3);
        RawTXProcessCode = parse(s->s,3);
        TXCurrency = parse(s->s,49);
        if(TXCurrency != null) {
            TXAmountAcquire = parse(ISOParseHelper::parseAmount,4, TXCurrency);
            TXAmountCardHolder = parse(ISOParseHelper::parseAmount,6, TXCurrency);
            TXAmount = new OriginalTxAmounts(isoMsg, TXCurrency);
        }
        exchangeRateCardHolder = parse(ISOUtil::parseAmountConversionRate,10);
        dateExpiration = parse(s->s,14);
        TXReceiveDateTime = parse(ISOParseHelper::parseDate,17, "MMdd");
        posInfo = parse(s->s,22);
        functionCode = parse(ISOParseHelper::parseFunctionCode,24);
        acquireBusinessType = parse(ISOParseHelper::parseShort,26);
        acquireInstituteCode = parse(ISOParseHelper::parseLong,32);
        senderInstituteCode = parse(ISOParseHelper::parseLong,33);
        track2Data = parse(s->s,35);
        TXRefRecoverNo = parse(s->s,37);
        TXAcquirePosNumber = parse(s->s,41);
        cardAcquireNumber = parse(s->s,42);
        cardAcquireNameLocation = parse(s->s,43);
        specialExtraData = parse(s->s,48);
        cardHolderCurrency = parse(s->s,51);
        TXCoding = parse(s->s,62);
    }

    public void packMessageInto() throws ISOException, IllegalCurrencyException, ISOFieldOutOfSizeException, IllegalAmountException, ParseException {
        super.packMessageInto();
        fill(s->s.toString(),2, accountNo);
        fill(s->s,3, RawTXProcessCode);
        fill(s->s,49, TXCurrency);
        if(TXCurrency != null) {
            fill(ISOParseHelper::amountToString, 4, TXAmountAcquire, TXCurrency);
            fill(ISOParseHelper::amountToString, 6, TXAmountCardHolder, TXCurrency);
            if(TXAmount != null)
                TXAmount.packMessageInto();
        }
        fill(ISOUtil::formatAmountConversionRate, 10, exchangeRateCardHolder);
        fill(s->s,14, dateExpiration);
        fill(ISOParseHelper::dateToString, 17, TXReceiveDateTime, "MMdd");
        fill(s->s,22, posInfo);
        fill(s->s.toString(),24, functionCode);
        fill(s->s.toString(),26, acquireBusinessType);
        fill(s->s.toString(),32, acquireInstituteCode);
        fill(s->s.toString(),33, senderInstituteCode);
        fill(s->s,35, track2Data);
        fill(ISOParseHelper::addSpaces, 37, TXRefRecoverNo, 12); //f2 is field length
        fill(s->s,41, TXAcquirePosNumber);
        fill(s->s,42, cardAcquireNumber);
        fill(s->s,43, cardAcquireNameLocation);
        fill(s->s,48, specialExtraData);
        fill(s->s,51, cardHolderCurrency);
        fill(s->s,62, TXCoding);

        generateBitSets();
    }

    public void generateMac(){}

    public MessageType getMTI() { return MessageType.MTI_1200; }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public void setTXProcessCode(TxProcessCodeType TXProcessCode) {
        this.TXProcessCode = TXProcessCode;
    }

    public void setTXAmountAcquire(BigDecimal TXAmountAcquire) {
        this.TXAmountAcquire = TXAmountAcquire;
    }

    public void setTXAmountCardHolder(BigDecimal TXAmountCardHolder) {
        this.TXAmountCardHolder = TXAmountCardHolder;
    }

    public void setExchangeRateCardHolder(Double exchangeRateCardHolder) { this.exchangeRateCardHolder = exchangeRateCardHolder; }

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

    public void setTXCurrency(String TXCurrency) {
        this.TXCurrency = TXCurrency;
    }

    public void setCardHolderCurrency(String cardHolderCurrency) {
        this.cardHolderCurrency = cardHolderCurrency;
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

    public BigDecimal getTXAmountAcquire() {
        return TXAmountAcquire;
    }

    public BigDecimal getTXAmountCardHolder() {
        return TXAmountCardHolder;
    }

    public Double getExchangeRateCardHolder() {
        return exchangeRateCardHolder;
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

    public String getTXCurrency() {
        return TXCurrency;
    }

    public String getCardHolderCurrency() {
        return cardHolderCurrency;
    }

    public String getTXCoding() {
        return TXCoding;
    }

    public String getRawTXProcessCode() {
        return RawTXProcessCode;
    }

    public void setRawTXProcessCode(String rawTXProcessCode) {
        RawTXProcessCode = rawTXProcessCode;
    }

    public OriginalTxAmounts getTXAmount() {
        return TXAmount;
    }

    public void setTXAmount(OriginalTxAmounts TXAmount) {
        this.TXAmount = TXAmount;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getTrack2Data() {
        return track2Data;
    }

    public void setTrack2Data(String track2Data) {
        this.track2Data = track2Data;
    }
}
