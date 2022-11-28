package carservice.repository;

import carservice.model.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    @Query("update Branch set title = ?1, address = ?2 where id = ?3")
    Branch updateBranch(String title, String address, Long id);
}
