package carservice.model.branch;

public class BranchMapping {

    public static Branch toBranch(BranchDtoIn branchDtoIn) {
        Branch branch = new Branch();
        if(branchDtoIn.getAddress() != null) {
            branch.setAddress(branchDtoIn.getAddress());
        }
        if(branchDtoIn.getTitle() != null) {
            branch.setTitle(branchDtoIn.getTitle());
        }
        return branch;
    }

    public static BranchDtoOut toBranchDtoOut(Branch branch){
        return new BranchDtoOut(branch.getTitle(), branch.getAddress());
    }
}
