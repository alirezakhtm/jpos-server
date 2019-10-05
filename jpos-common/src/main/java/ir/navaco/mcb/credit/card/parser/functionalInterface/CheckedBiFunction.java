package ir.navaco.mcb.credit.card.parser.functionalInterface;

import ir.navaco.mcb.credit.card.parser.exception.ISOFieldOutOfSizeException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalAmountException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import org.jpos.iso.ISOException;

import java.text.ParseException;

/**
 * Standard BiFunction (functional interface) with exceptions
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
@FunctionalInterface
public interface CheckedBiFunction <T, U, R>{
    R apply(T t, U u) throws ISOException, ParseException, IllegalCurrencyException, IllegalAmountException, ISOFieldOutOfSizeException;
}
