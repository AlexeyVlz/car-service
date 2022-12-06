package carservice.service.user.position;

import carservice.exeption.DataNotFound;
import carservice.model.position.Position;
import carservice.model.position.PositionDtoOut;
import carservice.model.position.PositionMapping;
import carservice.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("UserPositionServiceImpl")
public class UserPositionServiceImpl implements UserPositionService {

    protected final PositionRepository positionRepository;
    @Autowired
    public UserPositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

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
