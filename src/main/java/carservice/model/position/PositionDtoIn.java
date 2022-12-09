package carservice.model.position;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PositionDtoIn {

    @NotNull @NotBlank
    private String title;

    public PositionDtoIn(String title) {
        this.title = title;
    }
}
