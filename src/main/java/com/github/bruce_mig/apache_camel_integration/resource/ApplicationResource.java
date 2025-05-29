package com.github.bruce_mig.apache_camel_integration.resource;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ApplicationResource extends RouteBuilder {

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

    }
}
