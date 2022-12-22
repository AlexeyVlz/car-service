package carservice.model.services.section;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "services")
@AllArgsConstructor
public class ServicesSection {

    @Id
    @Column(name = "service_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150, nullable = false)
    private String title;
    @Column(length = 2000)
    private String description;
    @Column(nullable = false, precision = 2)
    private Double price;

    public ServicesSection(String title, String description, Double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public ServicesSection() {
    }
}
