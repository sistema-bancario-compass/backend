package uol.compass.hackathon.Banking.System.controller;


import uol.compass.hackathon.Banking.System.model.Client;
import uol.compass.hackathon.Banking.System.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class ClientController {
    private final ClientRepository repository;

    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        return repository.save(client);
    }

    @GetMapping
    public List<Client> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client updated) {
        return repository.findById(id).map(client -> {
            client.setName(updated.getName());
            client.setCpf(updated.getCpf());
            return repository.save(client);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}