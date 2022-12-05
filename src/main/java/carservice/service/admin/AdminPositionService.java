package carservice.service.admin;

import carservice.model.position.Position;
import carservice.model.position.PositionDto;
import carservice.model.position.PositionMapping;
import carservice.repository.PositionRepository;
import carservice.service.user.UserPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminPositionService extends UserPositionService {

    @Autowired
    public AdminPositionService(PositionRepository positionRepository) {
        super(positionRepository);
    }

    public PositionDto createPosition(PositionDto positionDto) {
       Position position = positionRepository.save(PositionMapping.toPosition(positionDto));
       return PositionMapping.toPositionDto(position);
    }

    public PositionDto updatePosition(Long id, PositionDto positionDto) {
        Position position = findPositionById(id);
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
