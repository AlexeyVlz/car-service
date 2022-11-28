package carservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "services")
public class Service {

    @Id
    @Column(name = "service_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150, nullable = false, unique = true)
    private String title;
    @Column(length = 2000)
    private String description;
    @Column(nullable = false, precision = 2)
    private Double price;
}
