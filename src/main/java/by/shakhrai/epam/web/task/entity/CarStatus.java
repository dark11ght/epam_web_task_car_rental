package by.shakhrai.epam.web.task.entity;

import java.io.Serializable;
import java.util.Objects;

public class CarStatus implements Serializable {
    private int id;
    private String carStatus;

    public CarStatus() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarStatus carStatus1 = (CarStatus) o;
        return id == carStatus1.id &&
                Objects.equals(carStatus, carStatus1.carStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carStatus);
    }

    @Override
    public String toString() {
        return "CarStatus{" +
                "id=" + id +
                ", carStatus='" + carStatus + '\'' +
                '}';
    }
}
