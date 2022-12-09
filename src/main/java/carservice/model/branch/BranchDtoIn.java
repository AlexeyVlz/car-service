package carservice.model.branch;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class BranchDtoIn {

    @NotNull @NotBlank
    private String title;
    @NotNull @NotBlank
    private String address;

    public BranchDtoIn(String title, String address) {
        this.title = title;
        this.address = address;
    }
}
