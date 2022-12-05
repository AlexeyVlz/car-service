package carservice.service.admin.position;

import carservice.model.position.PositionDtoIn;
import carservice.model.position.PositionDtoOut;

public interface AdminPositionService {
    PositionDtoOut createPosition(PositionDtoIn positionDtoIn);

    PositionDtoOut updatePosition(Long id, PositionDtoIn positionDtoIn);

    void deletePosition(Long id);
}
