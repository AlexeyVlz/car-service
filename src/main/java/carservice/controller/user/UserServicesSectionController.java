package carservice.controller.user;

import carservice.model.services.section.ServicesSectionDtoIn;
import carservice.model.services.section.ServicesSectionDtoOut;
import carservice.service.user.services.section.UserServicesSectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/user/services-section")
@Slf4j
@Validated
public class UserServicesSectionController {

    private final UserServicesSectionService service;

    @Autowired
    public UserServicesSectionController(UserServicesSectionService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ServicesSectionDtoOut getServicesSectionById(@PathVariable @Positive Long id) {
        log.info("Получен запрос к эндпоинту GET /user/services-section/{id}; id = " + id);
        return service.getServicesSectionById(id);
    }

    @PostMapping
    public ServicesSectionDtoOut addNewServicesSection(@RequestBody ServicesSectionDtoIn servicesSectionDtoIn){
        log.info("Получен запрос к эндпоинту POST /user/services-section; servicesSectionDtoIn = " + servicesSectionDtoIn);
        return service.addNewServicesSection(servicesSectionDtoIn);
    }
}
