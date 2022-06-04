package br.com.example.dddboundedcontext.sharedkernel.event;

import java.util.Map;

public abstract class ApplicationEvent {

    private final Map<String, String> payload;

    public ApplicationEvent(Map<String, String> payload) {
        this.payload = payload;
    }

    public abstract String getType();

    public String getPayloadValue(String orderId) {
        return payload.get(orderId);
    }
}
