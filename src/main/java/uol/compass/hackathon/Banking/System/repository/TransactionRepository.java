package uol.compass.hackathon.Banking.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uol.compass.hackathon.Banking.System.model.Account;
import uol.compass.hackathon.Banking.System.model.Client;
import uol.compass.hackathon.Banking.System.model.Transaction;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findBySource(Account source);
}