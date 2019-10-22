package ir.navaco.mcb.credit.card.database.springdata.repository;

import ir.navaco.mcb.credit.card.database.entity.JPOSRoute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This repository contains all routes that registered in table of database.
 *
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */

@Component
public interface RouteRepository extends CrudRepository<JPOSRoute, Long> {
    List<JPOSRoute> findAll();
    JPOSRoute findById(long id);
    List<JPOSRoute> findAllByRouteId(String routeId);
}
