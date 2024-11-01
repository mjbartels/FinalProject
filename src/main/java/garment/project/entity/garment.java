package garment.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class garment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long garmentId;

    private String garmentName;
    private String garmentType;
    private String fabricUse;

    @OneToMany(mappedBy = "garment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<make> makes;

    @ManyToMany
    @JoinTable(
        name = "garment_fabric",
        joinColumns = @JoinColumn(name = "garment_id"),
        inverseJoinColumns = @JoinColumn(name = "fabric_id")
    )
    private Set<fabric> fabrics;
}