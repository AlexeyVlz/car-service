package carservice.model.branch;

public class BranchMapping {

    public static Branch toBranch(BranchDto branchDto) {
        Branch branch = new Branch();
        if(branchDto.getAddress() != null) {
            branch.setAddress(branchDto.getAddress());
        }
        if(branchDto.getTitle() != null) {
            branch.setTitle(branchDto.getTitle());
        }
        return branch;
    }

    public static BranchDto toBranchDto(Branch branch){
        return new BranchDto(branch.getTitle(), branch.getAddress());
    }
}
