package br.com.example.dddboundedcontext.shippingcontext.entity;

import java.util.List;

public class ShippableOrder {

    public ShippableOrder(int orderId, List<PackageItem> packageItems) {
        this.orderId = orderId;
        this.packageItems = packageItems;
    }

    public ShippableOrder(int orderId, String address, List<PackageItem> packageItems) {
        this.orderId = orderId;
        this.address = address;
        this.packageItems = packageItems;
    }

    private int orderId;
    private String address;
    private List<PackageItem> packageItems;

    public int getOrderId() {
        return orderId;
    }

    public String getAddress() {
        return address;
    }

    public List<PackageItem> getPackageItems() {
        return packageItems;
    }
}
