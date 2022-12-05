package carservice.controller.admin;

import carservice.model.employee.EmployeeDto;
import carservice.service.admin.AdminEmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("admin/employee")
@Slf4j
@RequiredArgsConstructor
@Validated
public class AdminEmployeeController {

    private final AdminEmployeeService adminEmployeeService;

    @PostMapping
    public EmployeeDto addNewEmployee(@RequestParam @Positive Long branchId,
                                      @RequestParam @Positive Long positionId,
                                      @RequestBody EmployeeDto employeeDto) {
        return null;
    }
}
