package ir.navaco.mcb.credit.card.parser.dto;

import ir.navaco.mcb.credit.card.parser.enums.TxProcessCodeType;

import java.util.Date;

/**
 * Message types range Authorisation 11xx, Finance 12xx, Reversal 14xx
 * has shared fields can be use for validation
 * @author sa.gholizadeh <sa.gholizadeh@yahoo.com>
 */
public interface IRequestMessageFinAuthRev extends IRequestMessage{
    public Long getAccountNo();
    public TxProcessCodeType getTXProcessCode();
    public String getRawTXProcessCode();
    public Date getTXReceiveDateTime();
    public Long getAcquireInstituteCode();
    public String getTXRefRecoverNo();
    public String getTXAcquirePosNumber();
    public String getCardAcquireNumber();
    public String getTXCoding();
}
