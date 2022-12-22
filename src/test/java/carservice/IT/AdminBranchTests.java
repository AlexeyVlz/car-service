package carservice.IT;

import carservice.CarServiceApplication;
import carservice.model.branch.Branch;
import carservice.model.branch.BranchDtoIn;
import carservice.service.admin.branch.AdminBranchService;
import carservice.service.admin.branch.AdminBranchServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Transactional
@SpringJUnitConfig({CarServiceApplication.class, AdminBranchServiceImpl.class})
public class AdminBranchTests {

    private final AdminBranchService adminBranchService;
    private final EntityManager em;

    @Autowired
    public AdminBranchTests(@Qualifier("AdminBranchServiceImpl")AdminBranchService adminBranchService, EntityManager em) {
        this.adminBranchService = adminBranchService;
        this.em = em;
    }

    @Test
    void createBranch() {
        Branch branch = new Branch(1L, "Филиал 1", "пр. Гагарина");
        adminBranchService.createBranch(new BranchDtoIn("Филиал 1", "пр. Гагарина"));

        TypedQuery<Branch> query = em.createQuery("Select b from Branch b where b.id = :id", Branch.class);
        Branch queryBranch = query
                .setParameter("id", 1L)
                .getSingleResult();
        Assertions.assertEquals(queryBranch, branch);
    }
}
