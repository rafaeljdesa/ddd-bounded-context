package br.com.example.dddboundedcontext.shippingcontext.entity;

public class PackageItem {

    public PackageItem(int productId, float weight, float quantity) {
        this.productId = productId;
        this.weight = weight;
        this.quantity = quantity;
    }

    private int productId;
    private float weight;
    private float quantity;

    public float getWeight() {
        return weight;
    }
}
