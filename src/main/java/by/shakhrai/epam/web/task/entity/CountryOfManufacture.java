package by.shakhrai.epam.web.task.entity;

import java.io.Serializable;
import java.util.Objects;

public class CountryOfManufacture implements Serializable {
    private int id;
    private String coutry;

    public CountryOfManufacture() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoutry() {
        return coutry;
    }

    public void setCoutry(String coutry) {
        this.coutry = coutry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryOfManufacture that = (CountryOfManufacture) o;
        return id == that.id &&
                Objects.equals(coutry, that.coutry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coutry);
    }

    @Override
    public String toString() {
        return "CountryOfManufacture{" +
                "id=" + id +
                ", coutry='" + coutry + '\'' +
                '}';
    }
}
