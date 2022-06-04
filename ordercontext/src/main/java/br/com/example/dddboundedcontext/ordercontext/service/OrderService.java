package br.com.example.dddboundedcontext.ordercontext.service;

import br.com.example.dddboundedcontext.ordercontext.repository.CustomerOrderRepository;
import br.com.example.dddboundedcontext.sharedkernel.service.ApplicationService;
import br.com.example.dddboundedcontext.ordercontext.entity.CustomerOrder;

public interface OrderService extends ApplicationService {

    void placeOrder(CustomerOrder order);
    void setOrderRepository(CustomerOrderRepository orderRepository);
}
