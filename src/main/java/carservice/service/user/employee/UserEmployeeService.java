package carservice.service.user.employee;

import carservice.model.employee.Employee;
import carservice.model.employee.EmployeeDto;

public interface UserEmployeeService {
    EmployeeDto getEmployeeById(Long id);

    Employee findEmployeeById(Long id);
}
