package ru.gontarenko.customer.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gontarenko.clients.fraud.FraudClient;
import ru.gontarenko.clients.notification.NotificationClient;
import ru.gontarenko.customer.domain.Customer;
import ru.gontarenko.customer.repository.CustomerRepository;
import ru.gontarenko.customer.rest.dto.SaveCustomerCommand;
import ru.gontarenko.customer.rest.mapper.CustomerMapper;

import javax.validation.ConstraintViolationException;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerService {
    private static final String FRAUDULENT_MESSAGE = "Sorry, we cannot register you, your email is fraudulent.";
    private static final String WELCOME_MESSAGE = "Welcome, %s!";
    CustomerMapper mapper;
    CustomerRepository repository;
    FraudClient fraudClient;
    NotificationClient notificationClient;

    public Customer create(SaveCustomerCommand command) {
        log.info("New customer registration request: {}", command);
        val fraudCheckHistoryDto = fraudClient.checkEmailHistory(command.email());
        if (fraudCheckHistoryDto.isFraudster()) {
            notificationClient.send(FRAUDULENT_MESSAGE, command.email());
            throw new ConstraintViolationException("Fraudulent email!", null);
        }
        val customer = new Customer();
        mapper.update(customer, command);
        val saved = repository.save(customer);
        notificationClient.send(String.format(WELCOME_MESSAGE, customer.getFirstName()), customer.getEmail());
        return saved;
    }
}
