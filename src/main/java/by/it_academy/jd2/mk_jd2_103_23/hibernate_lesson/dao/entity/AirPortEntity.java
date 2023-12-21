package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "bookings", name = "airports_data")
public class AirPortEntity {
    @Id
    @Column(name = "airport_code", columnDefinition = "bpchar")
    private String airportCode;
    @Column(name = "airport_name", columnDefinition = "jsonb")
    private String airportName;
    @Column(name = "city", columnDefinition = "jsonb")
    private String city;
    @Column(name = "coordinates", columnDefinition = "point")
    private String coordinates;
    @Column(name = "timezone")
    private String timeZone;

    public AirPortEntity() {
    }

    public AirPortEntity(String airportCode, String airportName, String city, String coordinates, String timeZone) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.coordinates = coordinates;
        this.timeZone = timeZone;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirPortEntity airPort = (AirPortEntity) o;

        if (!airportCode.equals(airPort.airportCode)) return false;
        if (!airportName.equals(airPort.airportName)) return false;
        if (!city.equals(airPort.city)) return false;
        if (!coordinates.equals(airPort.coordinates)) return false;
        return timeZone.equals(airPort.timeZone);
    }

    @Override
    public int hashCode() {
        int result = airportCode.hashCode();
        result = 31 * result + airportName.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + coordinates.hashCode();
        result = 31 * result + timeZone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AirPort{" +
                "airportCode='" + airportCode + '\'' +
                ", airportName='" + airportName + '\'' +
                ", city='" + city + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }
}
