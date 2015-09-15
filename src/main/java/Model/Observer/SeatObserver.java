package Model.Observer;

import Model.Entity.Seat;
import Model.Entity.TripViewer;
import database.DBWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Δενθρ on 12.09.2015.
 */
public abstract class SeatObserver {
    public static ArrayList<Seat> selectSeats(int tripId) {
        ArrayList<Seat> seats = new ArrayList<Seat>();
        DBWorker dbWorker = new DBWorker();
        ResultSet resultSet = dbWorker.executeQuery("SELECT * FROM seats WHERE trip = " + tripId);
        try {
            while (resultSet.next()) {
                //trips.add(new Trip(resultSet.getInt("Id")));
                seats.add(new Seat(resultSet.getInt("Id"), tripId, resultSet.getInt("seat_num"), resultSet.getDouble("price"), resultSet.getInt("availability")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seats;
    }
}
