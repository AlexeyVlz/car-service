package carservice.serviceTests;

import carservice.model.branch.Branch;
import carservice.model.employee.Employee;
import carservice.model.employee.EmployeeDtoIn;
import carservice.model.employee.EmployeeDtoOut;
import carservice.model.position.Position;
import carservice.repository.EmployeeRepository;
import carservice.service.admin.employee.AdminEmployeeServiceImpl;
import carservice.service.user.branch.UserBranchService;
import carservice.service.user.position.UserPositionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdminEmployeeTests {

    UserPositionService userPositionService;
    UserBranchService userBranchService;
    EmployeeRepository employeeRepository;
    AdminEmployeeServiceImpl adminEmployeeService;

    @BeforeEach
    void beforeEach() {
        userPositionService = mock(UserPositionService.class);
        userBranchService = mock(UserBranchService.class);
        employeeRepository = mock(EmployeeRepository.class);
        adminEmployeeService = new AdminEmployeeServiceImpl(employeeRepository, userPositionService, userBranchService);
    }

    @Test
    void updateEmployee() {
        EmployeeDtoIn employeeDtoIn = new EmployeeDtoIn("Пётр", "Петров");
        EmployeeDtoOut employeeDtoOut = new EmployeeDtoOut("Пётр", "Петров", "Механик", "Филиал 2");
        Branch branch = new Branch(1L, "Филиал 1", "пр. Гагарина");
        Branch updatedBranch = new Branch(2L, "Филиал 2", "пр. Ленина");
        Position position = new Position(1L, "Электрик");
        Position updatedPosition = new Position(2L, "Механик");
        Employee employee = new Employee(1L, "Иван", "Иванов", position, branch);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(userBranchService.findBranchById(2L)).thenReturn(updatedBranch);
        when(userPositionService.findPositionById(2L)).thenReturn(updatedPosition);
        when(employeeRepository.save(employee)).thenReturn(employee);
        EmployeeDtoOut result = adminEmployeeService
                .updateEmployee(2L, 2L, employeeDtoIn, 1L);
        Assertions.assertEquals(result, employeeDtoOut);


    }
}
