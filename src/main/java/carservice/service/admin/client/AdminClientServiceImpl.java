package carservice.service.admin.client;

import carservice.UtilClass;
import carservice.exeption.DataNotFound;
import carservice.model.client.Client;
import carservice.model.client.ClientDtoIn;
import carservice.model.client.ClientDtoOut;
import carservice.model.client.ClientMapping;
import carservice.repository.ClientRepository;
import carservice.service.user.client.UserClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("AdminClientServiceImpl")
public class AdminClientServiceImpl extends UserClientServiceImpl implements AdminClientService{

    @Autowired
    public AdminClientServiceImpl(ClientRepository clientRepository) {
        super(clientRepository);
    }

    @Override
    public ClientDtoOut updateClient(ClientDtoIn clientDtoIn, Long id) {
        Client client = findClientById(id);
        if(clientDtoIn.getName() != null) client.setName(clientDtoIn.getName());
        if(clientDtoIn.getSurname() != null) client.setSurname(clientDtoIn.getSurname());
        if(clientDtoIn.getDateOfBirth() != null)
            client.setDateOfBirth(UtilClass.stringToLocalDate(clientDtoIn.getDateOfBirth()));
        return ClientMapping.toClientDtoOut(clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        if(clientRepository.existsById(id)) clientRepository.deleteById(id);
        else throw new DataNotFound("Клиент с id = " + id + " в базе данных не обнаружен");
    }
}
