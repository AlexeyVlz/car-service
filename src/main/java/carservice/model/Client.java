package carservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private Long id;
    @Column(name = "client_name", length = 64, nullable = false)
    private String name;
    @Column(name = "client_surname", length = 64, nullable = false)
    private String surname;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public Client(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Client() {
    }
}
