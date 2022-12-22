package carservice.service.user.client;

import carservice.exeption.DataNotFound;
import carservice.model.client.Client;
import carservice.model.client.ClientDtoIn;
import carservice.model.client.ClientDtoOut;
import carservice.model.client.ClientMapping;
import carservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("UserClientServiceImpl")
public class UserClientServiceImpl implements UserClientService{

    protected final ClientRepository clientRepository;

    @Autowired
    public UserClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDtoOut addNewClient(ClientDtoIn clientDtoIn) {
        Client client = clientRepository.save(ClientMapping.toClient(clientDtoIn));
        return ClientMapping.toClientDtoOut(client);
    }

    @Override
    public ClientDtoOut getClientById(Long id) {
        return ClientMapping.toClientDtoOut(findClientById(id));
    }

    @Override
    public Client findClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new DataNotFound(String.format(
                "Клиент с id = %d в базе данных не обаружен", id)));
    }
}
