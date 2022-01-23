package ru.gontarenko.customer.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gontarenko.customer.domain.Customer;
import ru.gontarenko.customer.repository.CustomerRepository;
import ru.gontarenko.customer.rest.dto.SaveCustomerCommand;
import ru.gontarenko.customer.service.mapper.SaveCustomerMapper;


@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerService {
    SaveCustomerMapper mapper;
    CustomerRepository repository;

    public Customer create(SaveCustomerCommand request) {
        val customer = new Customer();
        mapper.update(customer, request);
        return repository.save(customer);
    }
}
