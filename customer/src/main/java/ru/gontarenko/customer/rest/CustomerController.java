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
import ru.gontarenko.customer.service.CustomerService;
import ru.gontarenko.customer.service.dto.CustomerRegisterRequest;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {
    CustomerService service;

    @PostMapping("/registration")
    public void register(@RequestBody CustomerRegisterRequest request) {
        log.info("New customer registration request {}", request);
        val customer = service.register(request);
        log.info("New customer was saved {}", customer);
        // todo return new customer dto
    }
    // http://localhost:8080/swagger-ui.html
}
