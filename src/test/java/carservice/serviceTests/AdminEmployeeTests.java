package carservice.serviceTests;

import carservice.exeption.DataNotFound;
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

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AdminEmployeeTests {

    UserPositionService userPositionService;
    UserBranchService userBranchService;
    EmployeeRepository employeeRepository;
    AdminEmployeeServiceImpl adminEmployeeService;

    Branch branch;
    Position position;
    Employee employee;

    @BeforeEach
    void beforeEach() {
        userPositionService = mock(UserPositionService.class);
        userBranchService = mock(UserBranchService.class);
        employeeRepository = mock(EmployeeRepository.class);
        adminEmployeeService = new AdminEmployeeServiceImpl(employeeRepository, userPositionService, userBranchService);

        branch = new Branch(1L, "Филиал 1", "пр. Гагарина");
        position = new Position(1L, "Электрик");
        employee = new Employee( "Иван", "Иванов", position, branch);
    }

    @Test
    void addNewEmployee() {
        EmployeeDtoIn employeeDtoIn = new EmployeeDtoIn("Иван", "Иванов");
        EmployeeDtoOut employeeDtoOut = new EmployeeDtoOut(
                "Иван", "Иванов", "Электрик", "Филиал 1");
        when(userBranchService.findBranchById(any())).thenAnswer(invocationOnMock -> {
            Long branchId = invocationOnMock.getArgument(0, Long.class);
            if (branchId == 1) return Optional.of(branch).get();
            else throw new DataNotFound("Филиал с id = %d в базе данных не обаружен");
        });
        when(userPositionService.findPositionById(any())).thenAnswer(invocationOnMock -> {
            Long positionId = invocationOnMock.getArgument(0, Long.class);
            if (positionId == 1) return Optional.of(position).get();
            else throw new DataNotFound("Должность с id = %d в базе не обнаружена");
        });
        when(employeeRepository.save(employee)).thenReturn(employee);
        DataNotFound exception = Assertions.assertThrows(
                DataNotFound.class,
                () -> adminEmployeeService.addNewEmployee(777L, 1L, employeeDtoIn));
        Assertions.assertEquals("Филиал с id = %d в базе данных не обаружен",
                exception.getMessage());
        DataNotFound positionException = Assertions.assertThrows(
                DataNotFound.class,
                () -> adminEmployeeService.addNewEmployee(1L, 777L, employeeDtoIn));
        Assertions.assertEquals("Должность с id = %d в базе не обнаружена",
                positionException.getMessage());
        Assertions.assertEquals(adminEmployeeService.addNewEmployee(
                1L, 1L, employeeDtoIn), employeeDtoOut);
    }

    @Test
    void updateEmployee() {
        EmployeeDtoIn employeeDtoIn = new EmployeeDtoIn("Пётр", "Петров");
        EmployeeDtoOut employeeDtoOut = new EmployeeDtoOut("Пётр", "Петров", "Механик", "Филиал 2");
        Branch updatedBranch = new Branch(2L, "Филиал 2", "пр. Ленина");
        Position updatedPosition = new Position(2L, "Механик");
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(userBranchService.findBranchById(2L)).thenReturn(updatedBranch);
        when(userPositionService.findPositionById(2L)).thenReturn(updatedPosition);
        when(employeeRepository.save(employee)).thenReturn(employee);
        EmployeeDtoOut result = adminEmployeeService
                .updateEmployee(2L, 2L, employeeDtoIn, 1L);
        Assertions.assertEquals(result, employeeDtoOut);
    }

    @Test
    void deleteEmployeeById() {
        when(employeeRepository.existsById(777L)).thenReturn(false);
        when(employeeRepository.existsById(1L)).thenReturn(true);
        adminEmployeeService.deleteEmployeeById(1L);
        verify(employeeRepository, times(1)).deleteById(1L);

        DataNotFound exception = Assertions.assertThrows(
                DataNotFound.class,
                () -> adminEmployeeService.deleteEmployeeById(777L));
        Assertions.assertEquals("Сотрудник с id = 777 в базе не обнаружена", exception.getMessage());
    }

    @Test
    void getEmployeesByPosition() {
        when(userPositionService.findPositionById(1L)).thenReturn(new Position(1L, "Электрик"));
        when(userPositionService.findPositionById(777L))
                .thenThrow(new DataNotFound("Должность с id = 777 в базе не обнаружена"));
        List<Employee> employeeList = List.of(employee, new Employee("Пётр", "Петров", position, branch));
        when(employeeRepository.findByPositionId(1L)).thenReturn(employeeList);
        List<EmployeeDtoOut> employeeDtoOutList = List.of(
                new EmployeeDtoOut("Иван", "Иванов", "Электрик", "Филиал 1"),
                new EmployeeDtoOut("Пётр", "Петров","Электрик", "Филиал 1"));
        Assertions.assertEquals(adminEmployeeService.getEmployeesByPosition(1L), employeeDtoOutList);
    }
}
