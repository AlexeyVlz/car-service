package carservice.service.admin.branch;

import carservice.model.branch.BranchDtoIn;
import carservice.model.branch.BranchDtoOut;

public interface AdminBranchService {

    BranchDtoOut createBranch(BranchDtoIn branchDtoIn);

    BranchDtoOut updateBranch(Long id, BranchDtoIn branchDtoIn);

    void deleteBranchById(Long id);

}
