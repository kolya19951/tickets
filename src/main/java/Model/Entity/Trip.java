package Model.Entity;

import java.sql.Date;

/**
 * Created by Δενθρ on 12.09.2015.
 */
public class Trip {
    private int id;
    private Route route;
    private Date departure;
    private Date arrival;
    private Bus bus;

    public Trip(int id, Route route, Date departure, Date arrival, Bus bus) {
        this.id = id;
        this.route = route;
        this.departure = departure;
        this.arrival = arrival;
        this.bus = bus;
    }

    public Trip(Route route, Date departure, Date arrival, Bus bus) {
        this.route = route;
        this.departure = departure;
        this.arrival = arrival;
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
