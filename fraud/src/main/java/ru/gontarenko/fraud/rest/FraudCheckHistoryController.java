package ru.gontarenko.fraud.rest;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gontarenko.fraud.rest.dto.FraudCheckHistoryDto;
import ru.gontarenko.fraud.rest.mapper.FraudCheckHistoryWebMapper;
import ru.gontarenko.fraud.service.FraudCheckHistoryService;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check-history")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FraudCheckHistoryController {
    FraudCheckHistoryService service;
    FraudCheckHistoryWebMapper mapper;

    @GetMapping("{customerId}")
    public FraudCheckHistoryDto checkCustomerHistory(@PathVariable Integer customerId) {
        return mapper.dto(service.checkCustomerHistory(customerId));
    }
}
