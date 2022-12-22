package carservice.model.client;

import carservice.UtilClass;

import java.time.LocalDate;

public class ClientMapping {

    public static Client toClient(ClientDtoIn clientDtoIn) {
        LocalDate date = UtilClass.stringToLocalDate(clientDtoIn.getDateOfBirth());
        return new Client(clientDtoIn.getName(), clientDtoIn.getSurname(), date);
    }

    public static ClientDtoOut toClientDtoOut(Client client) {
        String date = UtilClass.dateToString(client.getDateOfBirth());
        return new ClientDtoOut(client.getName(), client.getSurname(), date);
    }
}
