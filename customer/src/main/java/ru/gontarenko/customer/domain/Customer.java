package ru.gontarenko.customer.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@ToString
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
    Integer id;
    String firstName;
    String lastName;
    String email;
}
