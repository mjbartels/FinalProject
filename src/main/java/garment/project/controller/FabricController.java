package garment.project.controller;

import garment.project.entity.fabric;
import garment.project.service.FabricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fabrics")
public class FabricController {

    private final FabricService fabricService;

    @Autowired
    public FabricController(FabricService fabricService) {
        this.fabricService = fabricService;
    }

    @GetMapping
    public List<fabric> getAllFabrics() {
        return fabricService.findAllFabrics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<fabric> getFabricById(@PathVariable Long id) {
        return fabricService.findFabricById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public fabric createFabric(@RequestBody fabric fabric) {
        return fabricService.saveFabric(fabric);
    }

    @PutMapping("/{id}")
    public ResponseEntity<fabric> updateFabric(@PathVariable Long id, @RequestBody fabric fabricDetails) {
        return ResponseEntity.ok(fabricService.updateFabric(id, fabricDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFabric(@PathVariable Long id) {
        fabricService.deleteFabric(id);
        return ResponseEntity.noContent().build();
    }
}
