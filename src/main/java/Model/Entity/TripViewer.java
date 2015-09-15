package Model.Entity;

import java.sql.Time;
import java.util.Date;

/**
 * Created by ????? on 13.09.2015.
 */
public class TripViewer {
    private int id;
    private String from;
    private String to;
    private Date departure;
    private Time departureTime;
    private Date arrival;
    private Time arrivalTime;

    public TripViewer(int id, String from, String to, Date departure, Time departureTime, Date arrival, Time arrivalTime) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.departureTime = departureTime;
        this.arrival = arrival;
        this.arrivalTime = arrivalTime;
    }

    public TripViewer(int id, String from, String to, Date departure, Date arrival) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.arrival = arrival;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }


    public void setTo(String to) {
        this.to = to;
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

    public Time getDepartureTime() {
        return departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }
}