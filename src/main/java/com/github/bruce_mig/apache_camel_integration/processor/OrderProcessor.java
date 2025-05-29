package com.github.bruce_mig.apache_camel_integration.processor;

import com.github.bruce_mig.apache_camel_integration.dto.Order;
import com.github.bruce_mig.apache_camel_integration.service.OrderService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor implements Processor {

    private final OrderService service;

    public OrderProcessor(OrderService service) {
        this.service = service;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        service.addOrder(exchange.getIn().getBody(Order.class));
    }
}
