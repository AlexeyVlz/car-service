package carservice.controller.admin;

import carservice.model.position.PositionDtoIn;
import carservice.model.position.PositionDtoOut;
import carservice.service.admin.position.AdminPositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping(path = "admin/position")
@Slf4j
@Validated
public class AdminPositionController {

    private final AdminPositionService positionService;

    @Autowired
    public AdminPositionController(AdminPositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping
    public PositionDtoOut createPosition(@RequestBody @Valid PositionDtoIn positionDtoIn) {
        log.info("Получен запрос к эндпоинту POST /position; positionDto = " + positionDtoIn);
        return positionService.createPosition(positionDtoIn);
    }

    @PutMapping ("/{id}")
    public PositionDtoOut updatePosition(@RequestBody @Valid PositionDtoIn positionDtoIn, @PathVariable @Positive Long id) {
        log.info(String.format("Получен запрос к эндпоинту PUT /position/%d, positionDto = %s",
                id, positionDtoIn.toString()));
        return positionService.updatePosition(id, positionDtoIn);
    }

    @DeleteMapping ("/{id}")
    public void deletePosition(@PathVariable @Positive Long id) {
        log.info(String.format("Получен запрос к эндпоинту DELETE /position/%d", id));
        positionService.deletePosition(id);
    }
}
