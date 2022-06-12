package lk.ijse.pos.entity;

public class Order {
    private String id;
    private String date;
    private double cost;
    private String customer;

    public Order() {
    }

    public Order(String id, String date, double cost, String customer) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", cost=" + cost +
                ", customer='" + customer + '\'' +
                '}';
    }
}
