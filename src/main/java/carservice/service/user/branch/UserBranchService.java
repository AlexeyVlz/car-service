package carservice.service.user.branch;

import carservice.model.branch.Branch;
import carservice.model.branch.dto.BranchDto;

public interface UserBranchService {

    BranchDto getBranchById(Long id);

    Branch findBranchById(Long id);
}
