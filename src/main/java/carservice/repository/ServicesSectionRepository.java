package carservice.repository;

import carservice.model.services.section.ServicesSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesSectionRepository extends JpaRepository<ServicesSection, Long> {

    Boolean isExsist(String title);
}
