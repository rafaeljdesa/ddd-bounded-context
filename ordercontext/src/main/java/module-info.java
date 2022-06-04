module br.com.example.dddboundedcontext.ordercontext {

    requires br.com.example.dddboundedcontext.sharedkernel;
    exports br.com.example.dddboundedcontext.ordercontext.entity;
    exports br.com.example.dddboundedcontext.ordercontext.service;
    exports br.com.example.dddboundedcontext.ordercontext.repository;
    provides br.com.example.dddboundedcontext.ordercontext.service.OrderService
            with br.com.example.dddboundedcontext.ordercontext.service.impl.CustomerOrderService;
}