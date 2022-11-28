package carservice.model.position;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PositionDto {

    @NotNull @NotBlank
    private String title;

    public PositionDto(String title) {
        this.title = title;
    }
}
