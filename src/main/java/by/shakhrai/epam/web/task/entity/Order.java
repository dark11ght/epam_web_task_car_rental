package by.shakhrai.epam.web.task.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Order implements Serializable {
    private long id;
    private User user;
    private Car car;
    private int rentHours;
    private double totalPrice;
    private boolean paymentStatus;
    private boolean confirmStatus;
    private Timestamp dateOfRegOrder;
    private boolean orderStatus;
    private String notes;

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getRentHours() {
        return rentHours;
    }

    public void setRentHours(int rentHours) {
        this.rentHours = rentHours;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public boolean isConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(boolean confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Timestamp getDateOfRegOrder() {
        return dateOfRegOrder;
    }

    public void setDateOfRegOrder(Timestamp dateOfRegOrder) {
        this.dateOfRegOrder = dateOfRegOrder;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                rentHours == order.rentHours &&
                Double.compare(order.totalPrice, totalPrice) == 0 &&
                paymentStatus == order.paymentStatus &&
                confirmStatus == order.confirmStatus &&
                orderStatus == order.orderStatus &&
                Objects.equals(user, order.user) &&
                Objects.equals(car, order.car) &&
                Objects.equals(dateOfRegOrder, order.dateOfRegOrder) &&
                Objects.equals(notes, order.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, car, rentHours, totalPrice, paymentStatus, confirmStatus, dateOfRegOrder, orderStatus, notes);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", car=" + car +
                ", rentHours=" + rentHours +
                ", totalPrice=" + totalPrice +
                ", paymentStatus=" + paymentStatus +
                ", confirmStatus=" + confirmStatus +
                ", dateOfRegOrder=" + dateOfRegOrder +
                ", orderStatus=" + orderStatus +
                ", notes='" + notes + '\'' +
                '}';
    }
}
