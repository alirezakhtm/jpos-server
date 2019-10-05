package ir.navaco.mcb.credit.card.parser.helper;

import ir.navaco.mcb.credit.card.parser.enums.FunctionCodeType;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessCodeType;
import ir.navaco.mcb.credit.card.parser.enums.TxProcessStatusType;
import ir.navaco.mcb.credit.card.parser.exception.ISOFieldOutOfSizeException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalAmountException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import org.jpos.iso.ISOUtil;

import java.math.BigDecimal;
import java.text.*;
import java.time.Year;
import java.util.Date;

import static java.text.NumberFormat.getInstance;

/**
 * ReplicaCardIssueServiceImpl helper to parse some Shetab special fields in iso 8583
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class ISOParseHelper {

    public static Integer parseInt(String field) throws NumberFormatException {
        if(field instanceof String) return Integer.parseInt(field);
        return null;
    }

    public static Short parseShort(String field) throws NumberFormatException {
        if(field instanceof String) return Short.parseShort(field);
        return null;
    }

    public static Double parseDouble(String field)throws NumberFormatException{
        if(field instanceof String) return Double.parseDouble(field);
        return null;
    }

    public static Number parseNumber(String field) throws ParseException {
        if(field instanceof String) return getInstance().parse(field);
        return null;
    }

    public static Long parseLong(String field) throws NumberFormatException{
        if(field instanceof String) return Long.parseLong(field);
        return null;
    }

    public static TxProcessCodeType parseProcessCode(String field) throws NumberFormatException{
        TxProcessCodeType result = null;
        if(field instanceof String) {
            result = TxProcessCodeType.findByCode(parseLong(field));
            if(result == null){
                String f = ISOUtil.zeropadRight(field.substring(0,2),6);
                result = TxProcessCodeType.findByCode(parseLong(f));
            }
        }
        return result;
    }

    public static FunctionCodeType parseFunctionCode(String field) throws NumberFormatException{
        if(field instanceof String) return FunctionCodeType.findByCode(parseInt(field));
        return null;
    }

    public static TxProcessStatusType parseResponseCode(String field) throws NumberFormatException{
        if(field instanceof String) return TxProcessStatusType.findByCode(parseInt(field));
        return null;
    }

    /**
     * I know there is (ISOCurrency.convertFromIsoMsg) method
     * but it uses standard currency fraction which is changed for iran. std: 2, used: 0 so here we need this function.
     *
     * amount is a string included fraction (according to currency code. decimal point is not included in string)
     * this method will add decimal point according to the currency code and cast it to double
     *
     * @param field to parse it to double as amount value
     * @param currencyCode based on ISO8383 it should give a currency code based on ISO4217
     * @return Double amount
     * @throws IllegalCurrencyException
     */
    public static BigDecimal parseAmount(String field, String currencyCode) throws IllegalCurrencyException, IllegalAmountException{
        if(field instanceof String) {
            int fractionNumber = ISOCurrencyHelper.getDecimal(currencyCode);
            if(fractionNumber == 0)
                return new BigDecimal(field);
            else if (field.length() > fractionNumber) {
                String updatedField = new StringBuilder(field).insert(field.length() - fractionNumber, ".").toString();
                return new BigDecimal(updatedField);
            } else {
                throw new IllegalAmountException("Something wrong!!! " + fractionNumber + " founded as fraction number!");
            }
        }
        return null;
    }

    private static BigDecimal flatAmount(BigDecimal doubleValue, int fractionNumber){
        if(fractionNumber > 0){
            for (int i=0; i< fractionNumber; ++i)
                doubleValue.multiply(new BigDecimal(10));
        }
        return doubleValue;

    }

    /**
     * as explained in parseAmount. this method is vice versa
     * @param field
     * @param currencyCode
     * @return
     * @throws IllegalCurrencyException
     */
    public static String amountToString(BigDecimal field, String currencyCode) throws IllegalCurrencyException{
        if(field instanceof BigDecimal) {
            int fractionNumber = ISOCurrencyHelper.getDecimal(currencyCode);
            field = flatAmount(field, fractionNumber);
            NumberFormat nf = new DecimalFormat("#");
            return nf.format(field);
        }
        return null;
    }

    /**
     * I know there is (ISODate.parseISODate) method but it has problem with converting MMdd format like card expire date ex: p17
     * parse string date to java.util.date standard object
     *
     * @param field String (field value ex: 190621523152 for format yyMMddhhmmss)
     * @param format String (format provided on shetab doc can be: yy MM dd hh mm ss)
     * @return date Date (standard java.util.Date)
     * @throws ParseException (on parsing format)
     */
    public static Date parseDate(String field, String format) throws ParseException {
        if(field instanceof String) {
            String thisYear = Year.now().toString();
            if(format.contains("Y") || format.contains("D")) {
                throw new ParseException("please use yy|yyyy for year and dd for day", 0);
            }

            if(format.contains("yy") && !format.contains("yyyy")) {
                format = "yy" + format;
                field = thisYear.substring(0, 2) + field;
            }else if(!format.contains("yyyy")) {
                format = "yyyy" + format;
                field = thisYear + field;
            }

            SimpleDateFormat originalFormat = new SimpleDateFormat(format);
            return originalFormat.parse(field);
        }
        return null;
    }

    public static String dateToString(Date date, String format){
        if(date instanceof Date) {
            DateFormat formatter = new SimpleDateFormat(format);
            return formatter.format(date);
        }
        return null;
    }

    /**
     * SHETAB has set this rule to add spaces for ex: P37 should fill with spaces up to 12 character length
     * @param field String iso field
     * @param length (the fixed length of field ex: P37 is 12)
     * @return String filed padded with spaces from it's right side as ruled by SHAPARAK
     * @throws ISOFieldOutOfSizeException
     */
    public static String addSpaces(String field, int length) throws ISOFieldOutOfSizeException {
        if(field.length() > length){
            throw new ISOFieldOutOfSizeException("the field should have the maximum " + length + "characters length");
        }

        return ISOUtil.strpad(field, length);
    }

    /**
     * to convert response code to string if it's not null and pad zeros before
     * @param resp TxProcessStatusType (response code)
     * @param length (standard length to zero pad if less)
     * @return field value String
     */
    public static String resCodeToString(TxProcessStatusType resp, int length) {
        if(resp instanceof TxProcessStatusType)
            return ISOUtil.zeropad(resp.getCode(), length);

        return null;
    }
}
