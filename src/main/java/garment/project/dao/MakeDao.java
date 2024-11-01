package garment.project.dao;

import garment.project.entity.make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeDao extends JpaRepository<make, Long> {
   
}
