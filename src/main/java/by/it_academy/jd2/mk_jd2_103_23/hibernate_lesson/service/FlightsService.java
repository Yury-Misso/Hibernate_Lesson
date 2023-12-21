package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.Flight;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.FlightFilters;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.PageParam;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.api.IFlightsDAO;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.api.IFlightsService;

import java.util.List;

public class FlightsService implements IFlightsService {
    private final IFlightsDAO dao;

    public FlightsService(IFlightsDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Flight> getAll() {
        return dao.getFlightsList();
    }

    @Override
    public int getCount() {
        return dao.getCount();
    }

    @Override
    public List<Flight> getPage(PageParam pageParam, FlightFilters flightFilters) {
        return dao.getFlightsList(pageParam, flightFilters);
    }
}
