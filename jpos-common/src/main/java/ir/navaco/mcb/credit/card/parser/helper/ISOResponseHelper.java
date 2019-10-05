package ir.navaco.mcb.credit.card.parser.helper;

import ir.navaco.mcb.credit.card.parser.enums.AccountType;
import ir.navaco.mcb.credit.card.parser.enums.AmountType;
import ir.navaco.mcb.credit.card.parser.exception.IllegalCurrencyException;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOUtil;

import java.math.BigDecimal;

/**
 * This class would help to generate transaction response
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class ISOResponseHelper {

    /**
     * Includes:
     * - Account type (positions 1 - 2)
     * - Amount type (positions 3 - 4)
     * - Currency code (positions 5 - 7)
     * - Amount sign (position 8) - "C" or "D"
     * - Amount (position 9 - 20)
     *
     * @todo handle catches
     */
    public static String generateAdditionalAmount(AccountType account, AmountType type, String currency, BigDecimal amount) {
        StringBuilder output = new StringBuilder();

        try {
            output.append(ISOUtil.zeropad(account.getCode(), 2));
            output.append(ISOUtil.zeropad(type.getCode(), 2));
            output.append(currency);
            if(amount.compareTo(BigDecimal.ZERO) >= 0)
                output.append('C');
            else
                output.append('D');
            output.append(ISOUtil.zeropad(ISOParseHelper.amountToString(amount.abs(), currency), 12));
        }catch (IllegalCurrencyException e){

        }catch (ISOException e){

        }

        return output.toString();
    }
}
