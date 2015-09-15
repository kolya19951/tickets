package Model.Hash;

import Model.Entity.City;
import Model.Observer.CitiesObserver;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author nbuser
 */
public class ComposerData {

    private HashMap cities = new HashMap();

    public HashMap getCities() {
        return cities;
    }

    public ComposerData() {

        //cities.put(1, new Composer("1", "Johann Sebastian", "Bach", "Baroque"));

        ArrayList<City> citiesList = CitiesObserver.selectCities();

        for (int i = 0; i < citiesList.size(); i++){
            cities.put((Integer)i, citiesList.get(i));
        }


    }
}