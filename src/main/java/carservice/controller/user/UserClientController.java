package carservice.controller.user;

import carservice.model.client.ClientDtoIn;
import carservice.model.client.ClientDtoOut;
import carservice.service.user.client.UserClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/user/client")
@Slf4j
@Validated
public class UserClientController {

    private final UserClientService userClientService;

    @Autowired
    public UserClientController(@Qualifier("UserClientServiceImpl") UserClientService userClientService) {
        this.userClientService = userClientService;
    }

    @PostMapping
    public ClientDtoOut addNewClient(@RequestBody @Valid ClientDtoIn clientDtoIn) {
        log.info("Получен запрос к эндпоинту POST /user/client; clientDtoIn = " + clientDtoIn);
        return userClientService.addNewClient(clientDtoIn);
    }

    @GetMapping("/{id}")
    public ClientDtoOut getClientById(@PathVariable @Positive Long id) {
        log.info("Получен запрос к эндпоинту GET /user/client/{id}; id = " + id);
        return userClientService.getClientById(id);
    }
}
