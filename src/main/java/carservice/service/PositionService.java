package carservice.service;

import carservice.exeption.DataNotFound;
import carservice.model.position.Position;
import carservice.model.position.PositionDto;
import carservice.model.position.PositionMapping;
import carservice.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionService {

    private final PositionRepository positionRepository;
    public PositionDto createPosition(PositionDto positionDto) {
       Position position = positionRepository.save(PositionMapping.toPosition(positionDto));
       return PositionMapping.toPositionDto(position);
    }

    public Position getPositionById(Long id) {
        return positionRepository.findById(id).orElseThrow(() -> new DataNotFound(String.format(
                "Должность с id = %d в базе не обнаружена", id)));
    }

    public PositionDto updatePosition(Long id, PositionDto positionDto) {
        Position position = getPositionById(id);
        position.setTitle(positionDto.getTitle());
        positionRepository.save(position);
        return PositionMapping.toPositionDto(position);
    }

    public void deletePosition(Long id) {
        getPositionById(id);
        //TODO реализовать проверку на отсутствие сотрудников с данной должностью
        positionRepository.deleteById(id);
    }

}
