package ir.navaco.mcb.credit.card.database;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.navaco.mcb.credit.card.database.dto.MessagePolicy;
import ir.navaco.mcb.credit.card.database.entity.JPOSRoute;
import ir.navaco.mcb.credit.card.database.hibernate.HibernateUtil;
import ir.navaco.mcb.credit.card.logger.JPOSLogger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String hql = "FROM JPOSRoute C";
        Query query = session.createQuery(hql);
        List<JPOSRoute> JPOSRoutes = query.list();
        session.close();
        logger.info("Routes has been fetched from database, number of routes is >> " + JPOSRoutes.size());
        JPOSRoutes.forEach(JPOSRoute -> {
            logger.info(String.format(JPOSRoute.toString()));
        });
        return JPOSRoutes;
    }

    public Map<Integer, MessagePolicy> getAllPolicy(){
        Map<Integer, MessagePolicy> policiesMap = new HashMap<>();
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "FROM MessagePolicy M";
        Query query = session.createQuery(hql);
        List<ir.navaco.mcb.credit.card.database.entity.MessagePolicy> lstPolicies = query.list();
        session.close();
        logger.info("Policies has been fetched from database, number of policies is >> " + lstPolicies.size());
        Gson gson = new GsonBuilder().create();
        lstPolicies.forEach(messagePolicy -> {
            MessagePolicy policy = new MessagePolicy();
            policy.setId(messagePolicy.getId());
            policy.setMti(messagePolicy.getMti());
            List<Integer> pCode = (gson.fromJson(messagePolicy.getJsonProcessCode(), IntegerList.class)).getLst();
            String[] strPCode = new String[pCode.size()];
            for (int i = 0; i < pCode.size(); i++) {
                strPCode[i] = String.valueOf(pCode.get(i));
            }
            policy.setProcessCode(strPCode);
            policiesMap.put(messagePolicy.getMti(), policy);
        });
        return policiesMap;
    }

}

class IntegerList{
    private List<Integer> lst;

    public List<Integer> getLst() {
        return lst;
    }

    public void setLst(List<Integer> lst) {
        this.lst = lst;
    }
}