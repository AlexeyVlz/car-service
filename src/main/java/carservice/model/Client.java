package carservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    Long id;
    @Column(name = "client_name", length = 64, nullable = false)
    String name;
    @Column(name = "client_surname", length = 64, nullable = false)
    String surname;
    @Column(name = "date_of_birth")
    LocalDateTime dateOfBirth;
}
