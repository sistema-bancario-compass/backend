package uol.compass.hackathon.Banking.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uol.compass.hackathon.Banking.System.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {}