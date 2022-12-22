package carservice.model.client;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ClientDtoIn {

    @NotBlank @NotBlank
    private String name;
    @NotBlank @NotBlank
    private String surname;
    @NotBlank @NotBlank
    private String dateOfBirth;

    public ClientDtoIn(String name, String surname, String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }
}
