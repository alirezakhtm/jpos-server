package ir.navaco.mcb.credit.card.database.hibernate;

import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.AnnotationConfiguration;

import java.io.File;
import java.io.InputStream;

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    private static final String TAG = "HibernateUtil";
    private JPOSLogger logger = new JPOSLogger(TAG);

    public HibernateUtil() {
        if (sessionFactory == null){
            sessionFactory = buildSessionFactory();
            if(sessionFactory != null) logger.info("SessionFactory has been built successfully.");
            else logger.error("Building SessionFactory has been failed.");
        }
    }

    private SessionFactory buildSessionFactory() {
        try {
            // this line of code must be changed when application wanted to deploy on docker container
            /*File config = new File(getClass().getClassLoader().getResource("hibernate.cfg.xml").getFile());*/
            File config = new File("/root/jpos/hibernate.cfg.xml");
            if(config.exists()) logger.info("File [" + config.getPath() + "] exists.");
            /*return new AnnotationConfiguration()
                    .configure(config)
                    .buildSessionFactory();*/
            return new Configuration().configure(config).buildSessionFactory();
        } catch (Throwable e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void shutdown() {
        getSessionFactory().close();
    }

}
