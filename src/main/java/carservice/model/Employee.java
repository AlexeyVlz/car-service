package carservice.model;

import carservice.model.branch.Branch;
import carservice.model.position.Position;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    @Column(name = "employee_name", length = 64, nullable = false)
    private String name;
    @Column(length = 64, nullable = false)
    private String surname;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Employee() {
    }
}
