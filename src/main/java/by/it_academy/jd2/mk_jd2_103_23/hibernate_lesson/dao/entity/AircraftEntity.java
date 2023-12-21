package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.dao.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(schema = "bookings", name = "aircrafts_data")
public class AircraftEntity {

    @Id
    @Column(name = "aircraft_code", columnDefinition = "bpchar")
    private String airCraftCode;
    @Column(name = "model", columnDefinition = "jsonb")
    private String model;
    @Column(name = "range")
    private int range;

    public AircraftEntity() {
    }

    public AircraftEntity(String airCraftCode, String model, int range) {
        this.airCraftCode = airCraftCode;
        this.model = model;
        this.range = range;
    }

    public String getAirCraftCode() {
        return airCraftCode;
    }

    public void setAirCraftCode(String airCraftCode) {
        this.airCraftCode = airCraftCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AircraftEntity that = (AircraftEntity) o;

        if (range != that.range) return false;
        if (!Objects.equals(airCraftCode, that.airCraftCode)) return false;
        return Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        int result = airCraftCode != null ? airCraftCode.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + range;
        return result;
    }

    @Override
    public String toString() {
        return "AircraftEntity{" +
                "airCraftCode='" + airCraftCode + '\'' +
                ", model='" + model + '\'' +
                ", range=" + range +
                '}';
    }
}
