package hexagonal.infrastructure.repositories;

import hexagonal.application.domain.customer.Customer;
import hexagonal.application.domain.customer.CustomerId;
import hexagonal.application.domain.person.Cpf;
import hexagonal.application.domain.person.Email;
import hexagonal.application.repositories.CustomerRepository;
import hexagonal.infrastructure.db.entities.CustomerEntity;
import hexagonal.infrastructure.db.repositories.CustomerDbRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

// Interface Adapter
@Component
public class CustomerDatabaseRepository implements CustomerRepository {

    private final CustomerDbRepository customerDbRepository;

    public CustomerDatabaseRepository(final CustomerDbRepository customerDbRepository) {
        this.customerDbRepository = Objects.requireNonNull(customerDbRepository);
    }

    @Override
    public Optional<Customer> customerOfId(final CustomerId anId) {
        Objects.requireNonNull(anId, "id cannot be null");
        return this.customerDbRepository.findById(UUID.fromString(anId.value()))
                .map(CustomerEntity::toCustomer);
    }

    @Override
    public Optional<Customer> customerOfCPF(final Cpf cpf) {
        Objects.requireNonNull(cpf, "Cpf cannot be null");
        return this.customerDbRepository.findByCpf(cpf.value())
                .map(CustomerEntity::toCustomer);
    }

    @Override
    public Optional<Customer> customerOfEmail(final Email email) {
        Objects.requireNonNull(email, "Email cannot be null");
        return this.customerDbRepository.findByEmail(email.value())
                .map(CustomerEntity::toCustomer);
    }

    @Override
    @Transactional
    public Customer create(final Customer customer) {
        return this.customerDbRepository.save(CustomerEntity.of(customer))
                .toCustomer();
    }

    @Override
    @Transactional
    public Customer update(Customer customer) {
        return this.customerDbRepository.save(CustomerEntity.of(customer))
                .toCustomer();
    }

    @Override
    public void deleteAll() {
        this.customerDbRepository.deleteAll();
    }
}
