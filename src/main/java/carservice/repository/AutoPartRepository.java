package carservice.repository;

import carservice.model.AutoPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoPartRepository extends JpaRepository<Long, AutoPart> {
}
