package carservice.junitTests;


import carservice.model.position.Position;
import carservice.repository.PositionRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

public class PositionTests {

    private PositionRepository positionRepository;

    private Position position = new Position(1L, "Электрик");

    @BeforeEach
    public void beforeEach() {
        positionRepository = mock(PositionRepository.class);
    }


}
