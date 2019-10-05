package ir.navaco.mcb.credit.card.parser.dto.shetab;

import ir.navaco.mcb.credit.card.parser.dto.MessageAbstract;
import ir.navaco.mcb.credit.card.parser.enums.FunctionCodeType;
import ir.navaco.mcb.credit.card.parser.enums.MessageType;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessCodeType;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessStatusType;
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
 * Standard 8583 message DTO to use for all kind of message if needed
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class GeneralMessage extends MessageAbstract {

    private MessageType mti;
    private Long accountNo; //field 2
    private TxProcessCodeType TXProcessCode; //field 3
    private BigDecimal TXAmountAcquire; //field 4
    private BigDecimal TXAmountCardHolder; //field 6
    private Double exchangeRateCardHolder; //field 10
    private String dateExpiration; //field 14 (@todo check field. comes in persian)
    private Date TXSettlementDate; //field 15
    private Date TXReceiveDateTime; //field 17
    private Short merchantType; //field 18
    //field 19
    private String posInfo; //field 22
    private FunctionCodeType functionCode; //field 24
    private Short reasonCode; //field 25
    private Short acquireBusinessType; //field 26
    private OriginalTxAmounts TXAmount; //field 30
    private Long acquireInstituteCode; //field 32
    private Long senderInstituteCode; //field 33
    private String track2Data; //field 35
    private String TXRefRecoverNo; //field 37
    private String TXApprovalCode; //field 38
    private TxProcessStatusType TXResponseCode; //field 39
    private String TXAcquirePosNumber; //field 41
    private String cardAcquireNumber; //field 42
    private String cardAcquireNameLocation; //field 43
    private String responseExtraData; //field 44
    private String specialExtraData; //field 48
    private String TXCurrency; //field 49
    private String cardHolderCurrency; //field 51
    //field 52
    //field 53
    private String extraAmount; //field 54
    //field 55
    //field 56
    //field 59
    //field 60
    //field 61
    private String TXCoding; //field 62
    private String dataRecord; //field 72
    private String receiverInstituteCode; //field 100
    private String accountIdentification; //field 102
    private String pooyaTxReserved; //field 113

    public GeneralMessage() {}

    public GeneralMessage(ISOMsg isoMsg) throws Exception{
        super(isoMsg);

        accountNo = parse(ISOParseHelper::parseLong,2);
        TXProcessCode = parse(ISOParseHelper::parseProcessCode,3);
        TXCurrency = parse(s->s,49);
        if(TXCurrency != null) {
            TXAmountAcquire = parse(ISOParseHelper::parseAmount,4, TXCurrency);
            TXAmountCardHolder = parse(ISOParseHelper::parseAmount,6, TXCurrency);
            TXAmount = new OriginalTxAmounts(isoMsg, TXCurrency);
        }
        exchangeRateCardHolder = parse(ISOUtil::parseAmountConversionRate,10);
        dateExpiration = parse(s->s,14);
        TXSettlementDate = parse(ISOParseHelper::parseDate,15, "yyMMdd");
        TXReceiveDateTime = parse(ISOParseHelper::parseDate,17, "MMdd");
        merchantType = parse(ISOParseHelper::parseShort,18);
        posInfo = parse(s->s,22);
        functionCode = parse(ISOParseHelper::parseFunctionCode,24);
        reasonCode = parse(ISOParseHelper::parseShort,25);
        acquireBusinessType = parse(ISOParseHelper::parseShort,26);
        acquireInstituteCode = parse(ISOParseHelper::parseLong,32);
        senderInstituteCode = parse(ISOParseHelper::parseLong,33);
        track2Data = parse(s->s,35);
        TXRefRecoverNo = parse(s->s,37);
        TXApprovalCode = parse(s->s,38);
        TXResponseCode = parse(ISOParseHelper::parseResponseCode,39);
        TXAcquirePosNumber = parse(s->s,41);
        cardAcquireNumber = parse(s->s,42);
        cardAcquireNameLocation = parse(s->s,43);
        responseExtraData = parse(s->s,44);
        specialExtraData = parse(s->s,48);
        cardHolderCurrency = parse(s->s,51);
        extraAmount = parse(s->s,54);
        TXCoding = parse(s->s,62);
        dataRecord = parse(s->s,72);
        receiverInstituteCode = parse(s->s,100);
        accountIdentification = parse(s->s,102);
        pooyaTxReserved = parse(s->s,113);
    }

    public void packMessageInto() throws ISOException, IllegalCurrencyException, ISOFieldOutOfSizeException, IllegalAmountException, ParseException {
        super.packMessageInto();
        fill(s->s.toString(),2, accountNo);
        fill(s->s,3, ISOUtil.zeropad(TXProcessCode.getCode(), 6));
        fill(s->s,49, TXCurrency);
        if(TXCurrency != null) {
            fill(ISOParseHelper::amountToString, 4, TXAmountAcquire, TXCurrency);
            fill(ISOParseHelper::amountToString, 6, TXAmountCardHolder, TXCurrency);
            if(TXAmount != null)
                TXAmount.packMessageInto();
        }
        fill(ISOUtil::formatAmountConversionRate, 10, exchangeRateCardHolder);
        fill(s->s,14, dateExpiration);
        fill(ISOParseHelper::dateToString, 15, TXSettlementDate, "yyMMdd");
        fill(ISOParseHelper::dateToString, 17, TXReceiveDateTime, "MMdd");
        fill(s->s.toString(),18, merchantType);
        fill(s->s,22, posInfo);
        fill(s->s.toString(),24, functionCode);
        fill(s->s.toString(),25, reasonCode);
        fill(s->s.toString(),26, acquireBusinessType);
        fill(s->s.toString(),32, acquireInstituteCode);
        fill(s->s.toString(),33, senderInstituteCode);
        fill(s->s,35, track2Data);
        fill(ISOParseHelper::addSpaces, 37, TXRefRecoverNo, 12); //f2 is field length
        fill(s->s,38, TXApprovalCode);
        fill(ISOParseHelper::resCodeToString,39, TXResponseCode, 3);
        fill(s->s,41, TXAcquirePosNumber);
        fill(s->s,42, cardAcquireNumber);
        fill(s->s,43, cardAcquireNameLocation);
        fill(s->s,44, responseExtraData);
        fill(s->s,48, specialExtraData);
        fill(s->s,51, cardHolderCurrency);
        fill(s->s,54, extraAmount);
        fill(s->s,62, TXCoding);
        fill(s->s,72, dataRecord);
        fill(s->s,100, receiverInstituteCode);
        fill(s->s,102, accountIdentification);
        fill(s->s,113, pooyaTxReserved);

        generateBitSets();
    }

    public void generateMac(){}

    public MessageType getMTI() { return mti; }

    public void setMTI(MessageType mti) { this.mti = mti; }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public void setTXProcessCode(TxProcessCodeType TXProcessCode) {
        this.TXProcessCode = TXProcessCode;
    }

    public void setTXSettlementDate(Date TXSettlementDate) {
        this.TXSettlementDate = TXSettlementDate;
    }

    public void setTXResponseCode(TxProcessStatusType TXResponseCode) {
        this.TXResponseCode = TXResponseCode;
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

    public Date getTXSettlementDate() {
        return TXSettlementDate;
    }

    public TxProcessStatusType getTXResponseCode() {
        return TXResponseCode;
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

    public String getReceiverInstituteCode() {
        return receiverInstituteCode;
    }

    public void setReceiverInstituteCode(String receiverInstituteCode) {
        this.receiverInstituteCode = receiverInstituteCode;
    }

    public String getResponseExtraData() {
        return responseExtraData;
    }

    public void setResponseExtraData(String responseExtraData) {
        this.responseExtraData = responseExtraData;
    }

    public String getExtraAmount() {
        return extraAmount;
    }

    public void setExtraAmount(String extraAmount) {
        this.extraAmount = extraAmount;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Short getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(Short merchantType) {
        this.merchantType = merchantType;
    }

    public Short getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(Short reasonCode) {
        this.reasonCode = reasonCode;
    }

    public OriginalTxAmounts getTXAmount() {
        return TXAmount;
    }

    public void setTXAmount(OriginalTxAmounts TXAmount) {
        this.TXAmount = TXAmount;
    }

    public String getTrack2Data() {
        return track2Data;
    }

    public void setTrack2Data(String track2Data) {
        this.track2Data = track2Data;
    }

    public String getTXApprovalCode() {
        return TXApprovalCode;
    }

    public void setTXApprovalCode(String TXApprovalCode) {
        this.TXApprovalCode = TXApprovalCode;
    }

    public String getDataRecord() {
        return dataRecord;
    }

    public void setDataRecord(String dataRecord) {
        this.dataRecord = dataRecord;
    }

    public String getAccountIdentification() {
        return accountIdentification;
    }

    public void setAccountIdentification(String accountIdentification) {
        this.accountIdentification = accountIdentification;
    }

    public String getPooyaTxReserved() {
        return pooyaTxReserved;
    }

    public void setPooyaTxReserved(String pooyaTxReserved) {
        this.pooyaTxReserved = pooyaTxReserved;
    }
}
