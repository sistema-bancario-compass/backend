package uol.compass.hackathon.Banking.System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uol.compass.hackathon.Banking.System.model.Account;
import uol.compass.hackathon.Banking.System.model.Transaction;
import uol.compass.hackathon.Banking.System.service.CustomerService;
import uol.compass.hackathon.Banking.System.service.TransactionService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService service;

    @Autowired
    private final CustomerService customerService;

    public TransactionController(TransactionService service, CustomerService customerService) {
        this.service = service;
        this.customerService = customerService;
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

    @PostMapping("/accounts")
    public ResponseEntity<List<Account>> getAccountsByCustomer(@RequestBody Map<String, Long> payload) {
        Long customerId = payload.get("customerId");
        if (customerId == null) {
            return ResponseEntity.badRequest().build();
        }
        List<Account> contas = customerService.getAccountsByCustomerId(customerId);
        if (contas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(contas);
    }
}
