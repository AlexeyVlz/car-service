package carservice.service.admin.branch;

import carservice.model.branch.dto.BranchDto;

public interface AdminBranchService {

    BranchDto createBranch(BranchDto branchDto);

    BranchDto updateBranch(Long id, BranchDto branchDto);

    void deleteBranchById(Long id);

}
