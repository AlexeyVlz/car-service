package carservice.service;

import carservice.exeption.DataNotFound;
import carservice.model.branch.Branch;
import carservice.model.branch.BranchDto;
import carservice.model.branch.BranchMapping;
import carservice.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    public BranchDto createBranch(BranchDto branchDto) {
        Branch branch = branchRepository.save(BranchMapping.toBranch(branchDto));
        return BranchMapping.toBranchDto(branch);
    }

    public Branch getBranchById(Long id) {
        return branchRepository.findById(id).orElseThrow(() -> new DataNotFound(String.format(
                "Филиал с id = %d в базе данных не обаружен", id)));
    }

    public BranchDto updateBranch(Long id, BranchDto branchDto) {
        if(!isExist(id)) throw new DataNotFound(String.format("Филиал с id = %d в базе не обнаружен", id));
        return BranchMapping.toBranchDto(branchRepository.updateBranch(branchDto.getTitle(), branchDto.getAddress(), id));
    }

    public void deleteBranchById(Long id) {
        if(!isExist(id)) throw new DataNotFound(String.format("Филиал с id = %d в базе не обнаружен", id));
        branchRepository.deleteById(id);
    }

    private Boolean isExist(Long id) {
        return branchRepository.existsById(id);
    }
}
