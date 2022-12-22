package carservice.model;

import carservice.model.client.Client;
import carservice.model.employee.Employee;
import carservice.model.services.section.ServicesSection;
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
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_services",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "service_id")}
    )
    private List<ServicesSection> servicesSections;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employees;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_auto_parts",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "auto_part_id")}
    )
    private List<AutoPart> autoParts;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
}
