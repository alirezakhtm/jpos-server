package ir.navaco.mcb.credit.card.parser.transformer.dto;

import ir.navaco.mcb.credit.card.parser.dto.OriginalTx;
import ir.navaco.mcb.credit.card.parser.enums.FunctionCodeType;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessCodeType;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessStatusType;

import java.math.BigDecimal;
import java.util.Date;

public class Message1430 extends MessageAbstract {
    private Long accountNo; //field 2
    private TxProcessCodeType TXProcessCode; //field 3
    private String RawTXProcessCode;
    private BigDecimal TXAmountAcquire; //field 4
    private String dateExpiration; //field 14 (Pooya Transactions, comes in persian)
    private Date TXSettlementDate; //field 15 (NOTinPooya)
    private Short merchantType; //field 18 (Pooya Transactions)
    private String posInfo; //field 22 (Pooya Transactions)
    private FunctionCodeType functionCode; //field 24 (Pooya Transactions)
    private Short reasonCode; //field 25 (Pooya Transactions)
    private Long acquireInstituteCode; //field 32
    private Long senderInstituteCode; //field 33
    private String track2Data; //field 35 (Pooya Transactions)
    private String TXRefRecoverNo; //field 37
    private String TXApprovalCode; //field 38 (Pooya Transactions)
    private TxProcessStatusType TXResponseCode; //field 39
    private String TXAcquirePosNumber; //field 41
    private String cardAcquireNumber; //field 42
    private String cardAcquireNameLocation; //field 43 (Pooya Transactions)
    private String TXCurrency; //field 49
    private OriginalTx originalTxData; //field 56 (Pooya Transactions)
    private String TXCoding; //field 62 (NOTinPooya)
    private String receiverInstituteCode; //field 100 (NOTinPooya)
    private String accountIdentification; //field 102 (Pooya Transactions)

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public TxProcessCodeType getTXProcessCode() {
        return TXProcessCode;
    }

    public void setTXProcessCode(TxProcessCodeType TXProcessCode) {
        this.TXProcessCode = TXProcessCode;
    }

    public String getRawTXProcessCode() {
        return RawTXProcessCode;
    }

    public void setRawTXProcessCode(String rawTXProcessCode) {
        RawTXProcessCode = rawTXProcessCode;
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

    public Date getTXSettlementDate() {
        return TXSettlementDate;
    }

    public void setTXSettlementDate(Date TXSettlementDate) {
        this.TXSettlementDate = TXSettlementDate;
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

    public Short getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(Short reasonCode) {
        this.reasonCode = reasonCode;
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

    public String getTXApprovalCode() {
        return TXApprovalCode;
    }

    public void setTXApprovalCode(String TXApprovalCode) {
        this.TXApprovalCode = TXApprovalCode;
    }

    public TxProcessStatusType getTXResponseCode() {
        return TXResponseCode;
    }

    public void setTXResponseCode(TxProcessStatusType TXResponseCode) {
        this.TXResponseCode = TXResponseCode;
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

    public String getTXCurrency() {
        return TXCurrency;
    }

    public void setTXCurrency(String TXCurrency) {
        this.TXCurrency = TXCurrency;
    }

    public OriginalTx getOriginalTxData() {
        return originalTxData;
    }

    public void setOriginalTxData(OriginalTx originalTxData) {
        this.originalTxData = originalTxData;
    }

    public String getTXCoding() {
        return TXCoding;
    }

    public void setTXCoding(String TXCoding) {
        this.TXCoding = TXCoding;
    }

    public String getReceiverInstituteCode() {
        return receiverInstituteCode;
    }

    public void setReceiverInstituteCode(String receiverInstituteCode) {
        this.receiverInstituteCode = receiverInstituteCode;
    }

    public String getAccountIdentification() {
        return accountIdentification;
    }

    public void setAccountIdentification(String accountIdentification) {
        this.accountIdentification = accountIdentification;
    }
}
