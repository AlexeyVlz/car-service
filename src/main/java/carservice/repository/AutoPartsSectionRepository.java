package carservice.repository;

import carservice.model.AutoPartsSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoPartsSectionRepository extends JpaRepository<Long, AutoPartsSection> {
}
