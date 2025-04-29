package uol.compass.hackathon.Banking.System.controller;

import org.springframework.web.bind.annotation.*;
import uol.compass.hackathon.Banking.System.model.Transaction;
import uol.compass.hackathon.Banking.System.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        return service.processTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> findAll() {
        return service.findAll(); // Você pode implementar esse método no service se quiser.
    }

    @GetMapping("/{id}")
    public Transaction findById(@PathVariable Long id) {
        return service.findById(id); // Idem
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id); // Idem
    }
}
