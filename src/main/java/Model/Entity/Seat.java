package Model.Entity;

/**
 * Created by Δενθρ on 12.09.2015.
 */
public class Seat {
    private int Id;
    private int tripId;
    private int seat_num;
    private double price;
    private int availability;

    public Seat(int id, int tripId, int seat_num, double price, int availability) {
        Id = id;
        this.tripId = tripId;
        this.seat_num = seat_num;
        this.price = price;
        this.availability = availability;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public Seat(int tripId, int seat_num, double price, int availability) {
        this.tripId = tripId;
        this.seat_num = seat_num;
        this.price = price;
        this.availability = availability;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTrip(int tripId) {
        this.tripId = tripId;
    }

    public int getSeat_num() {
        return seat_num;
    }

    public void setSeat_num(int seat_num) {
        this.seat_num = seat_num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
