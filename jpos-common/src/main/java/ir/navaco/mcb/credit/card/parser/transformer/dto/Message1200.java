package ir.navaco.mcb.credit.card.parser.transformer.dto;

import ir.navaco.mcb.credit.card.parser.dto.pooya.AdditionalTxData;
import ir.navaco.mcb.credit.card.parser.enums.FunctionCodeType;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessCodeType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class Message1200 extends MessageAbstract {
    private Long accountNo; //field 2
    private String RawTXProcessCode;
    private TxProcessCodeType TXProcessCode; //field 3
    private BigDecimal TXAmountAcquire; //field 4
    private String dateExpiration; //field 14 (comes in persian)
    private Date TXReceiveDateTime; //field 17
    private Short merchantType; //field 18 (Pooya Transactions)
    private String posInfo; //field 22
    private FunctionCodeType functionCode; //field 24
    private Long acquireInstituteCode; //field 32
    private Long senderInstituteCode; //field 33
    private String track2Data; //field 35
    private String TXRefRecoverNo; //field 37
    private String TXAcquirePosNumber; //field 41
    private String cardAcquireNumber; //field 42
    private String cardAcquireNameLocation; //field 43
//    private AdditionalTxData additionalData; //field 48
    private String TXCurrency; //field 49
    private String TXCoding; //field 62 (NOTinPooya)
    private String dataRecord;//field 72 (Pooya Transactions)
    private String accountIdentification; //field 102 (Pooya Transactions)
    private String pooyaTxReserved; //field 113 (Pooya Transactions)

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public String getRawTXProcessCode() {
        return RawTXProcessCode;
    }

    public void setRawTXProcessCode(String rawTXProcessCode) {
        RawTXProcessCode = rawTXProcessCode;
    }

    public TxProcessCodeType getTXProcessCode() {
        return TXProcessCode;
    }

    public void setTXProcessCode(TxProcessCodeType TXProcessCode) {
        this.TXProcessCode = TXProcessCode;
    }

    public BigDecimal getTXAmountAcquire() {
        return TXAmountAcquire;
    }

    public void setTXAmountAcquire(BigDecimal TXAmountAcquire) {
        this.TXAmountAcquire = TXAmountAcquire;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Date getTXReceiveDateTime() {
        return TXReceiveDateTime;
    }

    public void setTXReceiveDateTime(Date TXReceiveDateTime) {
        this.TXReceiveDateTime = TXReceiveDateTime;
    }

    public Short getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(Short merchantType) {
        this.merchantType = merchantType;
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

    public Long getAcquireInstituteCode() {
        return acquireInstituteCode;
    }

    public void setAcquireInstituteCode(Long acquireInstituteCode) {
        this.acquireInstituteCode = acquireInstituteCode;
    }

    public Long getSenderInstituteCode() {
        return senderInstituteCode;
    }

    public void setSenderInstituteCode(Long senderInstituteCode) {
        this.senderInstituteCode = senderInstituteCode;
    }

    public String getTrack2Data() {
        return track2Data;
    }

    public void setTrack2Data(String track2Data) {
        this.track2Data = track2Data;
    }

    public String getTXRefRecoverNo() {
        return TXRefRecoverNo;
    }

    public void setTXRefRecoverNo(String TXRefRecoverNo) {
        this.TXRefRecoverNo = TXRefRecoverNo;
    }

    public String getTXAcquirePosNumber() {
        return TXAcquirePosNumber;
    }

    public void setTXAcquirePosNumber(String TXAcquirePosNumber) {
        this.TXAcquirePosNumber = TXAcquirePosNumber;
    }

    public String getCardAcquireNumber() {
        return cardAcquireNumber;
    }

    public void setCardAcquireNumber(String cardAcquireNumber) {
        this.cardAcquireNumber = cardAcquireNumber;
    }

    public String getCardAcquireNameLocation() {
        return cardAcquireNameLocation;
    }

    public void setCardAcquireNameLocation(String cardAcquireNameLocation) {
        this.cardAcquireNameLocation = cardAcquireNameLocation;
    }

    /*public AdditionalTxData getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(AdditionalTxData additionalData) {
        this.additionalData = additionalData;
    }*/

    public String getTXCurrency() {
        return TXCurrency;
    }

    public void setTXCurrency(String TXCurrency) {
        this.TXCurrency = TXCurrency;
    }

    public String getTXCoding() {
        return TXCoding;
    }

    public void setTXCoding(String TXCoding) {
        this.TXCoding = TXCoding;
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
