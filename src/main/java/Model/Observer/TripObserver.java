package Model.Observer;

import Model.Entity.City;
import Model.Entity.Trip;
import Model.Entity.TripViewer;
import database.DBWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by ????? on 12.09.2015.
 */
public abstract class TripObserver {
    public static ArrayList<Trip> findTripsByCities(City fromCity, City toCity) {
        ArrayList<Trip> trips = new ArrayList<Trip>();
        //DBWorker dbWorker = new DBWorker();
        //int fromCityId = fromCity.selectId();
        //int toCityId = toCity.selectId();

        ResultSet resultSet = null;
        String query = "SELECT * FROM trips, routes WHERE\n" +
                "       routes.Id = trips.route       \n" +
                "       AND\n" +
                "       routes.from = (SELECT Id FROM cities WHERE name = '" + fromCity.getName() + "')\n" +
                "       AND\n" +
                "       routes.to = (SELECT Id FROM cities WHERE name = '" + toCity.getName() + "')";
        DBWorker dbWorker = new DBWorker();
        resultSet = dbWorker.executeQuery(query);
        try {
            while (resultSet.next()) {
                //trips.add(new Trip(resultSet.getInt("Id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trips;
    }
    public static ArrayList<TripViewer> findTripsViewersByCities(City fromCity, City toCity) {
        ArrayList<TripViewer> tripViewers = new ArrayList<TripViewer>();
        ResultSet resultSet = null;
        String query = "SELECT trips.Id, s1.name, s2.name, trips.departure, trips.arrival FROM trips, routes, stations s1, stations s2 WHERE\n" +
                "       routes.Id = trips.route       \n" +
                "       AND\n" +
                "       routes.from = s1.Id\n" +
                "       AND       \n" +
                "       routes.to = s2.Id       \n" +
                "       AND\n" +
                "       s1.city = (SELECT Id FROM cities WHERE name = '" + fromCity.getName() + "')\n" +
                "       AND\n" +
                "       s2.city = (SELECT Id FROM cities WHERE name = '" + toCity.getName() + "')";
        DBWorker dbWorker = new DBWorker();
        resultSet = dbWorker.executeQuery(query);
        try {
            while (resultSet.next()) {
                //trips.add(new Trip(resultSet.getInt("Id")));
                tripViewers.add(new TripViewer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4), resultSet.getDate(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tripViewers;
    }

    public static ArrayList<TripViewer> findTripsViewers(String fromCity, String toCity, String date) {
        ArrayList<TripViewer> tripViewers = new ArrayList<TripViewer>();
        ResultSet resultSet = null;
        String query = "SELECT trips.Id, s1.name, s2.name, trips.departure, trips.arrival FROM trips, routes, stations s1, stations s2 WHERE\n" +
                "       routes.Id = trips.route       \n" +
                "       AND\n" +
                "       routes.from = s1.Id\n" +
                "       AND       \n" +
                "       routes.to = s2.Id       \n" +
                "       AND\n" +
                "       s1.city = (SELECT Id FROM cities WHERE name = '" + fromCity + "')\n" +
                "       AND\n" +
                "       s2.city = (SELECT Id FROM cities WHERE name = '" + toCity + "')" +
                "       AND\n" +
                "       trips.departure >= '"+ date +"' AND trips.departure < '"+ date +" 23:59:59.997'";
        DBWorker dbWorker = new DBWorker();
        resultSet = dbWorker.executeQuery(query);
        try {
            while (resultSet.next()) {
                //trips.add(new Trip(resultSet.getInt("Id")));
                tripViewers.add(new TripViewer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4), resultSet.getTime(4), resultSet.getDate(5), resultSet.getTime(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tripViewers;
    }
}