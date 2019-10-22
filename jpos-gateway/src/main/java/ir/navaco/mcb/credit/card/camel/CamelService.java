package ir.navaco.mcb.credit.card.camel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.navaco.mcb.credit.card.camel.routes.control.RouteManager;
import ir.navaco.mcb.credit.card.config.CamelConfiguration;
import ir.navaco.mcb.credit.card.database.HandleDB;
import ir.navaco.mcb.credit.card.database.entity.JPOSRoute;
import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Start camel service
 *
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class CamelService extends RouteManager {

    private static CamelContext context = null;
    private HandleDB db;
    private static Gson gson = null;

    private static final String TAG = "CamelService";
    private JPOSLogger logger = new JPOSLogger(TAG);

    private CamelConfiguration camelConfiguration;

    // this directory is location that all request jpos will be stored on it.
    private static String fileLocation = null;

    public CamelService() {
        super();
        BasicConfigurator.configure();
        db = new HandleDB();
        super.routeBuilderMap = new HashMap<>();
        if (this.context == null) {
            context = new DefaultCamelContext();
            logger.info("Unique camel context has been created.");
        }
        gson = gson == null ? new GsonBuilder().create() : gson;
        try {
            camelConfiguration = new CamelConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileLocation = camelConfiguration.getDirectoryInputRequest();
    }

    @Override
    public void addRoute(ir.navaco.mcb.credit.card.camel.routes.control.JPOSRoute route) {
        super.addRoute(route);
        logger.info("New route added to the route repository. [route-id :: " + route.getRouteId() + "]");
        restartCamelService();
    }

    @Override
    public void removeRoute(String routeId) {
        super.removeRoute(routeId);
        restartCamelService();
    }

    private void restartCamelService() {
        context.stop();
        logger.info("Camel context stopped.");
        context = new DefaultCamelContext();
        logger.info("Camel context cleared.");
        addAllRoutes();
        context.start();
        logger.info("Camel context started.");
    }

    private void addAllRoutes() {
        String messageFormat = "Camel route [%s] added to context.";
        super.routeBuilderMap.forEach((s, jposRoute) -> {
            try {
                context.addRoutes(jposRoute);
                logger.info(String.format(messageFormat, s));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void run(){
        addAllRoutes();
        context.start();
    }

    public void startDefault(){
        List<JPOSRoute> JPOSRoutes = db.findAllRoutes();
        List<ir.navaco.mcb.credit.card.camel.dto.JPOSRoute> jposRoutes = new ArrayList<>();
        JPOSRoutes.forEach(JPOSRoute -> {
            String jsonJPOSRoute = JPOSRoute.getJsonJposRoute();
            jposRoutes.add(gson.fromJson(jsonJPOSRoute, ir.navaco.mcb.credit.card.camel.dto.JPOSRoute.class));
        });
        // todo -- create one class for these classes to convert jposroute dto to jposroute of that
        // todo -- extended from RouteBuilder then add them into the routeBuilderMap
        List<ir.navaco.mcb.credit.card.camel.routes.control.JPOSRoute> jposRouteList = this.convertToJPOSRoute(jposRoutes);
        jposRouteList.forEach(jposRoute -> {
            super.addRoute(jposRoute);
        });
    }

    private List<ir.navaco.mcb.credit.card.camel.routes.control.JPOSRoute> convertToJPOSRoute(List<ir.navaco.mcb.credit.card.camel.dto.JPOSRoute> jposRoutes) {
        return null;
    }
}
