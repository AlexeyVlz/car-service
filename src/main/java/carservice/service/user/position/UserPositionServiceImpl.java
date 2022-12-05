package carservice.service.user.position;

import carservice.exeption.DataNotFound;
import carservice.model.position.Position;
import carservice.model.position.PositionDtoOut;
import carservice.model.position.PositionMapping;
import carservice.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPositionServiceImpl implements UserPositionService {

    protected final PositionRepository positionRepository;

    @Override
    public PositionDtoOut getPositionById(Long id) {
        return PositionMapping.toPositionDtoOut(findPositionById(id));
    }

    @Override
    public Position findPositionById(Long id){
        return positionRepository.findById(id).orElseThrow(() -> new DataNotFound(String.format(
                "Должность с id = %d в базе не обнаружена", id)));
    }
}
