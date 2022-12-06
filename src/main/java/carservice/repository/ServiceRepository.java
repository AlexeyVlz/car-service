package carservice.repository;

import carservice.model.service.ServicesSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServicesSection, Long> {
}
