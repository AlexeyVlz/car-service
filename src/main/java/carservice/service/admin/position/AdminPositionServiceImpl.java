package carservice.service.admin.position;

import carservice.model.position.Position;
import carservice.model.position.PositionDtoIn;
import carservice.model.position.PositionDtoOut;
import carservice.model.position.PositionMapping;
import carservice.repository.PositionRepository;
import carservice.service.user.position.UserPositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminPositionServiceImpl extends UserPositionServiceImpl implements AdminPositionService {

    @Autowired
    public AdminPositionServiceImpl(PositionRepository positionRepository) {
        super(positionRepository);
    }

    @Override
    public PositionDtoOut createPosition(PositionDtoIn positionDtoIn) {
       Position position = positionRepository.save(PositionMapping.toPosition(positionDtoIn));
       return PositionMapping.toPositionDtoOut(position);
    }

    @Override
    public PositionDtoOut updatePosition(Long id, PositionDtoIn positionDtoIn) {
        Position position = findPositionById(id);
        position.setTitle(positionDtoIn.getTitle());
        positionRepository.save(position);
        return PositionMapping.toPositionDtoOut(position);
    }

    @Override
    public void deletePosition(Long id) {
        getPositionById(id);
        //TODO реализовать проверку на отсутствие сотрудников с данной должностью
        positionRepository.deleteById(id);
    }

}
