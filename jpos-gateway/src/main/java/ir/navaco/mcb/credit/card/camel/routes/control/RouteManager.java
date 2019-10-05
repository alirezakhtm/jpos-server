package ir.navaco.mcb.credit.card.camel.routes.control;

import java.util.Map;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public abstract class RouteManager implements RouteManagerFunction{

    protected Map<String, JPOSRoute> routeBuilderMap;

    @Override
    public void addRoute(JPOSRoute route) {
        this.routeBuilderMap.put(route.getRouteId(), route);
    }

    @Override
    public void removeRoute(String routeId) {
        if(this.routeBuilderMap.keySet().contains(routeId))
            this.routeBuilderMap.remove(routeId);
    }

}
