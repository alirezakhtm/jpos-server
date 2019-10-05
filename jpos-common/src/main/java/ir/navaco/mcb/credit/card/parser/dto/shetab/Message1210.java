package ir.navaco.mcb.credit.card.parser.dto.shetab;

import ir.navaco.mcb.credit.card.parser.dto.IResponseMessageFinAuthRev;
import ir.navaco.mcb.credit.card.parser.dto.MessageAbstract;
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
 * 1210(response) Shetab Standard 8583 message DTO
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class Message1210 extends MessageAbstract implements IResponseMessageFinAuthRev {

    private Long accountNo; //field 2
    private TxProcessCodeType TXProcessCode; //field 3
    private String RawTXProcessCode;
    private BigDecimal TXAmountAcquire; //field 4
    private BigDecimal TXAmountCardHolder; //field 6
    private Double exchangeRateCardHolder; //field 10
    private Date TXSettlementDate; //field 15
    private Long acquireInstituteCode; //field 32
    private Long senderInstituteCode; //field 33
    private String TXRefRecoverNo; //field 37
    private String TXApprovalCode; //field 38
    private TxProcessStatusType TXResponseCode; //field 39
    private String TXAcquirePosNumber; //field 41
    private String cardAcquireNumber; //field 42
    private String responseExtraData; //field 44
    private String TXCurrency; //field 49
    private String cardHolderCurrency; //field 51
    private String extraAmount; //field 54
    //field 55
    //field 59
    //field 61
    private String TXCoding; //field 62
    private String receiverInstituteCode; //field 100

    public Message1210() {}

    public Message1210(ISOMsg isoMsg) throws Exception{
        super(isoMsg);
        accountNo = parse(ISOParseHelper::parseLong,2);
        TXProcessCode = parse(ISOParseHelper::parseProcessCode,3);
        RawTXProcessCode = parse(s->s,3);
        TXCurrency = parse(s->s,49);
        if(TXCurrency != null) {
            TXAmountAcquire = parse(ISOParseHelper::parseAmount,4, TXCurrency);
            TXAmountCardHolder = parse(ISOParseHelper::parseAmount,6, TXCurrency);
        }
        exchangeRateCardHolder = parse(ISOUtil::parseAmountConversionRate,10);
        TXSettlementDate = parse(ISOParseHelper::parseDate,15, "yyMMdd");
        acquireInstituteCode = parse(ISOParseHelper::parseLong,32);
        senderInstituteCode = parse(ISOParseHelper::parseLong,33);
        TXRefRecoverNo = parse(s->s,37);
        TXApprovalCode = parse(s->s,38);
        TXResponseCode = parse(ISOParseHelper::parseResponseCode,39);
        TXAcquirePosNumber = parse(s->s,41);
        cardAcquireNumber = parse(s->s,42);
        responseExtraData = parse(s->s,44);
        cardHolderCurrency = parse(s->s,51);
        extraAmount = parse(s->s,54);
        TXCoding = parse(s->s,62);
        receiverInstituteCode = parse(s->s,100);
    }

    public void packMessageInto() throws IllegalCurrencyException, ISOFieldOutOfSizeException, ISOException, IllegalAmountException, ParseException {
        super.packMessageInto();

        fill(s->s.toString(),2, accountNo);
        fill(s->s,3, RawTXProcessCode);
        fill(s->s,49, TXCurrency);
        if(TXCurrency != null) {
            fill(ISOParseHelper::amountToString, 4, TXAmountAcquire, TXCurrency);
            fill(ISOParseHelper::amountToString, 6, TXAmountCardHolder, TXCurrency);
        }
        fill(ISOUtil::formatAmountConversionRate, 10, exchangeRateCardHolder);
        fill(ISOParseHelper::dateToString, 15, TXSettlementDate, "yyMMdd");
        fill(s->s.toString(),32, acquireInstituteCode);
        fill(s->s.toString(),33, senderInstituteCode);
        fill(ISOParseHelper::addSpaces, 37, TXRefRecoverNo, 12); //f2 is field length
        fill(s->s,38, TXApprovalCode);
        fill(ISOParseHelper::resCodeToString,39, TXResponseCode, 3);
        fill(s->s,41, TXAcquirePosNumber);
        fill(s->s,42, cardAcquireNumber);
        fill(s->s,44, responseExtraData);
        fill(s->s,51, cardHolderCurrency);
        fill(s->s,54, extraAmount);
        fill(s->s,62, TXCoding);
        fill(s->s,100, receiverInstituteCode);

        generateBitSets();
    }

    public void generateMac(){}

    public MessageType getMTI() { return MessageType.MTI_1210; }

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

    public void setExchangeRateCardHolder(Double exchangeRateCardHolder) {
        this.exchangeRateCardHolder = exchangeRateCardHolder;
    }

    public void setTXSettlementDate(Date TXSettlementDate) {
        this.TXSettlementDate = TXSettlementDate;
    }

    public void setTXResponseCode(TxProcessStatusType TXResponseCode) {
        this.TXResponseCode = TXResponseCode;
    }

    public void setResponseExtraData(String responseExtraData) {
        this.responseExtraData = responseExtraData;
    }

    public void setExtraAmount(String extraAmount) {
        this.extraAmount = extraAmount;
    }

    public void setAcquireInstituteCode(Long acquireInstituteCode) {
        this.acquireInstituteCode = acquireInstituteCode;
    }

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

    public Date getTXSettlementDate() {
        return TXSettlementDate;
    }

    public TxProcessStatusType getTXResponseCode() {
        return TXResponseCode;
    }

    public String getResponseExtraData() {
        return responseExtraData;
    }

    public String getExtraAmount() {
        return extraAmount;
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

    public String getRawTXProcessCode() {
        return RawTXProcessCode;
    }

    public void setRawTXProcessCode(String rawTXProcessCode) {
        RawTXProcessCode = rawTXProcessCode;
    }

    public String getTXApprovalCode() {
        return TXApprovalCode;
    }

    public void setTXApprovalCode(String TXApprovalCode) {
        this.TXApprovalCode = TXApprovalCode;
    }
}
