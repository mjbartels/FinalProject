package garment.project.service;

import garment.project.dao.GarmentDao;
import garment.project.entity.garment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarmentService {

    private final GarmentDao garmentDao;

    @Autowired
    public GarmentService(GarmentDao garmentDao) {
        this.garmentDao = garmentDao;
    }

    public List<garment> findAllGarments() {
        return garmentDao.findAll();
    }

    public Optional<garment> findGarmentById(Long id) {
        return garmentDao.findById(id);
    }

    public garment saveGarment(garment garment) {
        return garmentDao.save(garment);
    }

    public garment updateGarment(Long id, garment garmentDetails) {
        return garmentDao.findById(id)
            .map(garment -> {
                garment.setGarmentName(garmentDetails.getGarmentName());
                garment.setGarmentType(garmentDetails.getGarmentType());
                garment.setFabricUse(garmentDetails.getFabricUse());
                return garmentDao.save(garment);
            })
            .orElseThrow(() -> new RuntimeException("Garment not found"));
    }

    public void deleteGarment(Long id) {
        garmentDao.deleteById(id);
    }
}