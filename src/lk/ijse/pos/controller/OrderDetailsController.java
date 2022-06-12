package lk.ijse.pos.controller;

public class OrderDetailsController {

    public void loadOrderId(String id){
        System.out.println(id);
        // load all order details with id
        // load all Customer details with id associated with order
        // SELECT * FROM Order o JOIN Customer c ON o.customerId=c.id
    }
}
