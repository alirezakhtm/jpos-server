package ir.navaco.mcb.credit.card.database.entity;

import com.google.gson.GsonBuilder;

import javax.persistence.*;

/**
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */

@Entity
@Table(name = "tbl_camel_route", schema = "dbjpos",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "ID"),
                @UniqueConstraint(columnNames = "ROUTE_ID")
        })
public class CamelRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;
    @Column(name = "ROUTE_ID", unique = true, nullable = false)
    private String routeId;
    // this string contains json model of object that contains all needs as MTI number,
    // destination (in first version it is address and in future it will be
    // application name for calling from eureka server)
    @Column(name = "JPOS_ROUTE")
    private String jsonJposRoute;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getJsonJposRoute() {
        return jsonJposRoute;
    }

    public void setJsonJposRoute(String jsonJposRoute) {
        this.jsonJposRoute = jsonJposRoute;
    }

    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, this.getClass());
    }
}
