package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.controllers.web.servlets.api;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.Flight;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.FlightFilters;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.PageParam;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.factory.FlightFiltersFactory;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.factory.PageParamFactory;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.api.IFlightsService;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.factory.FlightsServiceFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "APIFlightsListServlet", urlPatterns = "/api/flightslist")
public class APIFlightsListServlet extends HttpServlet {

    private final IFlightsService service;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public APIFlightsListServlet() {
        this.service = FlightsServiceFactory.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        FlightFiltersFactory flightFiltersFactory = new FlightFiltersFactory();
        PageParamFactory pageParamFactory = new PageParamFactory();

        PageParam pageParam = pageParamFactory.getPageParam(req, this.service);
        FlightFilters flightFilters = flightFiltersFactory.getFlightFilters(req);
        List<Flight> flightsList = this.service.getPage(pageParam, flightFilters);

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        objectMapper.registerModule(javaTimeModule);

        Map<String, List<Flight>> namedListFlights = new HashMap<>();
        namedListFlights.put("Flights", flightsList);

        resp.setContentType("application/json; charset=utf-8");
        Writer writer = resp.getWriter();

        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        writer.write(objectMapper.writeValueAsString(pageParam));
        writer.write(objectMapper.writeValueAsString(flightFilters));


        objectMapper.disable(SerializationFeature.WRAP_ROOT_VALUE);
        resp.getWriter().write(objectMapper.writeValueAsString(namedListFlights));
    }


}
