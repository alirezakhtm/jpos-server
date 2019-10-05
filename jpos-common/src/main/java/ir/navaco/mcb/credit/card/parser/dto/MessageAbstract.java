package ir.navaco.mcb.credit.card.parser.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ir.navaco.mcb.credit.card.parser.enums.MessageType;
import ir.navaco.mcb.credit.card.parser.exception.ISOFieldOutOfSizeException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalAmountException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import ir.navaco.mcb.credit.card.parser.helper.ISOParseHelper;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;

import java.text.ParseException;
import java.util.BitSet;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Parent Dto of all type of iso 8583 messages with shared parameters and default methods.
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public abstract class MessageAbstract implements IMessage, IMessageParser{
    /**
     * all type of 8583 messages included these fields.
     */
    @JsonBackReference
    protected ISOMsg isoMsg;
    protected String primaryBinaryDesign;
    protected String secondaryBinaryDesign; //field 1
    protected Date sentDataToShetabDt; //field 7
    protected Long TXId; //field 11
    protected Date TXDateTime; //field 12
    protected String mac; //field 64|128

    public MessageAbstract() {}

    /**
     * constructor for each field will check if isoMsg has the field and will parse in an appropriate way using parseHelper.
     * @param isoMsg
     * @throws ISOException
     * @throws ParseException
     */
    public MessageAbstract(ISOMsg isoMsg) throws ISOException, ParseException, IllegalAmountException, IllegalCurrencyException, ISOFieldOutOfSizeException {
        setIsoMsg(isoMsg);
        BitSet msgBitSet = (BitSet) isoMsg.getValue(-1);
        primaryBinaryDesign = ISOUtil.hexString(ISOUtil.bitSet2byte(msgBitSet), 0, 8);
        secondaryBinaryDesign = ISOUtil.hexString(ISOUtil.bitSet2byte(msgBitSet), 8, 8);
        sentDataToShetabDt = parse(ISOParseHelper::parseDate,7, "MMddhhmmss");
        TXId = parse(ISOParseHelper::parseLong,11);
        TXDateTime = parse(ISOParseHelper::parseDate,12, "yyMMddhhmmss");
        mac = (parse(s->s,64) != null) ? parse(s->s,64) : parse(s->s,128);
    }

    public void packMessageInto() throws ISOException, IllegalCurrencyException, ISOFieldOutOfSizeException, IllegalAmountException, ParseException {
        setIsoMsg(new ISOMsg());
        isoMsg.setMTI(String.valueOf(getMTI().getCode()));
        fill(ISOParseHelper::dateToString, 7, sentDataToShetabDt, "MMddhhmmss");
        fill(s->s.toString(),11, TXId);
        fill(ISOParseHelper::dateToString, 12, TXDateTime, "yyMMddhhmmss");
    }

    protected void generateBitSets() throws IllegalAmountException, ISOException, IllegalCurrencyException, ParseException {
        isoMsg.recalcBitMap();
        BitSet msgBitSet = (BitSet) isoMsg.getValue(-1);

        byte msgBitsetByte[] = ISOUtil.bitSet2byte(msgBitSet);
        primaryBinaryDesign = ISOUtil.hexString(msgBitsetByte, 0, 8);
        if(msgBitsetByte.length > 8)
            secondaryBinaryDesign = ISOUtil.hexString(msgBitsetByte, 8, 8);
    }

    //@todo for all messages
    public abstract void generateMac();

    public abstract MessageType getMTI();

    public ISOMsg getIsoMsg() {
        return isoMsg;
    }

    public String getPrimaryBinaryDesign() {
        return primaryBinaryDesign;
    }

    public Date getSentDataToShetabDt() {
        return sentDataToShetabDt;
    }

    public Long getTXId() {
        return TXId;
    }

    public Date getTXDateTime() {
        return TXDateTime;
    }

    public String getMac() {
        return mac;
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

    public void setMac(String mac) {
        this.mac = mac;
    }

    public void setSentDataToShetabDt(Date sentDataToShetabDt) {
        this.sentDataToShetabDt = sentDataToShetabDt;
    }

    public void setTXId(Long TXId) {
        this.TXId = TXId;
    }

    public void setTXDateTime(Date TXDateTime) {
        this.TXDateTime = TXDateTime;
    }

    public void setIsoMsg(ISOMsg isoMsg) {
        this.isoMsg = isoMsg;
    }

    @Override
    /**
     * to make an string of message field for test.
     */
    public String toString() {
        List<String> st = printClass(getClass().getSuperclass(),this);
        st.addAll(printClass(getClass(),this));
        return  st.stream().collect(Collectors.joining( "," ));
    }
}
