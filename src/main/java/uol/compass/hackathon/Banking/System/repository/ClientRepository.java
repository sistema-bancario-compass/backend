package uol.compass.hackathon.Banking.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uol.compass.hackathon.Banking.System.model.Client;

public interface ClientRepository extends JpaRepository<uol.compass.hackathon.Banking.System.model.Client, Long> {}
