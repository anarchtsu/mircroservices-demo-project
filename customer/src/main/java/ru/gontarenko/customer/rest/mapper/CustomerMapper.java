package ru.gontarenko.customer.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.gontarenko.customer.domain.Customer;
import ru.gontarenko.customer.rest.dto.CustomerDto;
import ru.gontarenko.customer.rest.dto.SaveCustomerCommand;

@Mapper
public interface CustomerMapper {
    CustomerDto dto(Customer customer);

    void update(@MappingTarget Customer customer, SaveCustomerCommand command);
}
