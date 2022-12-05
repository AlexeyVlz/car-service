package carservice.service.admin;

import carservice.model.employee.EmployeeDtoIn;
import carservice.model.employee.EmployeeDtoOut;

public interface AdminEmployeeService {
    EmployeeDtoOut addNewEmployee(Long branchId, Long positionId, EmployeeDtoIn employeeDtoIn);

    EmployeeDtoOut updateEmployee(Long branchId, Long positionId, EmployeeDtoIn employeeDtoIn);

    void deleteEmployeeById(Long id);
}
