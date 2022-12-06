package carservice.model.service;

public class ServicesSectionMapping {

    public static ServicesSection toServicesSection(ServicesSectionDtoIn servicesSectionDtoIn) {
        return new ServicesSection(servicesSectionDtoIn.getTitle(),
                servicesSectionDtoIn.getDescription(),
                servicesSectionDtoIn.getPrice());
    }

    public static ServicesSectionDtoOut toServicesSectionDtoOut(ServicesSection servicesSection) {
        return new ServicesSectionDtoOut(servicesSection.getTitle(),
                servicesSection.getDescription(),
                servicesSection.getPrice());
    }
}
