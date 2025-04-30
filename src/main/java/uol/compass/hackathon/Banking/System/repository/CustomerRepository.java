package uol.compass.hackathon.Banking.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uol.compass.hackathon.Banking.System.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCpf(String cpf);
}
