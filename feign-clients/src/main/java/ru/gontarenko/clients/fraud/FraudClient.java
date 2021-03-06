package ru.gontarenko.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gontarenko.clients.fraud.dto.FraudCheckHistoryDto;

@FeignClient(
        value = "fraud",
        path = FraudClient.PATH
)
public interface FraudClient {
    String PATH = "api/v1/fraud-check-history";

    @GetMapping(params = "email")
    FraudCheckHistoryDto checkEmailHistory(@RequestParam("email") String email);

}
