package uol.compass.hackathon.Banking.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uol.compass.hackathon.Banking.System.model.Account;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByClientId(Long clientId);
}