package hexagonal.demo.graphql;

import hexagonal.demo.application.usecases.customer.CreateCustomerUseCase;
import hexagonal.demo.application.usecases.customer.GetCustomerByIdUseCase;
import hexagonal.demo.dtos.CustomerDTO;
import hexagonal.demo.models.Customer;
import hexagonal.demo.services.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public class CustomerResolver{

    private  final CustomerService customerService;

    public CustomerResolver (final CustomerService customerService) {
        this.customerService = Objects.requireNonNull(customerService);
    }

    @MutationMapping
    public CreateCustomerUseCase.Output createCustomer(@Argument NewCustomerDTO input) {
        return createCustomerUseCase.execute(new CreateCustomerUseCase.Input(input.cpf(), input.email(), input.name()));
    }


    @QueryMapping
    public GetCustomerByIdUseCase.Output customerOfId(@Argument String id) {
        return getCustomerByIdUseCase.execute(new GetCustomerByIdUseCase.Input(id)).orElse(null);
    }

}
