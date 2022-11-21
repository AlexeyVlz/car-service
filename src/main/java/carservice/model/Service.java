package carservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    Long id;
    @Column(length = 150, nullable = false, unique = true)
    String title;
    @Column(length = 2000)
    String description;
    @Column(nullable = false, precision = 2)
    Double price;
}
