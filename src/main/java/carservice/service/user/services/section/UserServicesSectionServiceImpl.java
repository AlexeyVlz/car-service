package carservice.service.user.services.section;

import carservice.exeption.ConflictDataException;
import carservice.exeption.DataNotFound;
import carservice.model.services.section.ServicesSection;
import carservice.model.services.section.ServicesSectionDtoIn;
import carservice.model.services.section.ServicesSectionDtoOut;
import carservice.model.services.section.ServicesSectionMapping;
import carservice.repository.ServicesSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
@Qualifier("UserServicesSectionServiceImpl")
public class UserServicesSectionServiceImpl implements UserServicesSectionService{

    private final ServicesSectionRepository servicesSectionRepository;

    @Autowired
    public UserServicesSectionServiceImpl(ServicesSectionRepository servicesSectionRepository) {
        this.servicesSectionRepository = servicesSectionRepository;
    }

    @Override
    public ServicesSectionDtoOut addNewServicesSection(ServicesSectionDtoIn servicesSectionDtoIn) {
        if(servicesSectionRepository.isExsist(servicesSectionDtoIn.getTitle())) throw new ConflictDataException(
                String.format("Услуга с названием %s уже есть в базе", servicesSectionDtoIn.getTitle()));
        ServicesSection servicesSection = servicesSectionRepository
                .save(ServicesSectionMapping.toServicesSection(servicesSectionDtoIn));
        return ServicesSectionMapping.toServicesSectionDtoOut(servicesSection);
    }

    @Override
    public ServicesSectionDtoOut getServicesSectionById(Long id) {
        return ServicesSectionMapping.toServicesSectionDtoOut(findServicesSectionById(id));
    }

    @Override
    public ServicesSection findServicesSectionById(Long id) {
        return servicesSectionRepository.findById(id).orElseThrow(() -> new DataNotFound(
                String.format("Услга с id = %d в базе не обнаружена", id)));
    }
}

