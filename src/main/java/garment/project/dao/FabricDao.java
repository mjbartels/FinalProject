package garment.project.dao;

import garment.project.entity.fabric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricDao extends JpaRepository<fabric, Long> {
    
}