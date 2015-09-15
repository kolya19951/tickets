package servlets;

import Model.Entity.Seat;
import Model.Entity.Trip;
import Model.Entity.TripViewer;
import Model.Observer.BusConfigObserver;
import Model.Observer.SeatObserver;
import Model.Observer.SeatPlace;
import Model.Observer.TripObserver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ????? on 14.09.2015.
 */
@WebServlet("/step2")
public class Step2 extends HttpServlet {

    private ServletContext context;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = new Integer(request.getParameter("id"));
        ArrayList<Seat> seats = SeatObserver.selectSeats(id);
        ArrayList<SeatPlace> seatPlaces = BusConfigObserver.busConfig(id);

        int maxRow = 0;
        for (SeatPlace item : seatPlaces) {
            if (maxRow < item.getRow())
                maxRow = item.getRow();
        }

        Seat[][] indexableSeats = new Seat[5][maxRow];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < maxRow; j++) {
                indexableSeats[i][j] = null;
            }
        }

        for (Seat item : seats) {
            int i = item.getSeat_num();
            for (SeatPlace place: seatPlaces){
                if (i == place.getSeat_num())
                    indexableSeats[place.getPlace()-1][place.getRow()-1] = item;
            }
        }

        /*request.setAttribute("seats", seats);
        request.setAttribute("seatConfig", seatPlaces);*/
        request.setAttribute("indexableSeats", indexableSeats);
        request.setAttribute("maxRow", maxRow);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/step2.jsp");
        dispatcher.forward(request, response);
    }
}