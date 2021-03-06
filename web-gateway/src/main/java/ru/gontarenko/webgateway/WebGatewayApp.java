package ru.gontarenko.webgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * http://localhost:5050/browser/ - pgAdmin
 *
 * docker ps --format "table {{.ID}}\t{{.Image}}\t{{.Names}}"
 *
 * http://localhost:8761 - eureka dashboard
 *
 * http://localhost:9411/zipkin/
 *
 * http://localhost:8081/swagger-ui.html
 *
 * curl -X POST http://localhost:8080/api/v1/customers -H 'Content-Type: application/json' -d '{"firstName":"test","lastName":"test","email":"test"}'
 *
 * http://localhost:15672 - rabbitmq (guest/guest)
 *
 */

@EnableEurekaClient
@SpringBootApplication
public class WebGatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(WebGatewayApp.class, args);
    }
}
