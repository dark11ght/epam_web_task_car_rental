package by.shakhrai.epam.web.task.entity;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
    private int id;
    private CarMark mark;
    private CarModel model;
    private int millage;
    private float price;
    private CarStatus carStatus;

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarMark getMark() {
        return mark;
    }

    public void setMark(CarMark mark) {
        this.mark = mark;
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public int getMillage() {
        return millage;
    }

    public void setMillage(int millage) {
        this.millage = millage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                millage == car.millage &&
                Float.compare(car.price, price) == 0 &&
                Objects.equals(mark, car.mark) &&
                Objects.equals(model, car.model) &&
                Objects.equals(carStatus, car.carStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, model, millage, price, carStatus);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark=" + mark +
                ", model=" + model +
                ", millage=" + millage +
                ", price=" + price +
                ", carStatus=" + carStatus +
                '}';
    }
}
