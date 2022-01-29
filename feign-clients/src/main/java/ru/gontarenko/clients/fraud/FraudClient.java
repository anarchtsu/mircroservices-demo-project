package ru.gontarenko.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.gontarenko.clients.fraud.dto.FraudCheckHistoryDto;

@FeignClient(
        value = "fraud",
        path = FraudClient.FRAUD_PATH
)
public interface FraudClient {
    String FRAUD_PATH = "api/v1/fraud-check-history";

    @GetMapping("{customerId}")
    FraudCheckHistoryDto checkCustomerHistory(@PathVariable Integer customerId);

}
