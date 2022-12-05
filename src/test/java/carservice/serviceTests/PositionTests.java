package carservice.serviceTests;


import carservice.model.position.Position;
import carservice.model.position.PositionDto;
import carservice.repository.PositionRepository;
import carservice.service.admin.AdminPositionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PositionTests {

    PositionRepository positionRepository;
    AdminPositionService adminPositionService;

    private final Position position = new Position(1L, "Электрик");

    @BeforeEach
    public void beforeEach() {
        positionRepository = mock(PositionRepository.class);
        adminPositionService = new AdminPositionService(positionRepository);
    }

    @Test
    public void updatePosition() {
        PositionDto positionDto = new PositionDto("Механик");
        when(positionRepository.findById(1L)).thenReturn(Optional.of(position));
        position.setTitle("Механик");
        when(positionRepository.save(any())).thenReturn(position);
        Assertions.assertEquals(adminPositionService.updatePosition(1L, positionDto), positionDto);
    }


}
