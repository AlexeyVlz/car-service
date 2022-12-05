package carservice.serviceTests;

import carservice.model.branch.Branch;
import carservice.model.branch.dto.BranchDto;
import carservice.repository.BranchRepository;
import carservice.service.admin.AdminBranchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdminBranchTests {

    BranchRepository branchRepository;
    AdminBranchService adminBranchService;

    @BeforeEach
    public void beforeEach() {
        branchRepository = mock(BranchRepository.class);
        adminBranchService = new AdminBranchService(branchRepository);
    }

    @Test
    public void updateBranch() {
        Branch branchFromData = new Branch(1L,"Филиал 1", "Брайнт Бич");
        Branch updatedBranch = new Branch(1L, "Обновленный филиал 1", "Проспект гагарина");
        BranchDto branchDto = new BranchDto( "Обновленный филиал 1", "Проспект гагарина");
        when(branchRepository.findById(1L)).thenReturn(Optional.of(branchFromData));
        when(branchRepository.save(updatedBranch)).thenReturn(updatedBranch);
        Assertions.assertEquals(adminBranchService.updateBranch(1L, branchDto), branchDto);
    }
}
