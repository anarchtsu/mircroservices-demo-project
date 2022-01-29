package ru.gontarenko.customer.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gontarenko.clients.fraud.FraudClient;
import ru.gontarenko.clients.notification.NotificationClient;
import ru.gontarenko.customer.domain.Customer;
import ru.gontarenko.customer.repository.CustomerRepository;
import ru.gontarenko.customer.rest.dto.SaveCustomerCommand;
import ru.gontarenko.customer.service.mapper.SaveCustomerMapper;

import javax.validation.ConstraintViolationException;


@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerService {
    SaveCustomerMapper mapper;
    CustomerRepository repository;
    FraudClient fraudClient;
    NotificationClient notificationClient;


    public Customer create(SaveCustomerCommand command) {
        val fraudCheckHistoryDto = fraudClient.checkEmailHistory(command.email());
        if (fraudCheckHistoryDto.isFraudster()) {
            throw new ConstraintViolationException("Fraudulent email!", null);
        }
        val customer = new Customer();
        mapper.update(customer, command);
        val saved = repository.save(customer);
        notificationClient.send(saved.toString(), "test");
        return saved;
    }
}
