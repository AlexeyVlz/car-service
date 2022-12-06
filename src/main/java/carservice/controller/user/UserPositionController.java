package carservice.controller.user;

import carservice.model.position.PositionDtoOut;
import carservice.service.user.position.UserPositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping(path = "/user/position")
@Slf4j
@Validated
public class UserPositionController {

    private final UserPositionService positionService;

    @Autowired
    public UserPositionController(@Qualifier("UserPositionServiceImpl") UserPositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping ("/{id}")
    public PositionDtoOut getPositionById(@PathVariable @Positive Long id) {
        log.info(String.format("Получен запрос к эндпоинту GET /position/%d",id));
        return positionService.getPositionById(id);
    }
}
