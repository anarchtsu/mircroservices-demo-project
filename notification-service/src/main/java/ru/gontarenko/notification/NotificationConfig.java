package ru.gontarenko.notification;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotificationConfig {
    @Value("${rabbit.exchanges.internal}")
    String internalExchange;

    @Value("${rabbit.queues.notification}")
    String notificationQueue;

    @Value("${rabbit.routing-keys.internal-notification}")
    String internalNotificationRoutingKey;

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(internalExchange);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(notificationQueue);
    }

    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder.bind(notificationQueue())
                .to(internalTopicExchange())
                .with(internalNotificationRoutingKey);
    }
}
