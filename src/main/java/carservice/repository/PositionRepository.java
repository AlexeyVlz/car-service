package carservice.repository;

import carservice.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Long, Position> {
}
