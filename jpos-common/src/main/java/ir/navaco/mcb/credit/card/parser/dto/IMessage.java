package ir.navaco.mcb.credit.card.parser.dto;

import ir.navaco.mcb.credit.card.parser.enums.MessageType;
import org.jpos.iso.ISOMsg;

import java.util.Date;

/**
 * Iso 8583 message interface
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public interface IMessage {
    void generateMac();
    public ISOMsg getIsoMsg();
    public MessageType getMTI();
    public String getPrimaryBinaryDesign();
    public String getSecondaryBinaryDesign();
    public Date getSentDataToShetabDt();
    public Long getTXId();
    public Date getTXDateTime();
    public String getMac();

    public void setSentDataToShetabDt(Date sentDataToShetabDt);
    public void setTXId(Long TXId);
    public void setTXDateTime(Date TXDateTime);

    public void packMessageInto() throws Exception;
}
