package ir.navaco.mcb.credit.card.database.springdata.repository;

import ir.navaco.mcb.credit.card.database.entity.CamelRoute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This repository contains all routes that registered in table of database.
 *
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 * */

@Component
public interface RouteRepository extends CrudRepository<CamelRoute, Long> {
    List<CamelRoute> findAll();
    CamelRoute findById(long id);
    List<CamelRoute> findAllByRouteId(String routeId);
}
