package ir.navaco.mcb.credit.card.parser.exception;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class IllegalCurrencyException extends Exception {
    public IllegalCurrencyException(String message){ super(message);}
    public IllegalCurrencyException(Throwable nested) {
        super(nested.toString());
    }
}
