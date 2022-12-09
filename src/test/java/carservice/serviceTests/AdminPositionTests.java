package carservice.serviceTests;


import carservice.model.position.Position;
import carservice.model.position.PositionDtoIn;
import carservice.model.position.PositionDtoOut;
import carservice.repository.PositionRepository;
import carservice.service.admin.employee.AdminEmployeeService;
import carservice.service.admin.position.AdminPositionService;
import carservice.service.admin.position.AdminPositionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdminPositionTests {

    PositionRepository positionRepository;
    AdminPositionService adminPositionServiceImpl;
    AdminEmployeeService adminEmployeeService;

    private final Position position = new Position(1L, "Электрик");

    @BeforeEach
    public void beforeEach() {
        positionRepository = mock(PositionRepository.class);
        adminPositionServiceImpl = new AdminPositionServiceImpl(positionRepository, adminEmployeeService);
    }

    @Test
    public void updatePosition() {
        PositionDtoIn positionDtoIn = new PositionDtoIn("Механик");
        PositionDtoOut positionDtoOut = new PositionDtoOut("Механик");
        when(positionRepository.findById(1L)).thenReturn(Optional.of(position));
        position.setTitle("Механик");
        when(positionRepository.save(position)).thenReturn(position);
        Assertions.assertEquals(adminPositionServiceImpl.updatePosition(1L, positionDtoIn), positionDtoOut);
    }
}
