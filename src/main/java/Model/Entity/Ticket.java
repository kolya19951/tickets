package Model.Entity;

/**
 * Created by Δενθρ on 12.09.2015.
 */
public class Ticket {
    private Client client;
    private Seat seat;
    private double price;

    public Ticket(Client client, Seat seat, double price) {
        this.client = client;
        this.seat = seat;
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
