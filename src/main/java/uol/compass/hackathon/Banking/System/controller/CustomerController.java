package uol.compass.hackathon.Banking.System.controller;


import uol.compass.hackathon.Banking.System.model.Customer;
import uol.compass.hackathon.Banking.System.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
if (repository.findByCpf(customer.getCpf()).isPresent()) {
            throw new RuntimeException("Já existe um cliente cadastrado com este CPF.");
        }
        return repository.save(customer);
    }

    @GetMapping
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer updated) {
        return repository.findById(id).map(customer -> {
            customer.setName(updated.getName());
            customer.setCpf(updated.getCpf());
            return repository.save(customer);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}