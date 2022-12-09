package carservice.service.user.employee;

import carservice.model.employee.Employee;
import carservice.model.employee.EmployeeDtoOut;

public interface UserEmployeeService {
    EmployeeDtoOut getEmployeeById(Long id);

    Employee findEmployeeById(Long id);
}
