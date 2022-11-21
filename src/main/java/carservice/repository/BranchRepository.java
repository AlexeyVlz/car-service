package carservice.repository;

import carservice.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Long, Branch> {
}
