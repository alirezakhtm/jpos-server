package ir.navaco.mcb.credit.card.parser.exception;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class ISOFieldOutOfSizeException extends Exception {
    public ISOFieldOutOfSizeException(String message){ super(message);}
    public ISOFieldOutOfSizeException(Throwable nested) {
        super(nested.toString());
    }
}
