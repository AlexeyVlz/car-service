package carservice.service.admin.client;

import carservice.model.client.ClientDtoIn;
import carservice.model.client.ClientDtoOut;

public interface AdminClientService {


    ClientDtoOut updateClient(ClientDtoIn clientDtoIn, Long id);

    void deleteClient(Long id);
}
