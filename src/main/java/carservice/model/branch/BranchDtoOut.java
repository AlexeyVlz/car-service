package carservice.model.branch;

import lombok.Data;

@Data
public class BranchDtoOut {

    private String title;
    private String address;

    public BranchDtoOut(String title, String address) {
        this.title = title;
        this.address = address;
    }
}
