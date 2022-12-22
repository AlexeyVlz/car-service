package carservice.model.client;


public class ClientDtoOut {

    private final String name;
    private final String surname;
    private final String dateOfBirth;

    public ClientDtoOut(String name, String surname, String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }
}
