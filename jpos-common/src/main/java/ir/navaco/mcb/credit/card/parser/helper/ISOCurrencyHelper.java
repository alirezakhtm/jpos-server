package ir.navaco.mcb.credit.card.parser.helper;

import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;

import java.util.Currency;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class ISOCurrencyHelper {

    /**
     * this method get currency code in int and find currency according to ISO7217 and return back fraction digits number.
     * @param currencyCode int
     * @return fraction digits number int.
     */
    public static int getDecimal(String currencyCode) throws IllegalCurrencyException {
        /**
         * according to documentation sent by SHAPARAK page no 35 of ISO 8583 doc.
         * in provided example iran currency (code: 364) fraction digit numbers is 0
         * but in Iso 4217 (as its mentioned to use) default is 2. so we need to check if currency is IRR return 0 as fraction digits num.
         */
        if(currencyCode.equals("364"))
            return 0;
        else {
            Set<Currency> currencySet = Currency.getAvailableCurrencies();
            List<Integer> decimalFormat = currencySet.stream()
                    .filter(c -> String.valueOf(c.getNumericCode()).equals(currencyCode))
                    .map(c -> c.getDefaultFractionDigits())
                    .collect(Collectors.toList());

            if (decimalFormat.size() != 1) {
                throw new IllegalCurrencyException(currencyCode + " code not founded in iso 4217 list");
            }

            return decimalFormat.get(0);
        }
    }
}