package br.com.example.dddboundedcontext.infrastructure.database;

import br.com.example.dddboundedcontext.ordercontext.entity.CustomerOrder;
import br.com.example.dddboundedcontext.ordercontext.repository.CustomerOrderRepository;
import br.com.example.dddboundedcontext.shippingcontext.entity.PackageItem;
import br.com.example.dddboundedcontext.shippingcontext.entity.ShippableOrder;
import br.com.example.dddboundedcontext.shippingcontext.repository.ShippingOrderRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryOrderStore implements CustomerOrderRepository, ShippingOrderRepository {

    private Map<Integer, PersistenceOrder> ordersDb = new HashMap<>();

    private volatile static InMemoryOrderStore instance = new InMemoryOrderStore();

    public static InMemoryOrderStore provider() {
        return instance;
    }

    @Override
    public void saveCustomerOrder(CustomerOrder order) {
        this.ordersDb.put(order.getOrderId(), new PersistenceOrder(order.getOrderId(),
                order.getPaymentMethod(),
                order.getAddress(),
                order
                        .getOrderItems()
                        .stream()
                        .map(orderItem ->
                                new PersistenceOrder.OrderItem(orderItem.getProductId(),
                                        orderItem.getQuantity(),
                                        orderItem.getUnitWeight(),
                                        orderItem.getUnitPrice()))
                        .collect(Collectors.toList())
        ));
    }

    @Override
    public Optional<ShippableOrder> findShippableOrder(int orderId) {
        if (!this.ordersDb.containsKey(orderId)) return Optional.empty();
        PersistenceOrder orderRecord = this.ordersDb.get(orderId);
        return Optional.of(
                new ShippableOrder(
                        orderRecord.orderId,
                        orderRecord.orderItems
                            .stream().map(orderItem -> new PackageItem(
                                    orderItem.productId,
                                    orderItem.itemWeight,
                                orderItem.quantity * orderItem.unitPrice
                                )
                            ).collect(Collectors.toList())
                )
            );
    }
}
