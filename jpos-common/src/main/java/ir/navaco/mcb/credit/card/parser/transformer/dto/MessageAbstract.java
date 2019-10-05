package ir.navaco.mcb.credit.card.parser.transformer.dto;

import java.util.Date;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public abstract class MessageAbstract {
    protected String primaryBinaryDesign;
    protected String secondaryBinaryDesign; //field 1
    protected Date sentDataToShetabDt; //field 7
    protected Long TXId; //field 11
    protected Date TXDateTime; //field 12
    protected String mac; //field 64|128
    protected byte[] isoMsgPack;

    public String getPrimaryBinaryDesign() {
        return primaryBinaryDesign;
    }

    public void setPrimaryBinaryDesign(String primaryBinaryDesign) {
        this.primaryBinaryDesign = primaryBinaryDesign;
    }

    public String getSecondaryBinaryDesign() {
        return secondaryBinaryDesign;
    }

    public void setSecondaryBinaryDesign(String secondaryBinaryDesign) {
        this.secondaryBinaryDesign = secondaryBinaryDesign;
    }

    public Date getSentDataToShetabDt() {
        return sentDataToShetabDt;
    }

    public void setSentDataToShetabDt(Date sentDataToShetabDt) {
        this.sentDataToShetabDt = sentDataToShetabDt;
    }

    public Long getTXId() {
        return TXId;
    }

    public void setTXId(Long TXId) {
        this.TXId = TXId;
    }

    public Date getTXDateTime() {
        return TXDateTime;
    }

    public void setTXDateTime(Date TXDateTime) {
        this.TXDateTime = TXDateTime;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public byte[] getIsoMsgPack() {
        return isoMsgPack;
    }

    public void setIsoMsgPack(byte[] isoMsgPack) {
        this.isoMsgPack = isoMsgPack;
    }
}
