package carservice.model.service;

public class ServiceMapping {

    public static Service toService(ServiceDtoIn serviceDtoIn) {
        return new Service(serviceDtoIn.getTitle(), serviceDtoIn.getDescription(), serviceDtoIn.getPrice());
    }

    public static ServiceDtoOut toServiceDtoOut(Service service) {
        return new ServiceDtoOut(service.getTitle(), service.getDescription(), service.getPrice());
    }
}
