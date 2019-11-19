package ir.navaco.mcb.credit.card.parser.transformer.dto;

import ir.navaco.mcb.credit.card.parser.enums.TxProcessCodeType;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessStatusType;

import java.util.Date;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class Message1614 extends MessageAbstract {
    private Long accountNo; //field 2
    private TxProcessCodeType TXProcessCode; //field 3
    private String RawTXProcessCode;
    private Date TXSettlementDate; //field 15
    private Long acquireInstituteCode; //field 32
    private Long senderInstituteCode; //field 33
    private String TXRefRecoverNo; //field 37
    private String TXApprovalCode; //field 38
    private TxProcessStatusType TXResponseCode; //field 39
    private String TXAcquirePosNumber; //field 41
    private String cardAcquireNumber; //field 42
    private String responseExtraData; //field 44
    private String extraAmount; //field 54
    private String TXCoding; //field 62
    private String receiverInstituteCode; //field 100

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

    public Date getTXSettlementDate() {
        return TXSettlementDate;
    }

    public void setTXSettlementDate(Date TXSettlementDate) {
        this.TXSettlementDate = TXSettlementDate;
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
}
