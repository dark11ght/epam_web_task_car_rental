package by.shakhrai.epam.web.task.entity;

import java.io.Serializable;
import java.util.Objects;

public class CarMark implements Serializable {
    private int id;
    private String mark;
    private CountryOfManufacture countryOfManufacture;

    public CarMark() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public CountryOfManufacture getCountryOfManufacture() {
        return countryOfManufacture;
    }

    public void setCountryOfManufacture(CountryOfManufacture countryOfManufacture) {
        this.countryOfManufacture = countryOfManufacture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarMark carMark = (CarMark) o;
        return id == carMark.id &&
                Objects.equals(mark, carMark.mark) &&
                Objects.equals(countryOfManufacture, carMark.countryOfManufacture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, countryOfManufacture);
    }

    @Override
    public String toString() {
        return "CarMark{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", countryOfManufacture=" + countryOfManufacture +
                '}';
    }
}
