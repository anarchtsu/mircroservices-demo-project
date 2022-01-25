package ru.gontarenko.fraud.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gontarenko.fraud.domain.FraudCheckHistory;
import ru.gontarenko.fraud.repository.FraudCheckHistoryRepository;

import java.util.Random;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FraudCheckHistoryService {
    Random random = new Random();
    FraudCheckHistoryRepository repository;

    public FraudCheckHistory checkCustomerHistory(Integer customerId) {
        log.info("Check history request for customer {}", customerId);
        return repository.findByCustomerId(customerId).orElseGet(
                () -> repository.save(new FraudCheckHistory(random.nextBoolean(), customerId))
        );
    }
}
