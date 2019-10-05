package ir.navaco.mcb.credit.card.parser.exception;
/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class UnSupportedMessageException extends Exception {
    public UnSupportedMessageException(String message){ super(message);}
    public UnSupportedMessageException(Throwable nested) {
        super(nested.toString());
    }
}
