package br.com.example.dddboundedcontext.shippingcontext.service.impl;

import br.com.example.dddboundedcontext.sharedkernel.event.ApplicationEvent;
import br.com.example.dddboundedcontext.sharedkernel.event.EventBus;
import br.com.example.dddboundedcontext.sharedkernel.event.EventSubscriber;
import br.com.example.dddboundedcontext.shippingcontext.entity.Parcel;
import br.com.example.dddboundedcontext.shippingcontext.entity.ShippableOrder;
import br.com.example.dddboundedcontext.shippingcontext.repository.ShippingOrderRepository;
import br.com.example.dddboundedcontext.shippingcontext.service.ShippingService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParcelShippingService implements ShippingService {

    public static final String EVENT_ORDER_READY_FOR_SHIPMENT = "OrderReadyForShipmentEvent";
    private ShippingOrderRepository orderRepository;
    private EventBus eventBus;
    private Map<Integer, Parcel> shippedParcels = new HashMap<>();

    @Override
    public void shipOrder(int orderId) {
        Optional<ShippableOrder> order = this.orderRepository.findShippableOrder(orderId);
        order.ifPresent(completedOrder -> {
            Parcel parcel = new Parcel(completedOrder.getOrderId(), completedOrder.getAddress(),
                    completedOrder.getPackageItems());
            if (parcel.isTaxable()) {
                // Calculate additional taxes
            }
            // Ship parcel
            this.shippedParcels.put(completedOrder.getOrderId(), parcel);
        });
    }

    @Override
    public void listenToOrderEvents() {
        this.eventBus.subscribe(EVENT_ORDER_READY_FOR_SHIPMENT, new EventSubscriber() {
            @Override
            public <E extends ApplicationEvent> void onEvent(E event) {
                shipOrder(Integer.parseInt(event.getPayloadValue("order_id")));
            }
        });
    }

    @Override
    public Optional<Parcel> getParcelByOrderId(int orderId) {
        return Optional.ofNullable(this.shippedParcels.get(orderId));
    }

    @Override
    public void setOrderRepository(ShippingOrderRepository repository) {
        this.orderRepository = repository;
    }

    @Override
    public EventBus getEventBus() {
        return this.eventBus;
    }

    @Override
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }
}
