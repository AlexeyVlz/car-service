package carservice.controller.user;

import carservice.model.employee.EmployeeDtoOut;
import carservice.service.user.employee.UserEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("user/employee")
@Slf4j
@Validated
public class UserEmployeeController {

    private final UserEmployeeService userEmployeeService;
    @Autowired
    public UserEmployeeController(@Qualifier("UserEmployeeServiceImpl") UserEmployeeService userEmployeeService) {
        this.userEmployeeService = userEmployeeService;
    }

    @GetMapping("/{id}")
    public EmployeeDtoOut getEmployeeById(@PathVariable @Positive Long id) {
        log.info("Получен запрос к эндпоинту GET /user/employee/{id}; id = " + id);
        return userEmployeeService.getEmployeeById(id);
    }
}
