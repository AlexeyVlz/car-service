package carservice.model;

import carservice.model.client.Client;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Client owner;
    @Column(name = "car_number", length = 30, nullable = false)
    private String carNumber;
    @Column(length = 30, nullable = false)
    private String brand;
    @Column(length = 50, nullable = false)
    private String model;

    public Car(String carNumber, String brand, String model) {
        this.carNumber = carNumber;
        this.brand = brand;
        this.model = model;
    }

    public Car() {
    }
}
