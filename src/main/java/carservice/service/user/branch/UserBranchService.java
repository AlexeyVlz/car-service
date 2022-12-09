package carservice.service.user.branch;

import carservice.model.branch.Branch;
import carservice.model.branch.BranchDtoOut;

public interface UserBranchService {

    BranchDtoOut getBranchById(Long id);

    Branch findBranchById(Long id);
}
