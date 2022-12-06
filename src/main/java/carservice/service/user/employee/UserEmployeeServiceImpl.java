package carservice.service.user.employee;

import carservice.exeption.DataNotFound;
import carservice.model.employee.Employee;
import carservice.model.employee.EmployeeDtoOut;
import carservice.model.employee.EmployeeMapping;
import carservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("user")
public class UserEmployeeServiceImpl implements UserEmployeeService {

    protected final EmployeeRepository employeeRepository;
    @Override
    public EmployeeDtoOut getEmployeeById(Long id) {
        return EmployeeMapping.toEmployeeDtoOut(findEmployeeById(id));
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new DataNotFound(
                String.format("Сотрудник с id = %d не обнаружен", id)));
    }
}
