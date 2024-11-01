package garment.project.service;

import garment.project.dao.MakeDao;
import garment.project.entity.make;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakeService {

    private final MakeDao makeDao;

    @Autowired
    public MakeService(MakeDao makeDao) {
        this.makeDao = makeDao;
    }

    public List<make> findAllMakes() {
        return makeDao.findAll();
    }

    public Optional<make> findMakeById(Long id) {
        return makeDao.findById(id);
    }

    public make saveMake(make make) {
        return makeDao.save(make);
    }

    public make updateMake(Long id, make makeDetails) {
        return makeDao.findById(id)
            .map(make -> {
                make.setCutTime(makeDetails.getCutTime());
                make.setSewTime(makeDetails.getSewTime());
                make.setPackTime(makeDetails.getPackTime());
                return makeDao.save(make);
            })
            .orElseThrow(() -> new RuntimeException("Make not found"));
    }

    public void deleteMake(Long id) {
        makeDao.deleteById(id);
    }
}
