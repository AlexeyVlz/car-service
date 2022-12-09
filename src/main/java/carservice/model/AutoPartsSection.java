package carservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "auto_parts_sections")
public class AutoPartsSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_parts_section_id")
    private Long id;
    @Column(length = 150, unique = true)
    private String title;
}
