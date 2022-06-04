package br.com.example.dddboundedcontext.ordercontext.entity;

public class OrderItem {

    public OrderItem(int productId, int quantity, float unitPrice, float unitWeight) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.unitWeight = unitWeight;
    }

    private int productId;
    private int quantity;
    private float unitPrice;
    private float unitWeight;

    public float getTotalPrice() {
        return 0;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public float getUnitWeight() {
        return unitWeight;
    }
}
