module br.com.example.dddboundedcontext.infrastructure {

    requires transitive br.com.example.dddboundedcontext.sharedkernel;
    requires transitive br.com.example.dddboundedcontext.ordercontext;
    requires transitive br.com.example.dddboundedcontext.shippingcontext;
    provides br.com.example.dddboundedcontext.sharedkernel.event.EventBus
            with br.com.example.dddboundedcontext.infrastructure.event.SimpleEventBus;
    provides br.com.example.dddboundedcontext.ordercontext.repository.CustomerOrderRepository
            with br.com.example.dddboundedcontext.infrastructure.database.InMemoryOrderStore;
    provides br.com.example.dddboundedcontext.shippingcontext.repository.ShippingOrderRepository
            with br.com.example.dddboundedcontext.infrastructure.database.InMemoryOrderStore;
}