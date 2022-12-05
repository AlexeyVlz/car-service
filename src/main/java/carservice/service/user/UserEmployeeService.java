package carservice.service.user;

import carservice.exeption.DataNotFound;
import carservice.model.employee.Employee;
import carservice.model.employee.EmployeeDto;
import carservice.model.employee.EmployeeMapping;
import carservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeDto getEmployeeById(Long id) {
        return EmployeeMapping.toEmployeeDto(findEmployeeById(id));
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new DataNotFound(
                String.format("Сотрудник с id = %d не обнаружен", id)));
    }
}
