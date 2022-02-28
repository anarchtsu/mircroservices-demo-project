package ru.gontarenko.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(
        basePackages = "ru.gontarenko.clients"
)
@EnableEurekaClient
@SpringBootApplication(
        scanBasePackages = {
                "ru.gontarenko.customer",
                "ru.gontarenko.amqp"
        }
)
public class CustomerApp {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApp.class, args);
    }
}
