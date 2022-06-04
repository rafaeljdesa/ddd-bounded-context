package br.com.example.dddboundedcontext.shippingcontext.entity;

import java.util.List;

public class Parcel {

    public Parcel(int orderId, String address, List<PackageItem> packageItems) {
        this.orderId = orderId;
        this.address = address;
        this.packageItems = packageItems;
    }

    private int orderId;
    private String address;
    private String trackingId;
    private List<PackageItem> packageItems;

    public float calculateTotalWeight() {
        return packageItems.stream().map(PackageItem::getWeight)
                .reduce(0F, Float::sum);
    }

    public boolean isTaxable() {
        return calculateEstimatedValue() > 100;
    }

    public float calculateEstimatedValue() {
        return packageItems.stream().map(PackageItem::getWeight)
                .reduce(0F, Float::sum);
    }

    public int getOrderId() {
        return orderId;
    }
}
