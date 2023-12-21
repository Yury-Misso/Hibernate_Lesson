package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.time.LocalDate;
import java.util.Objects;
@JsonRootName("FlightFilters")
public class FlightFilters {
    private Integer flightId;
    private String flightNo;
    private LocalDate scheduledDeparture;
    private LocalDate scheduledArrival;
    private String departureAirport;
    private String arrivalAirport;
    private String status;
    private String aircraftCode;
    private LocalDate actualDeparture;
    private LocalDate actualArrival;

    public FlightFilters() {
    }

    public FlightFilters(Integer flightId, String flightNo, LocalDate scheduledDeparture, LocalDate scheduledArrival,
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

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
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

        FlightFilters that = (FlightFilters) o;

        if (!Objects.equals(flightId, that.flightId)) return false;
        if (!Objects.equals(flightNo, that.flightNo)) return false;
        if (!Objects.equals(scheduledDeparture, that.scheduledDeparture))
            return false;
        if (!Objects.equals(scheduledArrival, that.scheduledArrival))
            return false;
        if (!Objects.equals(departureAirport, that.departureAirport))
            return false;
        if (!Objects.equals(arrivalAirport, that.arrivalAirport))
            return false;
        if (!Objects.equals(status, that.status)) return false;
        if (!Objects.equals(aircraftCode, that.aircraftCode)) return false;
        if (!Objects.equals(actualDeparture, that.actualDeparture))
            return false;
        return Objects.equals(actualArrival, that.actualArrival);
    }

    @Override
    public int hashCode() {
        int result = flightId != null ? flightId.hashCode() : 0;
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
        return "FlightFilters{" +
                "flightId=" + flightId +
                ", flightNo='" + flightNo + '\'' +
                ", scheduledDeparture=" + scheduledDeparture +
                ", scheduledArrival=" + scheduledArrival +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", status='" + status + '\'' +
                ", aircraftCode='" + aircraftCode + '\'' +
                ", actualDeparture=" + actualDeparture +
                ", actualArrival=" + actualArrival +
                '}';
    }
}
