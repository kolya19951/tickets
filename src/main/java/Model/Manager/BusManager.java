package Model.Manager;

import Model.Entity.Bus;
import database.DBWorker;

/**
 * Created by Δενθρ on 12.09.2015.
 */
public abstract class BusManager {
    static public void add(Bus bus) {
        //String query = "INSERT INTO buses (name, seats) VALUES ('" + bus.getName() + "', " + bus.getSeats() + ")";
        String query = "INSERT INTO buses (name, seats) VALUES ('newcode7', 1236)";
        //String query = "SELECT name FROM buses WHERE id = 1";
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }
    static public void edit() {}
    static public void delete() {}
}
