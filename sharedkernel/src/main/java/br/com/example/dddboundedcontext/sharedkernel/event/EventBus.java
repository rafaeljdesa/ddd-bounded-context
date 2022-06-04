package br.com.example.dddboundedcontext.sharedkernel.event;

public interface EventBus {

    <E extends ApplicationEvent> void publish(E event);

    <E extends ApplicationEvent> void subscribe(String eventType, EventSubscriber subscriber);

    <E extends ApplicationEvent> void unsubscribe(String eventType, EventSubscriber subscriber);
}
