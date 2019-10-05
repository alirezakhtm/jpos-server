package ir.navaco.mcb.credit.card.parser.dto;

import ir.navaco.mcb.credit.card.parser.exception.ISOFieldOutOfSizeException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalAmountException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import ir.navaco.mcb.credit.card.parser.functionalInterface.CheckedBiFunction;
import ir.navaco.mcb.credit.card.parser.functionalInterface.CheckedFunction;
import org.jpos.iso.ISOException;
import org.jpos.tlv.GenericTagSequence;
import org.jpos.tlv.LiteralTagValue;

import java.text.ParseException;

/**
 * this class would help to parse and fill an isoMessage
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public interface ITLVParser {
    /**
     * Check if not null set field via given function or return null.
     * @param fn biFunction Interface (static functions from Helper)
     * @param tag tag name
     */
    default  <T> void fill(CheckedFunction<T, String> fn, String tag, T param) throws ISOException, IllegalCurrencyException, ISOFieldOutOfSizeException, IllegalAmountException, ParseException {
        if (param != null) getTagValueSequence().add(new LiteralTagValue(tag, fn.apply(param)));
    }

    /**
     * To set using one extra field (ex: date format, currency, ...)
     * @param bi biFunction Interface (static functions from Helpers)
     * @param tag tag name
     */
    default <T, U> void fill(CheckedBiFunction<T, U, String> bi, String tag, T param, U f2) throws ISOException, ParseException, IllegalAmountException, IllegalCurrencyException, ISOFieldOutOfSizeException {
        if (param != null) getTagValueSequence().add(new LiteralTagValue(tag, bi.apply(param, f2)));
    }

    /**
     * Check if exist parse via given function or return null.
     * @param fn biFunction Interface (static functions from Helper)
     * @param tag tag name
     * @return <R> would be: Integer, Double, String, BigDecimal, Date
     */
    default <R> R parse(CheckedFunction<String, R> fn, String tag) throws ParseException, IllegalAmountException, IllegalCurrencyException, ISOException {
        return getTagValueSequence().hasTag(tag) ? fn.apply((String) getTagValueSequence().getFirst(tag).getValue()) : null;
    }

    /**
     * To parse tag using one extra field (ex: date format, currency, ...)
     * @param bi biFunction Interface (static functions from Helpers)
     * @param tag tag name
     * @return <R> would be: Integer, Double, String, BigDecimal, Date
     */
    default <R, U> R parse(CheckedBiFunction<String, U, R> bi, String tag, U f2) throws ISOException, ParseException, IllegalAmountException, IllegalCurrencyException, ISOFieldOutOfSizeException {
        return getTagValueSequence().hasTag(tag) ? bi.apply((String) getTagValueSequence().getFirst(tag).getValue(), f2) : null;
    }

    public GenericTagSequence getTagValueSequence();
}
