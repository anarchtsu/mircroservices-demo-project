package ru.gontarenko.customer.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.gontarenko.customer.domain.Customer;
import ru.gontarenko.customer.service.dto.CustomerRegisterRequest;

@Mapper
public interface CustomerMapper {
    void update(@MappingTarget Customer customer, CustomerRegisterRequest request);
}
