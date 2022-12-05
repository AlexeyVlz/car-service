package carservice.service.user;

import carservice.exeption.DataNotFound;
import carservice.model.position.Position;
import carservice.model.position.PositionDto;
import carservice.model.position.PositionMapping;
import carservice.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPositionService {

    protected final PositionRepository positionRepository;

    public PositionDto getPositionById(Long id) {
        return PositionMapping.toPositionDto(findPositionById(id));
    }

    public Position findPositionById(Long id){
        return positionRepository.findById(id).orElseThrow(() -> new DataNotFound(String.format(
                "Должность с id = %d в базе не обнаружена", id)));
    }
}
