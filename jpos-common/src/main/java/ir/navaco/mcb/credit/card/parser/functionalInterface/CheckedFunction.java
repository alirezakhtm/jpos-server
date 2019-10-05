package ir.navaco.mcb.credit.card.parser.functionalInterface;

import ir.navaco.mcb.credit.card.parser.exception.IllegalAmountException;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import org.jpos.iso.ISOException;

import java.text.ParseException;

/**
 * Standard Function (functional interface) with Exceptions
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
@FunctionalInterface
public interface CheckedFunction<T, R>{
    R apply(T t) throws NumberFormatException, ParseException, IllegalAmountException, IllegalCurrencyException, ISOException;;
}
