package ru.gontarenko.customer.rest;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gontarenko.customer.rest.dto.CustomerDto;
import ru.gontarenko.customer.rest.dto.SaveCustomerCommand;
import ru.gontarenko.customer.rest.mapper.CustomerMapper;
import ru.gontarenko.customer.service.CustomerService;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {
    CustomerService service;
    CustomerMapper mapper;

    @PostMapping
    public CustomerDto create(@RequestBody SaveCustomerCommand command) {
        return mapper.dto(service.create(command));
    }
}
