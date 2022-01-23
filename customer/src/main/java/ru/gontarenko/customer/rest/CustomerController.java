package ru.gontarenko.customer.rest;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gontarenko.customer.rest.dto.CustomerDto;
import ru.gontarenko.customer.rest.mapper.CustomerWebMapper;
import ru.gontarenko.customer.service.CustomerService;
import ru.gontarenko.customer.rest.dto.SaveCustomerCommand;

/**
 * http://localhost:8081/swagger-ui.html
 */

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {
    CustomerService service;
    CustomerWebMapper customerWebMapper;

    @PostMapping
    public CustomerDto create(@RequestBody SaveCustomerCommand command) {
        log.info("New customer registration request {}", command);
        val customer = service.create(command);
        return customerWebMapper.dto(customer);
    }
}
