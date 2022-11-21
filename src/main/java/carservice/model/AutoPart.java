package carservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "auto_parts")
public class AutoPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_part_id")
    Long id;
    @Column(length = 150, nullable = false)
    String title;
    @Column(length = 5000)
    String description;
    @Column(name = "purchase_price", nullable = false, precision = 2)
    Double purchasePrice;
    @Column(name = "selling_price", nullable = false, precision = 2)
    Double sellingPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auto_parts_section_id", nullable = false)
    AutoPartsSection section;
}
