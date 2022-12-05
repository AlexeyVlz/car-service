package carservice.service.user.position;

import carservice.model.position.Position;
import carservice.model.position.PositionDto;

public interface UserPositionService {
    PositionDto getPositionById(Long id);

    Position findPositionById(Long id);
}
