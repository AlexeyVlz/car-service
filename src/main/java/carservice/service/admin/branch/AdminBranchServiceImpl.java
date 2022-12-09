package carservice.service.admin.branch;

import carservice.exeption.DataNotFound;
import carservice.model.branch.Branch;
import carservice.model.branch.BranchDtoOut;
import carservice.model.branch.BranchMapping;
import carservice.model.branch.BranchDtoIn;
import carservice.repository.BranchRepository;
import carservice.service.user.branch.UserBranchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("AdminBranchServiceImpl")
public class AdminBranchServiceImpl extends UserBranchServiceImpl implements AdminBranchService{

    @Autowired
    public AdminBranchServiceImpl(BranchRepository branchRepository) {
        super(branchRepository);
    }

    @Override
    public BranchDtoOut createBranch(BranchDtoIn branchDtoIn) {
        Branch branch = branchRepository.save(BranchMapping.toBranch(branchDtoIn));
        return BranchMapping.toBranchDtoOut(branch);
    }

    @Override
    public BranchDtoOut updateBranch(Long id, BranchDtoIn branchDtoIn) {
        Branch branch = findBranchById(id);
        branch.setTitle(branchDtoIn.getTitle());
        branch.setAddress(branchDtoIn.getAddress());
        return BranchMapping.toBranchDtoOut(branchRepository.save(branch));
    }

    @Override
    public void deleteBranchById(Long id) {
        if(!branchRepository.existsById(id))
            throw new DataNotFound(String.format("Филиал с id = %d в базе не обнаружен", id));
        branchRepository.deleteById(id);
    }


}
