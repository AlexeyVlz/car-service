package carservice.service.admin.position;

import carservice.model.position.Position;
import carservice.model.position.PositionDto;
import carservice.model.position.PositionMapping;
import carservice.repository.PositionRepository;
import carservice.service.user.position.UserPositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminPositionServiceImplImpl extends UserPositionServiceImpl implements AdminPositionService {

    @Autowired
    public AdminPositionServiceImplImpl(PositionRepository positionRepository) {
        super(positionRepository);
    }

    @Override
    public PositionDto createPosition(PositionDto positionDto) {
       Position position = positionRepository.save(PositionMapping.toPosition(positionDto));
       return PositionMapping.toPositionDto(position);
    }

    @Override
    public PositionDto updatePosition(Long id, PositionDto positionDto) {
        Position position = findPositionById(id);
        position.setTitle(positionDto.getTitle());
        positionRepository.save(position);
        return PositionMapping.toPositionDto(position);
    }

    @Override
    public void deletePosition(Long id) {
        getPositionById(id);
        //TODO реализовать проверку на отсутствие сотрудников с данной должностью
        positionRepository.deleteById(id);
    }

}
