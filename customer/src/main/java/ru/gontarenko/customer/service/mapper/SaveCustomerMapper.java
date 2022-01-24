package ru.gontarenko.customer.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.gontarenko.customer.domain.Customer;
import ru.gontarenko.customer.rest.dto.SaveCustomerCommand;

@Mapper
public interface SaveCustomerMapper {
    void update(@MappingTarget Customer customer, SaveCustomerCommand command);
}
