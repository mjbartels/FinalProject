package garment.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long makeId;

    private int cutTime;
    private int sewTime;
    private int packTime;

    @ManyToOne
    @JoinColumn(name = "garment_id")
    private garment garment;
}
