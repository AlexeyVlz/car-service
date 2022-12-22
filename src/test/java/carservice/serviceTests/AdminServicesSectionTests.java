package carservice.serviceTests;

import carservice.model.services.section.ServicesSection;
import carservice.model.services.section.ServicesSectionDtoIn;
import carservice.model.services.section.ServicesSectionDtoOut;
import carservice.repository.ServicesSectionRepository;
import carservice.service.admin.service.section.AdminServicesSectionService;
import carservice.service.admin.service.section.AdminServicesSectionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdminServicesSectionTests {

    ServicesSectionRepository servicesSectionRepository;
    AdminServicesSectionService adminServicesSectionService;

    @BeforeEach
    void beforeEach() {
        servicesSectionRepository = mock(ServicesSectionRepository.class);
        adminServicesSectionService = new AdminServicesSectionServiceImpl(servicesSectionRepository);
    }

    @Test
    void updateServicesSection() {
        ServicesSectionDtoIn servicesSectionDtoIn = new ServicesSectionDtoIn(
                "Ремонт двигателя","Ремонт блока цилиндра", 10_000.00);
        ServicesSection servicesSection = new ServicesSection(
                1L,"Ремонт коробки передач", "замена звездочки", 8_000.00);
        ServicesSectionDtoOut servicesSectionDtoOut = new ServicesSectionDtoOut(
                "Ремонт двигателя","Ремонт блока цилиндра", 10_000.00);
        when(servicesSectionRepository.findById(1L)).thenReturn(Optional.of(servicesSection));
        servicesSection.setTitle("Ремонт двигателя");
        servicesSection.setDescription("Ремонт блока цилиндра");
        servicesSection.setPrice(10_000.00);
        when(servicesSectionRepository.save(servicesSection)).thenReturn(servicesSection);
        Assertions.assertEquals(adminServicesSectionService.updateServicesSection(1L, servicesSectionDtoIn),
                servicesSectionDtoOut);
    }
}
