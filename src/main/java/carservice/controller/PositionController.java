package carservice.controller;

import carservice.model.position.PositionDto;
import carservice.model.position.PositionMapping;
import carservice.service.PositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping(path = "/position")
@RequiredArgsConstructor
@Slf4j
@Validated
public class PositionController {

    private final PositionService positionService;

    @PostMapping
    public PositionDto createPosition(@RequestBody @Valid PositionDto positionDto) {
        log.info("Получен запрос к эндпоинту POST /position; positionDto = " + positionDto);
        return positionService.createPosition(positionDto);
    }

    @GetMapping ("/{id}")
    public PositionDto getPositionById(@PathVariable @Positive Long id) {
        log.info(String.format("Получен запрос к эндпоинту GET /position/%d",id));
        return PositionMapping.toPositionDto(positionService.getPositionById(id));
    }

    @PutMapping ("/{id}")
    public PositionDto updatePosition(@RequestBody @Valid PositionDto positionDto, @PathVariable @Positive Long id) {
        log.info(String.format("Получен запрос к эндпоинту PUT /position/%d, positionDto = %s",
                id, positionDto.toString()));
        return positionService.updatePosition(id, positionDto);
    }

    @DeleteMapping ("/{id}")
    public void deletePosition(@PathVariable @Positive Long id) {
        log.info(String.format("Получен запрос к эндпоинту DELETE /position/%d", id));
        positionService.deletePosition(id);
    }
}
