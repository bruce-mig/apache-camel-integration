package com.github.bruce_mig.apache_camel_integration.resource;

import com.github.bruce_mig.apache_camel_integration.dto.Order;
import com.github.bruce_mig.apache_camel_integration.processor.OrderProcessor;
import com.github.bruce_mig.apache_camel_integration.service.OrderService;
import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ApplicationResource extends RouteBuilder {

    private final OrderService service;

    @BeanInject
    private OrderProcessor processor;

    public ApplicationResource(OrderService service) {
        this.service = service;
    }

    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet")
                .port(9090)
                .host("localhost")
                .bindingMode(RestBindingMode.json);

        rest().get("/hello-world")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .to("direct:camelHello");

        from("direct:camelHello")
                .setBody(constant("Bonjour tous le monde!"));

        rest().get("/get-orders")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .to("direct:getOrders");

        from("direct:getOrders")
                .setBody(exchange -> service.getOrders());

        rest().post("/add-order")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .type(Order.class)
                .outType(Order.class)
                .to("direct:addOrder");

        from("direct:addOrder")
                .process(processor);


    }
}
