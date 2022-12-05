package carservice.model.branch;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "branches")
@AllArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id", nullable = false)
    private Long id;
    @Column(nullable = false, length = 64, unique = true)
    private String title;
    @Column(nullable = false, length = 300)
    private String address;

    public Branch(String title, String address) {
        this.title = title;
        this.address = address;
    }

    public Branch() {

    }
}
