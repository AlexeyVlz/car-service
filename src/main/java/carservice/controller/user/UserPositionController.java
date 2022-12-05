package carservice.controller.user;

import carservice.model.position.PositionDto;
import carservice.service.user.UserPositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping(path = "/user/position")
@RequiredArgsConstructor
@Slf4j
@Validated
public class UserPositionController {

    private final UserPositionService positionService;

    @GetMapping ("/{id}")
    public PositionDto getPositionById(@PathVariable @Positive Long id) {
        log.info(String.format("Получен запрос к эндпоинту GET /position/%d",id));
        return positionService.getPositionById(id);
    }
}