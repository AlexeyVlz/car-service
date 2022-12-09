package carservice.model.services.section;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ServicesSectionDtoOut {

    private String title;
    private String description;
    private Double price;
}
