package carservice.model.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDtoIn {

    private String name;
    private String surname;
}
