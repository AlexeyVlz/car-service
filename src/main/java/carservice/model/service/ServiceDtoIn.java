package carservice.model.service;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class ServiceDtoIn {

    @NotNull @NotBlank
    private String title;
    @NotNull @NotBlank
    private String description;
    @NotNull @NotBlank
    private Double price;
}
