package ir.navaco.mcb.credit.card.camel.routes;

import ir.navaco.mcb.credit.card.camel.routes.control.JPOSRoute;
import org.apache.camel.model.rest.RestBindingMode;

/**
 * This class used to configure camel for rest services
 *
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class CamelConfigurationRoute extends JPOSRoute {

    private int portNumber;
    private String routeId;

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    @Override
    public void configure() throws Exception {
        restConfiguration("rest-api")
                .component("restlet")
                .host("localhost")
                .port(this.portNumber)
                .bindingMode(RestBindingMode.json);
    }

    @Override
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @Override
    public String getRouteId() {
        return this.routeId;
    }
}
