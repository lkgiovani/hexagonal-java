package hexagonal.application.repositories;

import hexagonal.application.domain.customer.Customer;
import hexagonal.application.domain.customer.CustomerId;
import hexagonal.application.domain.person.Cpf;
import hexagonal.application.domain.person.Email;

import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> customerOfId(CustomerId anId);

    Optional<Customer> customerOfCPF(Cpf cpf);

    Optional<Customer> customerOfEmail(Email email);

    Customer create(Customer customer);

    Customer update(Customer customer);

    void deleteAll();
}
