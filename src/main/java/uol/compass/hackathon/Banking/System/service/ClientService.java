package uol.compass.hackathon.Banking.System.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import uol.compass.hackathon.Banking.System.model.Account;
import uol.compass.hackathon.Banking.System.model.Client;
import uol.compass.hackathon.Banking.System.repository.AccountRepository;
import uol.compass.hackathon.Banking.System.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public ClientService(AccountRepository accountRepository, ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public List<Account> getAccountsByClientId(Long clientId) {
        if (!clientRepository.existsById(clientId)) {
            throw new RuntimeException("Cliente com ID " + clientId + " não encontrado.");
        }
        return accountRepository.findByClientId(clientId);
    }

    public Client findClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Cliente com ID " + clientId + " não encontrado."));
    }
}