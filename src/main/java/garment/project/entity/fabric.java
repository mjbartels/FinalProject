package garment.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class fabric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fabricId;

    private String fabricType;
    private String fabricContent;
    private String fabricMaker;
    private String fabricColor;

    @ManyToMany(mappedBy = "fabrics")
    private Set<garment> garments;
}
