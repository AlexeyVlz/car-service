package carservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    Long id;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    List<Service> services;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    List<Employee> employees;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "auto_part_id", nullable = false)
    List<AutoPart> autoParts;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    Client client;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    Car car;
}
