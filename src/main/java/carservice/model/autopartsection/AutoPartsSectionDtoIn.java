package carservice.model.autopartsection;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class AutoPartsSectionDtoIn {

    @NotNull @NotBlank
    private String title;
}
