package ir.navaco.mcb.credit.card;

import ir.navaco.mcb.credit.card.camel.CamelService;
import ir.navaco.mcb.credit.card.camel.routes.CamelConfigurationRoute;
import ir.navaco.mcb.credit.card.config.Q2ServerConfiguration;
import ir.navaco.mcb.credit.card.database.HandleDB;
import ir.navaco.mcb.credit.card.database.hibernate.HibernateUtil;
import ir.navaco.mcb.credit.card.transaction.Q2Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class JPOSGatewayApplication {

    public static void main(String[] args) throws Exception {
        /*CamelService camelService = new CamelService();

        // create configuration for camel service
        CamelConfigurationRoute configuration = new CamelConfigurationRoute();
        // set port for rest service that camel will listen to that.
        configuration.setPortNumber(9000);
        // set desirable name as route id for configuration route.
        configuration.setRouteId("configuration");

        // add routes to camel service.
        camelService.addRoute(configuration);

        // run camel.
        camelService.run();

        // -------------------- SPRING -------------------------
        ApplicationContext springContext = new AnnotationConfigApplicationContext();

        HibernateUtil hibernateUtil = new HibernateUtil();
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        // -------------------- DB Handle -------------------
        HandleDB db = new HandleDB();
        db.findAllRoutes();
        */
        Q2ServerConfiguration serverConfiguration = new Q2ServerConfiguration();
        System.out.println(serverConfiguration.getDeployDirectory());

//        Q2Service q2Service = new Q2Service(serverConfiguration.getDeployDirectory());
        Q2Service q2Service = new Q2Service(null);
        q2Service.start();
    }

}
