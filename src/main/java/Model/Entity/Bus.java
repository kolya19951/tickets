package Model.Entity;

/**
 * Created by Δενθρ on 12.09.2015.
 */
public class Bus {
    private String name;
    private int seats;

    public Bus(String name, int seats) {
        this.name = name;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
