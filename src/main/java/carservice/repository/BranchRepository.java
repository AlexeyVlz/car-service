package carservice.repository;

import carservice.model.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BranchRepository extends JpaRepository<Branch, Long> {

}
