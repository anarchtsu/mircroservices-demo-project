package ru.gontarenko.fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gontarenko.fraud.domain.FraudCheckHistory;

import java.util.Optional;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
    Optional<FraudCheckHistory> findByCustomerId(Integer customerId);
}
