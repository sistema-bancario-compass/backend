package uol.compass.hackathon.Banking.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uol.compass.hackathon.Banking.System.model.Customer;

public interface CustomerRepository extends JpaRepository<uol.compass.hackathon.Banking.System.model.Customer, Long> {}
