package ir.navaco.mcb.credit.card.parser.exception;
/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class IllegalAmountException extends Exception {
    public IllegalAmountException(String message){ super(message);}
    public IllegalAmountException(Throwable nested) {
        super(nested.toString());
    }
}
