package carservice.service.admin.employee;

import carservice.model.branch.Branch;
import carservice.model.employee.Employee;
import carservice.model.employee.EmployeeDtoIn;
import carservice.model.employee.EmployeeDtoOut;
import carservice.model.employee.EmployeeMapping;
import carservice.model.position.Position;
import carservice.repository.EmployeeRepository;
import carservice.service.user.branch.UserBranchService;
import carservice.service.user.employee.UserEmployeeServiceImpl;
import carservice.service.user.position.UserPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AdminEmployeeServiceImpl extends UserEmployeeServiceImpl implements AdminEmployeeService {

    private final UserPositionService userPositionService;
    private final UserBranchService userBranchService;

    @Autowired
    public AdminEmployeeServiceImpl(EmployeeRepository employeeRepository,
                                    @Qualifier("user") UserPositionService userPositionService,
                                    @Qualifier("user") UserBranchService userBranchService) {
        super(employeeRepository);
        this.userPositionService = userPositionService;
        this.userBranchService = userBranchService;
    }

    @Override
    public EmployeeDtoOut addNewEmployee(Long branchId, Long positionId, EmployeeDtoIn employeeDtoIn) {
        Branch branch = userBranchService.findBranchById(branchId);
        Position position = userPositionService.findPositionById(positionId);
        Employee employee = EmployeeMapping.toEmployee(employeeDtoIn, position, branch);
        return EmployeeMapping.toEmployeeDtoOut(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDtoOut updateEmployee(Long branchId, Long positionId, EmployeeDtoIn employeeDtoIn, Long employeeId) {
        Employee employee = findEmployeeById(employeeId);
        if (branchId != null) employee.setBranch(userBranchService.findBranchById(branchId));
        if (positionId != null) employee.setPosition(userPositionService.findPositionById(positionId));
        employee.setName(employeeDtoIn.getName());
        employee.setSurname(employeeDtoIn.getSurname());
        return EmployeeMapping.toEmployeeDtoOut(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployeeById(Long id) {
        if (employeeRepository.existsById(id)) employeeRepository.deleteById(id);
    }
}
