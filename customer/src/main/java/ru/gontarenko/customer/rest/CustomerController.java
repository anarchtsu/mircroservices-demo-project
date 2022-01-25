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
import org.springframework.web.client.RestTemplate;
import ru.gontarenko.customer.CommunicationConfig;
import ru.gontarenko.customer.rest.dto.CustomerDto;
import ru.gontarenko.customer.rest.dto.FraudCheckHistoryDto;
import ru.gontarenko.customer.rest.dto.SaveCustomerCommand;
import ru.gontarenko.customer.rest.mapper.CustomerWebMapper;
import ru.gontarenko.customer.service.CustomerService;

import javax.validation.ConstraintViolationException;

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
    CustomerWebMapper mapper;
    RestTemplate restTemplate;
    CommunicationConfig communicationConfig;

    @PostMapping
    public CustomerDto create(@RequestBody SaveCustomerCommand command) {
        log.info("New customer registration request {}", command);
        val customer = service.create(command);

        val fraudCheckHistoryDto = restTemplate.getForObject(
                communicationConfig.getFraudCheckHistoryUrl(),
                FraudCheckHistoryDto.class,
                customer.getId()
        );
        if (fraudCheckHistoryDto.isFraudster()) {
            throw new ConstraintViolationException("customer is fraudster", null);
        }

        return mapper.dto(customer);
    }
}
