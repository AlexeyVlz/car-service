package carservice.repository;

import carservice.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}