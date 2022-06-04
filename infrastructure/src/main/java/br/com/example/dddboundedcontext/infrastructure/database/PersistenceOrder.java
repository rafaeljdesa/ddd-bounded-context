package br.com.example.dddboundedcontext.infrastructure.database;

import java.util.List;

public class PersistenceOrder {

    public PersistenceOrder(int orderId, String paymentMethod, String address, List<OrderItem> orderItems) {
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.address = address;
        this.orderItems = orderItems;
    }

    public int orderId;
    public String paymentMethod;
    public String address;
    public List<OrderItem> orderItems;

    public static class OrderItem {

        public OrderItem(int productId, int quantity, float itemWeight, float unitPrice) {
            this.productId = productId;
            this.unitPrice = unitPrice;
            this.itemWeight = itemWeight;
            this.quantity = quantity;
        }

        public int productId;
        public float unitPrice;
        public float itemWeight;
        public int quantity;
    }
}
