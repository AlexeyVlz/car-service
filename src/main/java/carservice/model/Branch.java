package carservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id", nullable = false)
    Long id;
    @Column(nullable = false, length = 64, unique = true)
    String title;
    @Column(nullable = false, length = 300)
    String address;
}
