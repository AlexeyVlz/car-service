package carservice.service.admin.service.section;

import carservice.exeption.DataNotFound;
import carservice.model.services.section.ServicesSection;
import carservice.model.services.section.ServicesSectionDtoIn;
import carservice.model.services.section.ServicesSectionDtoOut;
import carservice.model.services.section.ServicesSectionMapping;
import carservice.repository.ServicesSectionRepository;
import carservice.service.user.services.section.UserServicesSectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServicesSectionServiceImpl extends UserServicesSectionServiceImpl
        implements AdminServicesSectionService {

    @Autowired
    public AdminServicesSectionServiceImpl(ServicesSectionRepository servicesSectionRepository) {
        super(servicesSectionRepository);
    }

    @Override
    public ServicesSectionDtoOut updateServicesSection(Long id, ServicesSectionDtoIn servicesSectionDtoIn) {
        ServicesSection servicesSection = findServicesSectionById(id);
        if (servicesSectionDtoIn.getTitle() != null) servicesSection.setTitle(servicesSectionDtoIn.getTitle());
        if (servicesSectionDtoIn.getDescription() != null)
            servicesSection.setDescription(servicesSectionDtoIn.getDescription());
        if(servicesSectionDtoIn.getPrice() != null) servicesSection.setPrice(servicesSectionDtoIn.getPrice());
        return ServicesSectionMapping.toServicesSectionDtoOut(servicesSectionRepository.save(servicesSection));
    }

    @Override
    public void deleteServicesSection(Long id) {
        if (servicesSectionRepository.existsById(id)) servicesSectionRepository.deleteById(id);
        else throw new DataNotFound(String.format("Услга с id = %d в базе не обнаружена", id));
     }
}
