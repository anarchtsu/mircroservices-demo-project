package ru.gontarenko.fraud.rest;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gontarenko.clients.fraud.FraudClient;
import ru.gontarenko.clients.fraud.dto.FraudCheckHistoryDto;
import ru.gontarenko.fraud.rest.mapper.FraudCheckHistoryWebMapper;
import ru.gontarenko.fraud.service.FraudCheckHistoryService;

@RestController
@RequestMapping(FraudClient.PATH)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FraudCheckHistoryController implements FraudClient {
    FraudCheckHistoryService service;
    FraudCheckHistoryWebMapper mapper;

    public FraudCheckHistoryDto checkEmailHistory(String email) {
        return mapper.dto(service.checkEmailHistory(email));
    }
}
