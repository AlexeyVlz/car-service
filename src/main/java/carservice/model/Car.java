package carservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", nullable = false)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    Client owner;
    @Column(name = "car_number", length = 30, nullable = false)
    String carNumber;
    @Column(length = 30, nullable = false)
    String brand;
    @Column(length = 50, nullable = false)
    String model;
}
