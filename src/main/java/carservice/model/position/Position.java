package carservice.model.position;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "positions")
public class Position {

    @Id
    @Column(name = "position_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 64, unique = true)
    private String title;

    public Position(String title) {
        this.title = title;
    }

    public Position(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Position() {

    }
}
