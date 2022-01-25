package ru.gontarenko.customer;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("communication-urls")
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommunicationConfig {
    String fraudService;

    public String getFraudCheckHistoryUrl() {
        return fraudService + "/fraud-check-history/{customerId}";
    }
}
