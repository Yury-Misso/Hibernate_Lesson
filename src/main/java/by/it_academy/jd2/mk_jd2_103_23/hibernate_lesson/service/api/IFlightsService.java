package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.service.api;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.Flight;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.FlightFilters;
import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.PageParam;

import java.util.List;

public interface IFlightsService {
    List<Flight> getAll();

    int getCount();

    List<Flight> getPage(PageParam pageParam, FlightFilters flightFilters);
}
