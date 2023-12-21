package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.api;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.Flight;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.FlightFilters;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.PageParam;

import java.util.List;

public interface IFlightsDAO {
    List<Flight> getFlightsList();

    int getCount();

    List<Flight> getFlightsList(PageParam pageParam, FlightFilters flightFilters);
}
