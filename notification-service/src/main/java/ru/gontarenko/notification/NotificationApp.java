package ru.gontarenko.notification;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import ru.gontarenko.amqp.RabbitMessageProducer;

@EnableEurekaClient
@SpringBootApplication(
        scanBasePackages = {
                "ru.gontarenko.notification",
                "ru.gontarenko.amqp"
        }
)
public class NotificationApp {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApp.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(
//            RabbitMessageProducer producer,
//            NotificationConfig notificationConfig
//    ) {
//        return args -> producer.publish(
//                new Person("Bob", 21),
//                notificationConfig.getInternalExchange(),
//                notificationConfig.getInternalNotificationRoutingKey()
//        );
//    }
//
//    record Person(String name, int age){}
}
