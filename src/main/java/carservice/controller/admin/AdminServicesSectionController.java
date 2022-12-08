package carservice.controller.admin;

import carservice.model.services.section.ServicesSectionDtoIn;
import carservice.model.services.section.ServicesSectionDtoOut;
import carservice.service.admin.service.section.AdminServicesSectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/admin/services-section")
@Slf4j
@Validated
public class AdminServicesSectionController {

    private final AdminServicesSectionService service;

    public AdminServicesSectionController(AdminServicesSectionService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public ServicesSectionDtoOut updateServicesSection(@PathVariable @Positive Long id,
                                                       @RequestBody ServicesSectionDtoIn servicesSectionDtoIn) {
        log.info("Получен запрос к эндпоинту PUT /admin/services-section/{id}; id = " + id);
        return service.updateServicesSection(id, servicesSectionDtoIn);
    }

    @DeleteMapping("/{id}")
    public void deleteServicesSection(@PathVariable @Positive Long id) {
        log.info("Получен запрос к эндпоинту DELETE /admin/services-section/{id}; id = " + id);
        service.deleteServicesSection(id);
    }
}
