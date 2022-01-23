package ru.gontarenko.customer.rest.dto;

public record SaveCustomerCommand(
        String firstName,
        String lastName,
        String email
) {}
