package hexagonal.demo.controllers;


import hexagonal.demo.dtos.CustomerDTO;
import hexagonal.demo.models.Customer;
import hexagonal.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody NewCustomerDTO dto) {
        try {
            final var output =
                    CreateCustomerUseCase.execute(new CreateCustomerUseCase.Input(dto.cpf(), dto.email(), dto.name()));

            return ResponseEntity.created(URI.create("/customers/" + output.id())).body(output);
        } catch (ValidationException ex) {
            return ResponseEntity.unprocessableEntity().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        var customer = customerService.findById(id);
        if (customer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customer.get());
    }
}