package carservice.serviceTests;

import carservice.model.client.Client;
import carservice.model.client.ClientDtoIn;
import carservice.model.client.ClientDtoOut;
import carservice.repository.ClientRepository;
import carservice.service.admin.client.AdminClientServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdminClientTests {

    ClientRepository clientRepository;
    AdminClientServiceImpl adminClientService;

    @BeforeEach
    void beforeEach() {
        clientRepository = mock(ClientRepository.class);
        adminClientService = new AdminClientServiceImpl(clientRepository);
    }

    @Test
    void updateClient() {
        ClientDtoIn clientDtoIn = new ClientDtoIn("Пётр", "Петров", "01.01.2001");
        ClientDtoOut clientDtoOut = new ClientDtoOut("Пётр", "Петров", "01.01.2001");
        Client client = new Client("Иван", "Иванов", LocalDate.of(2002, 1, 1));
        Client updatedClient = new Client("Пётр", "Петров", LocalDate.of(2001, 1, 1));
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        when(clientRepository
                .save(updatedClient))
                .thenReturn(updatedClient);
        Assertions.assertEquals(clientDtoOut, adminClientService.updateClient(clientDtoIn, 1L));
    }
}
