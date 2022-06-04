module br.com.example.dddboundedcontext.mainapp {

    uses br.com.example.dddboundedcontext.sharedkernel.event.EventBus;
    uses br.com.example.dddboundedcontext.ordercontext.service.OrderService;
    uses br.com.example.dddboundedcontext.ordercontext.repository.CustomerOrderRepository;
    uses br.com.example.dddboundedcontext.shippingcontext.service.ShippingService;
    uses br.com.example.dddboundedcontext.shippingcontext.repository.ShippingOrderRepository;
    requires br.com.example.dddboundedcontext.infrastructure;
}