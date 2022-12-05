package carservice.service.admin.position;

import carservice.model.position.PositionDto;

public interface AdminPositionService {
    PositionDto createPosition(PositionDto positionDto);

    PositionDto updatePosition(Long id, PositionDto positionDto);

    void deletePosition(Long id);
}
