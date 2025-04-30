package uol.compass.hackathon.Banking.System.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import uol.compass.hackathon.Banking.System.model.Account;
import uol.compass.hackathon.Banking.System.model.Transaction;
import uol.compass.hackathon.Banking.System.repository.AccountRepository;
import uol.compass.hackathon.Banking.System.repository.TransactionRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Transaction processTransaction(Transaction transaction) {
        Account source = accountRepository.findById(transaction.getSource().getId())
                .orElseThrow(() -> new RuntimeException("Conta de origem não encontrada."));


        double amount = transaction.getAmount();

        switch (transaction.getType().toLowerCase()) {
            case "deposit":
                source.setBalance(source.getBalance() + amount);
                accountRepository.save(source);
                break;

            case "withdraw":
                if (source.getBalance() < amount) {
                    throw new RuntimeException("Saldo insuficiente.");
                }
                source.setBalance(source.getBalance() - amount);
                accountRepository.save(source);
                break;

            case "transfer":
                if (source.getBalance() < amount) {
                    throw new RuntimeException("Saldo insuficiente para transferência.");
                }
                source.setBalance(source.getBalance() - amount);
                accountRepository.save(source);
                break;

            default:
                throw new IllegalArgumentException("Tipo de transação inválido: " + transaction.getType());
        }

        transaction.setDate(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }
}
