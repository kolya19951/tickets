package servlets;

import Model.Entity.Seat;
import Model.Entity.Trip;
import Model.Entity.TripViewer;
import Model.Observer.BusConfigObserver;
import Model.Observer.SeatObserver;
import Model.Observer.SeatPlace;
import Model.Observer.TripObserver;
import database.DBWorker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by ????? on 14.09.2015.
 */
@WebServlet("/step3")
public class Step3 extends HttpServlet {

    private ServletContext context;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = new Integer(request.getParameter("id"));
        String query = "SELECT cities1.name, cities2.name, stations1.name, stations2.name, trips.departure, trips.arrival, seats.price FROM\n" +
                "                cities cities1, cities cities2, stations stations1, stations stations2, trips, seats, routes WHERE                \n" +
                "                       seats.Id = " + id + "\n" +
                "                       AND\n" +
                "                       seats.trip = trips.Id                       \n" +
                "                       AND                       \n" +
                "                       trips.route = routes.Id                       \n" +
                "                       AND                       \n" +
                "                       routes.from = stations1.Id                       \n" +
                "                       AND                       \n" +
                "                       routes.to = stations2.Id                       \n" +
                "                       AND                       \n" +
                "                       stations1.city = cities1.Id                       \n" +
                "                       AND                       \n" +
                "                       stations2.city = cities2.Id";

        DBWorker dbWorker = new DBWorker();

        ResultSet resultSet = dbWorker.executeQuery(query);
        System.out.println();
        try {
            if (resultSet.next()) {
                try {

                    String departureCity = resultSet.getString(1);
                    request.setAttribute("departureCity", departureCity);
                    String arrivalCity = resultSet.getString(2);
                    request.setAttribute("arrivalCity", arrivalCity);
                    String departureStation = resultSet.getString(3);
                    request.setAttribute("departureStation", departureStation);
                    String arrivalStation = resultSet.getString(4);
                    request.setAttribute("arrivalStation", arrivalStation);
                    String departureDate = resultSet.getDate(5).toString();
                    request.setAttribute("departureDate", departureDate);
                    String arrivalDate = resultSet.getDate(6).toString();
                    request.setAttribute("arrivalDate", arrivalDate);
                    String departureTime = resultSet.getTime(5).toString();
                    request.setAttribute("departureTime", departureTime);
                    String arrivalTime = resultSet.getTime(6).toString();
                    request.setAttribute("arrivalTime", arrivalTime);
                    double price = resultSet.getDouble(7);
                    request.setAttribute("price", price);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/step3.jsp");
        dispatcher.forward(request, response);
    }
}