package ru.gontarenko.customer.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import ru.gontarenko.customer.domain.Customer;
import ru.gontarenko.customer.service.dto.CustomerRegisterRequest;
import ru.gontarenko.customer.service.mapper.CustomerMapper;

@Slf4j
@Service
//@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerService {
    CustomerMapper mapper;

    public Customer register(CustomerRegisterRequest request) {
        val customer = new Customer();
        mapper.update(customer, request);
        // todo repo.save
        return customer;
    }
}
