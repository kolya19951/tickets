package servlets;

import Model.Entity.Trip;
import Model.Entity.TripViewer;
import Model.Observer.TripObserver;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Δενθρ on 14.09.2015.
 */
@WebServlet("/SearchTrips")
public class SearchTrips extends HttpServlet {

    private ServletContext context;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String date = request.getParameter("date");
        StringBuffer sb = new StringBuffer();

        ArrayList<TripViewer> tripViewers = TripObserver.findTripsViewers(from, to, date);
        for (TripViewer item : tripViewers) {
            sb.append("<trip>");
            sb.append("<datefromtime>" + String.format("%tR", item.getDepartureTime()) + "</datefromtime>");
            sb.append("<datefrom>" + item.getDeparture().toString() + "</datefrom>");
            sb.append("<from>" + item.getFrom() + "</from>");
            sb.append("<datetotime>" + String.format("%tR", item.getArrivalTime()) + "</datetotime>");
            sb.append("<dateto>" + item.getArrival() + "</dateto>");
            sb.append("<triptime>" + (item.getArrival().getTime() - item.getDeparture().getTime())/(60*1000*60) + "</triptime>");
            sb.append("<to>" + item.getTo() + "</to>");
            sb.append("<id>" + item.getId() + "</id>");
            sb.append("</trip>");
        }
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write("<trips>" + sb.toString() + "</trips>");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }
}


