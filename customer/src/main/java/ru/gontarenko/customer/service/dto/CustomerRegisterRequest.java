package ru.gontarenko.customer.service.dto;

public record CustomerRegisterRequest(
        String firstName,
        String lastName,
        String email
) {}
