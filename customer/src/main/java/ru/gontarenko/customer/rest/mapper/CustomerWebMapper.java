package ru.gontarenko.customer.rest.mapper;

import org.mapstruct.Mapper;
import ru.gontarenko.customer.domain.Customer;
import ru.gontarenko.customer.rest.dto.CustomerDto;

@Mapper
public interface CustomerWebMapper {
    CustomerDto dto(Customer customer);
}
