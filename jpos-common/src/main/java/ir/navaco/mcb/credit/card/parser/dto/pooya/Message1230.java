package ir.navaco.mcb.credit.card.parser.dto.pooya;

import ir.navaco.mcb.credit.card.parser.dto.IResponseMessageFinAuthRev;
import ir.navaco.mcb.credit.card.parser.dto.MessageAbstract;
import ir.navaco.mcb.credit.card.parser.dto.OriginalTx;
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

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

/**
 * 1230(response) Pooya 8583 message DTO
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class Message1230 extends MessageAbstract implements IResponseMessageFinAuthRev {

    private Long accountNo; //field 2
    private TxProcessCodeType TXProcessCode; //field 3
    private String RawTXProcessCode;
    private BigDecimal TXAmountAcquire; //field 4
    private Date TXSettlementDate; //field 15 (NOTinPooya)
    private Date TXReceiveDateTime; //field 17 (Pooya Transactions)
    private String posInfo; //field 22 (Pooya Transactions)
    private FunctionCodeType functionCode; //field 24 (Pooya Transactions)
    private Long acquireInstituteCode; //field 32
    private Long senderInstituteCode; //field 33 (Pooya Transactions)
    private String TXRefRecoverNo; //field 37
    private String TXApprovalCode; //field 38 (Pooya Transactions)
    private TxProcessStatusType TXResponseCode; //field 39
    private String TXAcquirePosNumber; //field 41
    private String cardAcquireNumber; //field 42
    private AdditionalTxData additionalData; //field 48 (Pooya Transactions)
    private String TXCurrency; //field 49
    private String extraAmount; //field 54 (Pooya Transactions)
    private OriginalTx originalTxData; //field 56 (Pooya Transactions)
    private String TXCoding; //field 62 (NOTinPooya)
    private String receiverInstituteCode; //field 100 (NOTinPooya)
    private String accountIdentification; //field 102 (Pooya Transactions)

    public Message1230() {}

    public Message1230(ISOMsg isoMsg) throws Exception{
        super(isoMsg);
        accountNo = parse(ISOParseHelper::parseLong,2);
        TXProcessCode = parse(ISOParseHelper::parseProcessCode,3);
        RawTXProcessCode = parse(s->s,3);
        TXCurrency = parse(s->s,49);
        if(TXCurrency != null)
            TXAmountAcquire = parse(ISOParseHelper::parseAmount,4, TXCurrency);
        TXSettlementDate = parse(ISOParseHelper::parseDate,15, "yyMMdd");
        TXReceiveDateTime = parse(ISOParseHelper::parseDate,17, "MMdd");
        posInfo = parse(s->s,22);
        functionCode = parse(ISOParseHelper::parseFunctionCode,24);
        acquireInstituteCode = parse(ISOParseHelper::parseLong,32);
        senderInstituteCode = parse(ISOParseHelper::parseLong,33);
        TXRefRecoverNo = parse(s->s,37);
        TXApprovalCode = parse(s->s,38);
        TXResponseCode = parse(ISOParseHelper::parseResponseCode,39);
        TXAcquirePosNumber = parse(s->s,41);
        cardAcquireNumber = parse(s->s,42);
        additionalData = new AdditionalTxData(isoMsg);
        extraAmount = parse(s->s,54);
        if(originalTxData != null)
            originalTxData = new OriginalTxData(isoMsg);
        TXCoding = parse(s->s,62);
        receiverInstituteCode = parse(s->s,100);
        accountIdentification = parse(s->s,102);
    }

    public void packMessageInto() throws IllegalCurrencyException, ISOFieldOutOfSizeException, ISOException, IllegalAmountException, ParseException {
        super.packMessageInto();

        fill(s->s.toString(),2, accountNo);
        fill(s->s,3, RawTXProcessCode);
        fill(s->s,49, TXCurrency);
        if(TXCurrency != null)
            fill(ISOParseHelper::amountToString, 4, TXAmountAcquire, TXCurrency);
        fill(ISOParseHelper::dateToString, 15, TXSettlementDate, "yyMMdd");
        fill(ISOParseHelper::dateToString, 17, TXReceiveDateTime, "MMdd");
        fill(s->s,22, posInfo);
        fill(s->s.toString(),24, functionCode);
        fill(s->s.toString(),32, acquireInstituteCode);
        fill(s->s.toString(),33, senderInstituteCode);
        fill(ISOParseHelper::addSpaces, 37, TXRefRecoverNo, 12); //f2 is field length
        fill(s->s,38, TXApprovalCode);
        fill(ISOParseHelper::resCodeToString,39, TXResponseCode, 3);
        fill(s->s,41, TXAcquirePosNumber);
        fill(s->s,42, cardAcquireNumber);
        if(additionalData != null)
            additionalData.packMessageInto(getIsoMsg());
        fill(s->s,54, extraAmount);
        if(originalTxData != null)
            originalTxData.packMessageInto(getIsoMsg());
        fill(s->s,62, TXCoding);
        fill(s->s,100, receiverInstituteCode);
        fill(s->s,102, accountIdentification);

        generateBitSets();
    }

    public void generateMac(){}

    public MessageType getMTI() { return MessageType.MTI_1230; }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public void setTXProcessCode(TxProcessCodeType TXProcessCode) {
        this.TXProcessCode = TXProcessCode;
    }

    public void setTXAmountAcquire(BigDecimal TXAmountAcquire) {
        this.TXAmountAcquire = TXAmountAcquire;
    }

    public void setTXSettlementDate(Date TXSettlementDate) {
        this.TXSettlementDate = TXSettlementDate;
    }

    public void setTXResponseCode(TxProcessStatusType TXResponseCode) {
        this.TXResponseCode = TXResponseCode;
    }

    public void setAcquireInstituteCode(Long acquireInstituteCode) {
        this.acquireInstituteCode = acquireInstituteCode;
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

    public Date getTXSettlementDate() {
        return TXSettlementDate;
    }

    public TxProcessStatusType getTXResponseCode() {
        return TXResponseCode;
    }

    public Long getAcquireInstituteCode() {
        return acquireInstituteCode;
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

    public Date getTXReceiveDateTime() {
        return TXReceiveDateTime;
    }

    public void setTXReceiveDateTime(Date TXReceiveDateTime) {
        this.TXReceiveDateTime = TXReceiveDateTime;
    }

    public String getPosInfo() {
        return posInfo;
    }

    public void setPosInfo(String posInfo) {
        this.posInfo = posInfo;
    }

    public FunctionCodeType getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(FunctionCodeType functionCode) {
        this.functionCode = functionCode;
    }

    public Long getSenderInstituteCode() {
        return senderInstituteCode;
    }

    public void setSenderInstituteCode(Long senderInstituteCode) {
        this.senderInstituteCode = senderInstituteCode;
    }

    public String getTXApprovalCode() {
        return TXApprovalCode;
    }

    public void setTXApprovalCode(String TXApprovalCode) {
        this.TXApprovalCode = TXApprovalCode;
    }

    public AdditionalTxData getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(AdditionalTxData additionalData) {
        this.additionalData = additionalData;
    }

    public String getExtraAmount() {
        return extraAmount;
    }

    public void setExtraAmount(String extraAmount) {
        this.extraAmount = extraAmount;
    }

    public String getAccountIdentification() {
        return accountIdentification;
    }

    public void setAccountIdentification(String accountIdentification) {
        this.accountIdentification = accountIdentification;
    }

    public OriginalTx getOriginalTxData() {
        return originalTxData;
    }

    public void setOriginalTxData(OriginalTx originalTxData) {
        this.originalTxData = originalTxData;
    }
}
