package carservice.service.user.services.section;

import carservice.model.services.section.ServicesSection;
import carservice.model.services.section.ServicesSectionDtoIn;
import carservice.model.services.section.ServicesSectionDtoOut;

public interface UserServicesSectionService {

    ServicesSectionDtoOut addNewServicesSection(ServicesSectionDtoIn servicesSectionDtoIn);
    ServicesSectionDtoOut getServicesSectionById(Long id);

    ServicesSection findServicesSectionById(Long id);
}
