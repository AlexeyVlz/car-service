package carservice.service.admin.position;

import carservice.exeption.ConflictDataException;
import carservice.model.employee.EmployeeDtoOut;
import carservice.model.position.Position;
import carservice.model.position.PositionDtoIn;
import carservice.model.position.PositionDtoOut;
import carservice.model.position.PositionMapping;
import carservice.repository.PositionRepository;
import carservice.service.admin.employee.AdminEmployeeService;
import carservice.service.user.position.UserPositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("AdminPositionServiceImpl")
public class AdminPositionServiceImpl extends UserPositionServiceImpl implements AdminPositionService {

    private final AdminEmployeeService adminEmployeeService;

    @Autowired
    public AdminPositionServiceImpl(PositionRepository positionRepository,
                                   AdminEmployeeService adminEmployeeService) {
        super(positionRepository);
        this.adminEmployeeService = adminEmployeeService;
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
        List<EmployeeDtoOut> employees = adminEmployeeService.getEmployeesByPosition(id);
        if(employees.size() > 0) throw new ConflictDataException("Нельзя удалить должность, " +
                "так как она закреплена за следующими сотрудниками: " + employees);
        positionRepository.deleteById(id);
    }

}
