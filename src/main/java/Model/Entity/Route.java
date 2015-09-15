package Model.Entity;

/**
 * Created by Δενθρ on 12.09.2015.
 */
public class Route {
    private Station from;
    private Station to;

    public Route(Station from, Station to) {
        this.from = from;
        this.to = to;
    }

    public Station getFrom() {
        return from;
    }

    public void setFrom(Station from) {
        this.from = from;
    }

    public Station getTo() {
        return to;
    }

    public void setTo(Station to) {
        this.to = to;
    }

    public int selectId() {
        return 0;
    }
}
