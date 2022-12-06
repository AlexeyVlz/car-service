package carservice.service.admin.employee;

import carservice.model.employee.EmployeeDtoIn;
import carservice.model.employee.EmployeeDtoOut;

import java.util.List;

public interface AdminEmployeeService {
    EmployeeDtoOut addNewEmployee(Long branchId, Long positionId, EmployeeDtoIn employeeDtoIn);

    EmployeeDtoOut updateEmployee(Long branchId, Long positionId, EmployeeDtoIn employeeDtoIn, Long employeeId);

    void deleteEmployeeById(Long id);

    List<EmployeeDtoOut> getEmployeesByPosition(Long id);
}
