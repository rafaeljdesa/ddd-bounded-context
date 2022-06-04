package br.com.example.dddboundedcontext.ordercontext.service.impl;

import br.com.example.dddboundedcontext.sharedkernel.event.ApplicationEvent;
import br.com.example.dddboundedcontext.sharedkernel.event.EventBus;
import br.com.example.dddboundedcontext.ordercontext.entity.CustomerOrder;
import br.com.example.dddboundedcontext.ordercontext.repository.CustomerOrderRepository;
import br.com.example.dddboundedcontext.ordercontext.service.OrderService;

import java.util.HashMap;
import java.util.Map;

public class CustomerOrderService implements OrderService {

    public static final String EVENT_ORDER_READY_FOR_SHIPMENT = "OrderReadyForShipmentEvent";

    private CustomerOrderRepository orderRepository;
    private EventBus eventBus;

    @Override
    public void placeOrder(CustomerOrder order) {
        orderRepository.saveCustomerOrder(order);
        Map<String, String> payload = new HashMap<>();
        payload.put("order_id", String.valueOf(order.getOrderId()));
        ApplicationEvent event = new ApplicationEvent(payload) {
            @Override
            public String getType() {
                return EVENT_ORDER_READY_FOR_SHIPMENT;
            }
        };
        this.eventBus.publish(event);
    }

    @Override
    public void setOrderRepository(CustomerOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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
