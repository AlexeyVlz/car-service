package carservice.model.employee;

import carservice.model.branch.Branch;
import carservice.model.position.Position;

public class EmployeeMapping {

    public static Employee toEmployee(EmployeeDtoIn employeeDtoIn, Position position, Branch branch) {
        return new Employee(employeeDtoIn.getName(),
                employeeDtoIn.getSurname(),
                position,
                branch);
    }

    public static EmployeeDtoOut toEmployeeDto(Employee employee) {
        return new EmployeeDtoOut(employee.getName(),
                employee.getSurname(),
                employee.getPosition().getTitle(),
                employee.getBranch().getTitle());
    }
}
