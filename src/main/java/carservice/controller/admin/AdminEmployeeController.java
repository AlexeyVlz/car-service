package carservice.controller.admin;

import carservice.model.employee.EmployeeDtoIn;
import carservice.model.employee.EmployeeDtoOut;
import carservice.service.admin.employee.AdminEmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/admin/employee")
@Slf4j
@RequiredArgsConstructor
@Validated
public class AdminEmployeeController {

    private final AdminEmployeeService adminEmployeeService;

    @PostMapping
    public EmployeeDtoOut addNewEmployee(@RequestParam @Positive Long branchId,
                                         @RequestParam @Positive Long positionId,
                                         @RequestBody EmployeeDtoIn employeeDtoIn) {
        log.info(String.format("Получен запрос к эндпоинту POST /admin/employee; branchId = %d, positionId = %d" +
                "employeeDtoIn = %s", branchId, positionId, employeeDtoIn));
        return adminEmployeeService.addNewEmployee(branchId, positionId, employeeDtoIn);
    }

    @PutMapping("/{employeeId}")
    public EmployeeDtoOut updateEmployee(@PathVariable @Positive Long employeeId,
                                         @RequestParam(required = false) @Positive Long branchId,
                                          @RequestParam(required = false) @Positive Long positionId,
                                          @RequestBody EmployeeDtoIn employeeDtoIn){
        log.info("Получен запрос к эндпоинту PUT /admin/employee");
        return adminEmployeeService.updateEmployee(branchId, positionId, employeeDtoIn, employeeId);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable @Positive Long id) {
        log.info("Получен запрос к эндпоинту DELETE /admin/employee/id");
        adminEmployeeService.deleteEmployeeById(id);
    }
}
