package carservice.model.services.section;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
public class ServicesSectionDtoIn {

    @NotNull @NotBlank
    private String title;
    @NotNull @NotBlank
    private String description;
    @NotNull @NotBlank
    private Double price;
}
