package ru.gontarenko.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gontarenko.customer.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
