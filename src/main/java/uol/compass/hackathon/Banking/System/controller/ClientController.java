package uol.compass.hackathon.Banking.System.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uol.compass.hackathon.Banking.System.dto.ClientDTO;
import uol.compass.hackathon.Banking.System.model.Client;
import uol.compass.hackathon.Banking.System.repository.ClientRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository clientRepository;

    // --- CREATE
    @PostMapping
    public ResponseEntity<Client> createClient(@Valid @RequestBody ClientDTO dto) {
        Client client = toEntity(dto);
        Client saved = clientRepository.save(client);
        // Retorna 201 Created com header Location
        return ResponseEntity
                .created(URI.create("/clients/" + saved.getId()))
                .body(saved);
    }

    // --- READ ALL
    @GetMapping
    public ResponseEntity<List<Client>> listAll() {
        List<Client> all = clientRepository.findAll();
        return ResponseEntity.ok(all);
    }

    // --- READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable Long id) {
        Optional<Client> opt = clientRepository.findById(id);
        return opt
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // --- UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(
            @PathVariable Long id,
            @Valid @RequestBody ClientDTO dto
    ) {
        return clientRepository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setEmail(dto.getEmail());
                    existing.setBirthdate(dto.getBirthdate());
                    Client updated = clientRepository.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // --- DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // --- Mapper DTO → Entity
    private Client toEntity(ClientDTO dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setBirthdate(dto.getBirthdate());
        return client;
    }
}
