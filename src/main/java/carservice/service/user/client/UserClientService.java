package carservice.service.user.client;

import carservice.model.client.Client;
import carservice.model.client.ClientDtoIn;
import carservice.model.client.ClientDtoOut;

public interface UserClientService {
    ClientDtoOut addNewClient(ClientDtoIn clientDtoIn);

    ClientDtoOut getClientById(Long id);

    Client findClientById(Long id);
}
