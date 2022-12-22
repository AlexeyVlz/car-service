package carservice.controller.admin;

import carservice.model.client.ClientDtoIn;
import carservice.model.client.ClientDtoOut;
import carservice.service.admin.client.AdminClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/admin/client")
@Validated
@Slf4j
public class AdminClientController {

    private final AdminClientService adminClientService;

    @Autowired
    public AdminClientController(@Qualifier("AdminClientServiceImpl") AdminClientService adminClientService) {
        this.adminClientService = adminClientService;
    }

    @PutMapping("/{id}")
    public ClientDtoOut updateClient(@RequestBody @Valid ClientDtoIn clientDtoIn,
                                     @PathVariable @Positive Long id) {
        log.info(String.format(
                "Получен запрос к эндпоинту PUT /admin/client/{id}; id = %d, clientDtoIn = %s", id, clientDtoIn));
        return adminClientService.updateClient(clientDtoIn, id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable @Positive Long id) {
        log.info("Получен запрос к эндпоинту DELETE /admin/client/{id}; id =" + id);
        adminClientService.deleteClient(id);
    }
}
