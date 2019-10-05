package ir.navaco.mcb.credit.card.camel.routes.control;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public interface RouteManagerFunction {
    void addRoute(JPOSRoute route);
    void removeRoute(String routeId);
}
