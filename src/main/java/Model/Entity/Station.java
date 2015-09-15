package Model.Entity;

/**
 * Created by Δενθρ on 12.09.2015.
 */
public class Station {
    private City city;
    private String name;

    public Station(City city, String name) {
        this.city = city;
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
