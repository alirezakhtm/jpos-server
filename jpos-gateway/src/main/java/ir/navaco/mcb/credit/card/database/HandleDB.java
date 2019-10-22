package ir.navaco.mcb.credit.card.database;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.navaco.mcb.credit.card.database.entity.JPOSRoute;
import ir.navaco.mcb.credit.card.database.hibernate.HibernateUtil;
import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */
public class HandleDB {

    private HibernateUtil hibernateUtil;
    private JPOSLogger logger;
    private static final String TAG = "HandleDB";
    private static Gson gson = null;

    public HandleDB(){
        hibernateUtil = new HibernateUtil();
        logger = new JPOSLogger(TAG);
        gson = (gson == null) ? new GsonBuilder().create() : gson;
    }

    public List<JPOSRoute> findAllRoutes(){
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "FROM CamelRoute C";
        Query query = session.createQuery(hql);
        List<JPOSRoute> JPOSRoutes = query.list();
        session.close();
        logger.info("Routes has been fetched from database, number of routes is " + JPOSRoutes.size());
        JPOSRoutes.forEach(JPOSRoute -> {
            logger.info(String.format(JPOSRoute.toString()));
        });
        return JPOSRoutes;
    }

}
