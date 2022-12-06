package carservice.service.admin.employee;

import carservice.model.employee.EmployeeDtoIn;
import carservice.model.employee.EmployeeDtoOut;

public interface AdminEmployeeService {
    EmployeeDtoOut addNewEmployee(Long branchId, Long positionId, EmployeeDtoIn employeeDtoIn);

    EmployeeDtoOut updateEmployee(Long branchId, Long positionId, EmployeeDtoIn employeeDtoIn, Long employeeId);

    void deleteEmployeeById(Long id);
}
