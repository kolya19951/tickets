package servlets;

import Model.Entity.Bus;
import Model.Entity.City;
import Model.Entity.TripViewer;
import Model.Manager.BusManager;
import Model.Observer.CitiesObserver;
import Model.Observer.TripObserver;
import database.DBWorker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Δενθρ on 12.09.2015.
 */
@WebServlet("/tickets")
public class Tickets extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ArrayList<String> cities = CitiesObserver.selectCitiesNames();
        request.setAttribute("cities", cities);
        ArrayList<TripViewer> tripViewers = TripObserver.findTripsViewers("Kyiv", "Prague", "2015-09-14");
        request.setAttribute("trips", tripViewers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/tickets.jsp");
        dispatcher.forward(request, response);
    }
}