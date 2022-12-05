package carservice.service.user;

import carservice.exeption.DataNotFound;
import carservice.model.branch.Branch;
import carservice.model.branch.dto.BranchDto;
import carservice.model.branch.BranchMapping;
import carservice.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserBranchService {

    protected final BranchRepository branchRepository;

    public BranchDto getBranchById(Long id) {
        return BranchMapping.toBranchDto(findBranchById(id));
    }

    public Branch findBranchById(Long id) {
        return branchRepository.findById(id).orElseThrow(() -> new DataNotFound(String.format(
                "Филиал с id = %d в базе данных не обаружен", id)));
    }
}
