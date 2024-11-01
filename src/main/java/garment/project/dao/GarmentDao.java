package garment.project.dao;

import garment.project.entity.garment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarmentDao extends JpaRepository<garment, Long> {
   
}