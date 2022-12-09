package carservice.model;


import carservice.model.autopartsection.AutoPartsSection;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "auto_parts")
public class AutoPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_part_id")
    private Long id;
    @Column(length = 150, nullable = false)
    private String title;
    @Column(length = 5000)
    private String description;
    @Column(name = "purchase_price", nullable = false, precision = 2)
    private Double purchasePrice;
    @Column(name = "selling_price", nullable = false, precision = 2)
    private Double sellingPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auto_parts_section_id", nullable = false)
    private AutoPartsSection section;
}
