package ir.navaco.mcb.credit.card.camel.dto;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class JPOSRoute {
    private int mti;
    private String destinationAddress;
    private String method;
    private String processCode;
    private String cardNumber;
    private String functionalCode;
    private String routeId;

    public int getMti() {
        return mti;
    }

    public void setMti(int mti) {
        this.mti = mti;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getFunctionalCode() {
        return functionalCode;
    }

    public void setFunctionalCode(String functionalCode) {
        this.functionalCode = functionalCode;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
}
