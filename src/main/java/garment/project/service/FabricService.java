package garment.project.service;

import garment.project.dao.FabricDao;
import garment.project.entity.fabric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricService {

    private final FabricDao fabricDao;

    @Autowired
    public FabricService(FabricDao fabricDao) {
        this.fabricDao = fabricDao;
    }

    public List<fabric> findAllFabrics() {
        return fabricDao.findAll();
    }

    public Optional<fabric> findFabricById(Long id) {
        return fabricDao.findById(id);
    }

    public fabric saveFabric(fabric fabric) {
        return fabricDao.save(fabric);
    }

    public fabric updateFabric(Long id, fabric fabricDetails) {
        return fabricDao.findById(id)
            .map(fabric -> {
                fabric.setFabricType(fabricDetails.getFabricType());
                fabric.setFabricContent(fabricDetails.getFabricContent());
                fabric.setFabricMaker(fabricDetails.getFabricMaker());
                fabric.setFabricColor(fabricDetails.getFabricColor());
                return fabricDao.save(fabric);
            })
            .orElseThrow(() -> new RuntimeException("Fabric not found"));
    }

    public void deleteFabric(Long id) {
        fabricDao.deleteById(id);
    }
}
