package carservice.model.service;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ServiceDtoOut {

    private String title;
    private String description;
    private Double price;
}
