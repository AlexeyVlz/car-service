package carservice.service.user.position;

import carservice.model.position.Position;
import carservice.model.position.PositionDtoOut;

public interface UserPositionService {
    PositionDtoOut getPositionById(Long id);

    Position findPositionById(Long id);
}
