package carservice.service.admin.branch;

import carservice.exeption.DataNotFound;
import carservice.model.branch.Branch;
import carservice.model.branch.BranchDtoOut;
import carservice.model.branch.BranchMapping;
import carservice.model.branch.BranchDtoIn;
import carservice.repository.BranchRepository;
import carservice.service.user.branch.UserBranchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminBranchServiceImplImpl extends UserBranchServiceImpl implements AdminBranchService{

    @Autowired
    public AdminBranchServiceImplImpl(BranchRepository branchRepository) {
        super(branchRepository);
    }

    public BranchDtoOut createBranch(BranchDtoIn branchDtoIn) {
        Branch branch = branchRepository.save(BranchMapping.toBranch(branchDtoIn));
        return BranchMapping.toBranchDtoOut(branch);
    }

    public BranchDtoOut updateBranch(Long id, BranchDtoIn branchDtoIn) {
        Branch branch = findBranchById(id);
        branch.setTitle(branchDtoIn.getTitle());
        branch.setAddress(branchDtoIn.getAddress());
        return BranchMapping.toBranchDtoOut(branchRepository.save(branch));
    }

    public void deleteBranchById(Long id) {
        if(!branchRepository.existsById(id))
            throw new DataNotFound(String.format("Филиал с id = %d в базе не обнаружен", id));
        branchRepository.deleteById(id);
    }


}
