package lk.ijse.pos.view.tm;

public class OrderTM {
    private String id;
    private String date;
    private double cost;

    public OrderTM() {
    }

    public OrderTM(String id, String date, double cost) {
        this.id = id;
        this.date = date;
        this.cost = cost;
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
}
