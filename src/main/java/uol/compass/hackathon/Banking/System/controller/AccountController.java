package uol.compass.hackathon.Banking.System.controller;

import uol.compass.hackathon.Banking.System.model.Account;
import uol.compass.hackathon.Banking.System.repository.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Account create(@RequestBody Account account) {
        return repository.save(account);
    }

    @GetMapping
    public List<Account> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Account update(@PathVariable Long id, @RequestBody Account updated) {
        return repository.findById(id).map(account -> {
            account.setType(updated.getType());
            account.setBalance(updated.getBalance());
            return repository.save(account);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
