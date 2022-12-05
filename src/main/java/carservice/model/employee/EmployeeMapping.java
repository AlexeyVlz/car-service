package carservice.model.employee;

import carservice.model.branch.Branch;
import carservice.model.position.Position;

public class EmployeeMapping {

    public static Employee toEmployee(EmployeeDto employeeDto, Position position, Branch branch) {
        return new Employee(employeeDto.getName(),
                employeeDto.getSurname(),
                position,
                branch);
    }

    public static EmployeeDto toEmployeeDto(Employee employee) {
        return new EmployeeDto(employee.getName(),
                employee.getSurname(),
                employee.getPosition().getTitle(),
                employee.getBranch().getTitle());
    }
}
