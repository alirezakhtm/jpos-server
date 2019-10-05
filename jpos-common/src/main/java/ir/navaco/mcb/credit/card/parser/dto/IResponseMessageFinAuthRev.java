package ir.navaco.mcb.credit.card.parser.dto;

import ir.navaco.mcb.credit.card.parser.enums.TxProcessCodeType;

import java.util.Date;

/**
 * Message types range Authorisation 11xx, Finance 12xx, Reversal 14xx
 * has shared fields can be use for validation
 * @author sa.gholizadeh <sa.gholizadeh@yahoo.com>
 */
public interface IResponseMessageFinAuthRev extends IResponseMessage{
    public Long getAccountNo();
    public TxProcessCodeType getTXProcessCode();
    public Date getTXSettlementDate();
    public Long getAcquireInstituteCode();
    public String getTXRefRecoverNo();
    public String getTXAcquirePosNumber();
    public String getCardAcquireNumber();
    public String getTXCoding();
    public String getReceiverInstituteCode();
    public String getRawTXProcessCode();
    public String getTXApprovalCode();

    public void setRawTXProcessCode(String rawTXProcessCode);
    public void setAccountNo(Long accountNo);
    public void setTXProcessCode(TxProcessCodeType TXProcessCode);
    public void setTXSettlementDate(Date TXSettlementDate);
    public void setAcquireInstituteCode(Long acquireInstituteCode);
    public void setTXRefRecoverNo(String TXRefRecoverNo);
    public void setTXAcquirePosNumber(String TXAcquirePosNumber);
    public void setCardAcquireNumber(String cardAcquireNumber);
    public void setTXCoding(String TXCoding);
    public void setReceiverInstituteCode(String receiverInstituteCode);
    public void setTXApprovalCode(String TXApprovalCode);
}
