package carservice.model.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDtoOut {

    private String name;
    private String surname;
    private String position;
    private String branch;
}
