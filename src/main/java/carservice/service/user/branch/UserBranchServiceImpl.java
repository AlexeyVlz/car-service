package carservice.service.user.branch;

import carservice.exeption.DataNotFound;
import carservice.model.branch.Branch;
import carservice.model.branch.BranchDtoOut;
import carservice.model.branch.BranchMapping;
import carservice.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserBranchServiceImpl implements UserBranchService{

    protected final BranchRepository branchRepository;

    public BranchDtoOut getBranchById(Long id) {
        return BranchMapping.toBranchDtoOut(findBranchById(id));
    }

    public Branch findBranchById(Long id) {
        return branchRepository.findById(id).orElseThrow(() -> new DataNotFound(String.format(
                "Филиал с id = %d в базе данных не обаружен", id)));
    }
}