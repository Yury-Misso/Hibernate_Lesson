package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.controllers.web.servlets.ui;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.Flight;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.FlightFilters;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.PageParam;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.factory.FlightFiltersFactory;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.factory.PageParamFactory;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.api.IFlightsService;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.factory.FlightsServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FlightsListServlet", urlPatterns = "/flightslist")
public class UIFlightsListServlet extends HttpServlet {

    private final IFlightsService service;

    public UIFlightsListServlet() {
        this.service = FlightsServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = 1;
        int sizePage = 50;
        int maxPage = (int) Math.ceil((double) service.getCount() / sizePage);

        PageParam pageParam = new PageParam(pageNo, sizePage, maxPage);
        FlightFilters flightFilters = null;

        List<Flight> flightsList = this.service.getPage(pageParam, flightFilters);

        req.setAttribute("pageParam", pageParam);
        req.setAttribute("flightFilters", flightFilters);
        req.setAttribute("flights", flightsList);
        req.getRequestDispatcher("/view/flightslist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FlightFiltersFactory flightFiltersFactory = new FlightFiltersFactory();
        PageParamFactory pageParamFactory = new PageParamFactory();

        PageParam pageParam = pageParamFactory.getPageParam(req, this.service);
        FlightFilters flightFilters = flightFiltersFactory.getFlightFilters(req);

        req.setAttribute("pageParam", pageParam);
        req.setAttribute("flightFilters", flightFilters);
        List<Flight> flightsList = this.service.getPage(pageParam, flightFilters);
        req.setAttribute("flights", flightsList);
        req.getRequestDispatcher("/view/flightslist.jsp").forward(req, resp);
    }


}
