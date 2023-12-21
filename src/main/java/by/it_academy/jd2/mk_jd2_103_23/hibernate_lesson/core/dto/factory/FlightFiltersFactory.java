package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.factory;

import by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto.FlightFilters;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FlightFiltersFactory {

    public FlightFilters getFlightFilters(HttpServletRequest req) {
        FlightFilters flightFilters = new FlightFilters();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            String flightId = req.getParameter("flightId");
            if (flightId != null && !flightId.isBlank()) {
                flightFilters.setFlightId(Integer.parseInt(flightId));
            } else {
                flightFilters.setFlightId(null);
            }

            String flightNo = req.getParameter("flightNo");
            if (flightNo != null && !flightNo.isBlank()) {
                flightFilters.setFlightNo(flightNo);
            } else {
                flightFilters.setFlightNo(null);
            }

            String scheduledDeparture = req.getParameter("scheduledDeparture");
            if (scheduledDeparture != null && !scheduledDeparture.isBlank()) {
                flightFilters.setScheduledDeparture(LocalDate.parse(
                        scheduledDeparture, dateFormatter));
            } else {
                flightFilters.setScheduledDeparture(null);
            }

            String scheduledArrival = req.getParameter("scheduledArrival");
            if (scheduledArrival != null && !scheduledArrival.isBlank()) {
                flightFilters.setScheduledArrival(LocalDate.parse(
                        scheduledArrival, dateFormatter));
            } else {
                flightFilters.setScheduledArrival(null);
            }

            String departureAirport = req.getParameter("departureAirport");
            if (departureAirport != null && !departureAirport.isBlank()) {
                flightFilters.setDepartureAirport(departureAirport);
            } else {
                flightFilters.setDepartureAirport(null);
            }

            String arrivalAirport = req.getParameter("arrivalAirport");
            if (arrivalAirport != null && !arrivalAirport.isBlank()) {
                flightFilters.setArrivalAirport(arrivalAirport);
            } else {
                flightFilters.setArrivalAirport(null);
            }

            String status = req.getParameter("status");
            if (status != null && !status.isBlank()) {
                flightFilters.setStatus(status);
            } else {
                flightFilters.setStatus(null);
            }

            String aircraftCode = req.getParameter("aircraftCode");
            if (aircraftCode != null && !aircraftCode.isBlank()) {
                flightFilters.setAircraftCode(aircraftCode);
            } else {
                flightFilters.setAircraftCode(null);
            }

            String actualDeparture = req.getParameter("actualDeparture");
            if (actualDeparture != null && !actualDeparture.isBlank()) {
                flightFilters.setActualDeparture(
                        LocalDate.parse(actualDeparture, dateFormatter));
            } else {
                flightFilters.setActualDeparture(null);
            }

            String actualArrival = req.getParameter("actualArrival");
            if (actualArrival != null && !actualArrival.isBlank()) {
                flightFilters.setActualArrival(
                        LocalDate.parse(actualArrival, dateFormatter));
            } else {
                flightFilters.setActualArrival(null);
            }

            return flightFilters;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error creating flight_filter", e);
        }
    }
}
