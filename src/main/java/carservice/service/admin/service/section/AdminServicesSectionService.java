package carservice.service.admin.service.section;

import carservice.model.services.section.ServicesSectionDtoIn;
import carservice.model.services.section.ServicesSectionDtoOut;

public interface AdminServicesSectionService {
    ServicesSectionDtoOut updateServicesSection(Long id, ServicesSectionDtoIn servicesSectionDtoIn);

    void deleteServicesSection(Long id);
}
