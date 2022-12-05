package carservice.service.admin;

import carservice.exeption.DataNotFound;
import carservice.model.branch.Branch;
import carservice.model.branch.BranchMapping;
import carservice.model.branch.dto.BranchDto;
import carservice.repository.BranchRepository;
import carservice.service.user.UserBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminBranchService extends UserBranchService {

    @Autowired
    public AdminBranchService(BranchRepository branchRepository) {
        super(branchRepository);
    }

    public BranchDto createBranch(BranchDto branchDto) {
        Branch branch = branchRepository.save(BranchMapping.toBranch(branchDto));
        return BranchMapping.toBranchDto(branch);
    }

    public BranchDto updateBranch(Long id, BranchDto branchDto) {
        Branch branch = findBranchById(id);
        branch.setTitle(branchDto.getTitle());
        branch.setAddress(branchDto.getAddress());
        return BranchMapping.toBranchDto(branchRepository.save(branch));
    }

    public void deleteBranchById(Long id) {
        if(!branchRepository.existsById(id))
            throw new DataNotFound(String.format("Филиал с id = %d в базе не обнаружен", id));
        branchRepository.deleteById(id);
    }


}
