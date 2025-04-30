package uol.compass.hackathon.Banking.System.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import uol.compass.hackathon.Banking.System.model.Account;
import uol.compass.hackathon.Banking.System.model.Customer;
import uol.compass.hackathon.Banking.System.repository.AccountRepository;
import uol.compass.hackathon.Banking.System.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public CustomerService(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public List<Account> getAccountsByCustomerId(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new RuntimeException("Cliente com ID " + customerId + " não encontrado.");
        }
        return accountRepository.findByCustomerId(customerId);
    }

    public Customer findCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Cliente com ID " + customerId + " não encontrado."));
    }
}