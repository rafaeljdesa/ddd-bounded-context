package br.com.example.dddboundedcontext.shippingcontext.service;

import br.com.example.dddboundedcontext.sharedkernel.service.ApplicationService;
import br.com.example.dddboundedcontext.shippingcontext.entity.Parcel;
import br.com.example.dddboundedcontext.shippingcontext.repository.ShippingOrderRepository;

import java.util.Optional;

public interface ShippingService extends ApplicationService {

    void shipOrder(int orderId);
    void listenToOrderEvents();
    Optional<Parcel> getParcelByOrderId(int orderId);

    void setOrderRepository(ShippingOrderRepository repository);
}
