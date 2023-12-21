package by.it_academy.jd2.mk_jd2_103_23.hibernate_lesson.core.dto;

public class Aircraft {
    private String airCraftCode;
    private String model;
    private int range;

    public Aircraft() {
    }

    public Aircraft(String airCraftCode, String model, int range) {
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

        Aircraft that = (Aircraft) o;

        if (range != that.range) return false;
        if (!airCraftCode.equals(that.airCraftCode)) return false;
        return model.equals(that.model);
    }

    @Override
    public int hashCode() {
        int result = airCraftCode.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + range;
        return result;
    }

    @Override
    public String toString() {
        return "AircraftDTO{" +
                "airCraftCode='" + airCraftCode + '\'' +
                ", model='" + model + '\'' +
                ", range=" + range +
                '}';
    }
}
