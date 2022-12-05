package carservice.controller.user;

import carservice.model.employee.EmployeeDto;
import carservice.service.user.UserEmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("user/employee")
@Slf4j
@RequiredArgsConstructor
@Validated
public class UserEmployeeController {

    private final UserEmployeeService userEmployeeService;

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable @Positive Long id) {
        log.info("Получен эндпоинт GET /user/employee/{id}; id = " + id);
        return userEmployeeService.getEmployeeById(id);
    }
}
