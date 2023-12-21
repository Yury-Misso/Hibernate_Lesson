package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.time.LocalDate;
import java.util.Objects;

@JsonRootName("Flight")
public class Flight {
    private int flightId;
    private String flightNo;
    private LocalDate scheduledDeparture;
    private LocalDate scheduledArrival;
    private String departureAirport;
    private String arrivalAirport;
    private String status;
    private String aircraftCode;
    private LocalDate actualDeparture;
    private LocalDate actualArrival;

    public Flight() {
    }

    public Flight(int flightId, String flightNo, LocalDate scheduledDeparture, LocalDate scheduledArrival,
                  String departureAirport, String arrivalAirport, String status, String aircraftCode,
                  LocalDate actualDeparture, LocalDate actualArrival) {
        this.flightId = flightId;
        this.flightNo = flightNo;
        this.scheduledDeparture = scheduledDeparture;
        this.scheduledArrival = scheduledArrival;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.status = status;
        this.aircraftCode = aircraftCode;
        this.actualDeparture = actualDeparture;
        this.actualArrival = actualArrival;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public LocalDate getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(LocalDate scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public LocalDate getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(LocalDate scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public LocalDate getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(LocalDate actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public LocalDate getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(LocalDate actualArrival) {
        this.actualArrival = actualArrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (flightId != flight.flightId) return false;
        if (!Objects.equals(flightNo, flight.flightNo)) return false;
        if (!Objects.equals(scheduledDeparture, flight.scheduledDeparture))
            return false;
        if (!Objects.equals(scheduledArrival, flight.scheduledArrival))
            return false;
        if (!Objects.equals(departureAirport, flight.departureAirport))
            return false;
        if (!Objects.equals(arrivalAirport, flight.arrivalAirport))
            return false;
        if (!Objects.equals(status, flight.status)) return false;
        if (!Objects.equals(aircraftCode, flight.aircraftCode))
            return false;
        if (!Objects.equals(actualDeparture, flight.actualDeparture))
            return false;
        return Objects.equals(actualArrival, flight.actualArrival);
    }

    @Override
    public int hashCode() {
        int result = flightId;
        result = 31 * result + (flightNo != null ? flightNo.hashCode() : 0);
        result = 31 * result + (scheduledDeparture != null ? scheduledDeparture.hashCode() : 0);
        result = 31 * result + (scheduledArrival != null ? scheduledArrival.hashCode() : 0);
        result = 31 * result + (departureAirport != null ? departureAirport.hashCode() : 0);
        result = 31 * result + (arrivalAirport != null ? arrivalAirport.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (aircraftCode != null ? aircraftCode.hashCode() : 0);
        result = 31 * result + (actualDeparture != null ? actualDeparture.hashCode() : 0);
        result = 31 * result + (actualArrival != null ? actualArrival.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flight_id=" + flightId +
                ", flight_no='" + flightNo + '\'' +
                ", scheduled_departure=" + scheduledDeparture +
                ", scheduled_arrival=" + scheduledArrival +
                ", departure_airport='" + departureAirport + '\'' +
                ", arrival_airport='" + arrivalAirport + '\'' +
                ", status='" + status + '\'' +
                ", aircraft_code='" + aircraftCode + '\'' +
                ", actual_departure=" + actualDeparture +
                ", actual_arrival=" + actualArrival +
                '}';
    }
}
