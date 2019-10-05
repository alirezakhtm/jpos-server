package ir.navaco.mcb.credit.card.parser.dto;

import ir.navaco.mcb.credit.card.parser.exception.ISOFieldOutOfSizeException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalAmountException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import ir.navaco.mcb.credit.card.parser.functionalInterface.CheckedBiFunction;
import ir.navaco.mcb.credit.card.parser.functionalInterface.CheckedFunction;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * this class would help to parse and fill an isoMessage
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public interface IMessageParser {
    /**
     * Check if exist parse via given function or return null.
     * @param fn biFunction Interface (static functions from Helper)
     * @param f field number
     */
    default  <T, V> void fill(CheckedFunction<T, String> fn, V f, T param) throws ISOException, IllegalCurrencyException, ISOFieldOutOfSizeException, IllegalAmountException, ParseException {
        String field = String.valueOf(f);
        if (param != null) getIsoMsg().set(field, fn.apply(param));
    }

    /**
     * To parse using one extra field (ex: date format, currency, ...)
     * @param bi biFunction Interface (static functions from Helpers)
     * @param f field number
     */
    default <T, U, V> void fill(CheckedBiFunction<T, U, String> bi, V f, T param, U f2) throws ISOException, ParseException, IllegalAmountException, IllegalCurrencyException, ISOFieldOutOfSizeException {
        String field = String.valueOf(f);
        if (param != null) getIsoMsg().set(field, bi.apply(param, f2));
    }

    /**
     * Check if exist parse via given function or return null.
     * @param fn biFunction Interface (static functions from Helper)
     * @param f field number
     * @return <R> would be: Integer, Double, String, BigDecimal, Date
     */
    default <R, V> R parse(CheckedFunction<String, R> fn, V f) throws ParseException, IllegalAmountException, IllegalCurrencyException, ISOException {
        String field = String.valueOf(f);
        return getIsoMsg().hasField(field) ? fn.apply(getIsoMsg().getString(field)) : null;
    }

    /**
     * To parse using one extra field (ex: date format, currency, ...)
     * @param bi biFunction Interface (static functions from Helpers)
     * @param f field number
     * @return <R> would be: Integer, Double, String, BigDecimal, Date
     */
    default <R, T, U> R parse(CheckedBiFunction<String, U, R> bi, T f, U f2) throws ISOException, ParseException, IllegalAmountException, IllegalCurrencyException, ISOFieldOutOfSizeException {
        String field = String.valueOf(f);
        return getIsoMsg().hasField(field) ? bi.apply(getIsoMsg().getString(field), f2) : null;
    }

    /**
     * to make a simple array list of declared fields.
     *
     * @param cls the class
     * @param obj current object
     * @return ArrayList<String> ex: ["MIT: 1200", "TXId: 31000", ...]
     */
    default List<String> printClass(Class<?> cls, Object obj) {
        List<String> fields = new ArrayList<>();
        for ( Field field : cls.getDeclaredFields() ) {
            field.setAccessible(true);
            try {
                fields.add(field.getName() + ": " + field.get(obj));
            } catch (IllegalAccessException e) {
                fields.add(field.getName() + ": " + e.toString());
            }
        }
        return fields;
    }

    public ISOMsg getIsoMsg();
}
