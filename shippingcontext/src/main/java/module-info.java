module br.com.example.dddboundedcontext.shippingcontext {

    requires br.com.example.dddboundedcontext.sharedkernel;
    exports br.com.example.dddboundedcontext.shippingcontext.service;
    exports br.com.example.dddboundedcontext.shippingcontext.repository;
    exports br.com.example.dddboundedcontext.shippingcontext.entity;
    provides br.com.example.dddboundedcontext.shippingcontext.service.ShippingService
            with br.com.example.dddboundedcontext.shippingcontext.service.impl.ParcelShippingService;
}