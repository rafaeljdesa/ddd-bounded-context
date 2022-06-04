package br.com.example.dddboundedcontext.shippingcontext.repository;

import br.com.example.dddboundedcontext.shippingcontext.entity.ShippableOrder;

import java.util.Optional;

public interface ShippingOrderRepository {
    Optional<ShippableOrder> findShippableOrder(int orderId);
}
