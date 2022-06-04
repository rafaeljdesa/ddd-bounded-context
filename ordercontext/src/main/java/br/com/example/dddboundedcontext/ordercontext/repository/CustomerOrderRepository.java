package br.com.example.dddboundedcontext.ordercontext.repository;

import br.com.example.dddboundedcontext.ordercontext.entity.CustomerOrder;

public interface CustomerOrderRepository {

    void saveCustomerOrder(CustomerOrder order);
}
